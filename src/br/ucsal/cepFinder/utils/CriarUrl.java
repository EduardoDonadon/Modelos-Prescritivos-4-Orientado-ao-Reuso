package br.ucsal.cepFinder.utils;

public class CriarUrl {
	public static String executar(String estado, String cidade, String rua) {
    	String url = "";
    	
    	url = "https://viacep.com.br/ws/" + estado + "/" + cidade + "/" + rua + "/json/";
    	    			
    	return url;
    }
}
