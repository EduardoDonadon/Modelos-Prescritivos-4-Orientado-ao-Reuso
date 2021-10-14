package br.ucsal.cepFinder.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import br.ucsal.cepFinder.utils.CriarUrl;

public class Api {
    private static HttpURLConnection connection;
    
    public static String buscarCep(String estado, String cidade, String rua) {
    	BufferedReader reader;
        String line;
        StringBuilder responseContent = new StringBuilder();

        try{
            URL url = new URL(CriarUrl.executar(estado, cidade, rua));
            connection = (HttpURLConnection) url.openConnection();


            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();            

            if(status>299){
            	System.out.println("Falha de comunicacao com a API.");
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while((line= reader.readLine())!=null){
                    responseContent.append(line);
                }
                reader.close();
            }else{
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while((line= reader.readLine())!=null){
                    responseContent.append(line);
                }
                reader.close();
            }          

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }


        String saida = toArray(responseContent.toString())[0].toString();
        
        return saida;
    }    
    
    public static StringBuilder[] toArray(String sb) {
        StringBuilder[] array = new StringBuilder[10];
        int cont = 0;
        String conteudo = sb.toString();
        
        while (cont < 10) {
            int index = conteudo.indexOf(':');
            array[cont] = new StringBuilder();
            int contAspas = 0;
            
            if (index == -1) {
            	return array;
            }
            
            while (index>-1&&contAspas<2){

                if(conteudo.charAt(index)=='"'){
                    contAspas++;
                    index++;
                    if(contAspas==2){
                        conteudo = conteudo.substring(index);
                        cont++;
                    }
                }else{
                    if(contAspas==1){
                        array[cont].append(conteudo.charAt(index));
                        index++;
                    }else{
                        index++;
                    }
                }

            }

        }
        
        return array;
    }
    
}

