package br.ucsal.cepFinder.utils;

public class RemoverEspaco {	
	public static String executar(String linha) {
		String linhaSemEspaco = "";
		String letra;
		
		for(int i = 0; i < linha.length(); i++) {
			letra = linha.substring(i, i+1);
			
			if(letra.equals(" ")){
				linhaSemEspaco += "%20";
			} else {
				linhaSemEspaco += letra;
			}
			
		}
		
		return linhaSemEspaco;
	}
}
