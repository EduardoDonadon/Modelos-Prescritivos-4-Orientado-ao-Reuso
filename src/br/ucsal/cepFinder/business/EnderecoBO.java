package br.ucsal.cepFinder.business;

import br.ucsal.cepFinder.services.Api;
import br.ucsal.cepFinder.utils.RemoverEspaco;

public class EnderecoBO {
	public static String validar(String estado, String cidade, String rua) {
		if(estado.length() != 2) {
			return "Estado invalido, digite a sigla do estado. Ex: Bahia -> BA";			
		}
		
		String cidadeFormatada = RemoverEspaco.executar(cidade);
		String ruaFormatada = RemoverEspaco.executar(rua);
		
		String resposta = Api.buscarCep(estado, cidadeFormatada, ruaFormatada);
		
		if (resposta.equals("")) {
			return "O endereco nao existe, verifique se digitou corretamente.";
		}
		
		String respostaFormatada = "O CEP para seu logradouro é: " + resposta;
		
		return respostaFormatada;
	}
}
