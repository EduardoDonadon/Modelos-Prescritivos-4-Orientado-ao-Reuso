package br.ucsal.cepFinder.TUI;

import java.util.Scanner;

import br.ucsal.cepFinder.business.EnderecoBO;

public class EnderecoTUI {
	private static final Scanner sc = new Scanner(System.in);
	
	public static void executar() {
		String estado = receberEstado();
		String cidade = receberCidade();
		String rua = receberRua();
		
		String resposta = EnderecoBO.validar(estado, cidade, rua);

		System.out.println(resposta);
	}
	
	private static String receberEstado() {
		String estado;
		
		System.out.println("Digite o estado (sigla): ");
		estado = sc.nextLine();
		return estado;
	}
	
	private static String receberCidade() {
		String cidade;
		
		System.out.println("Digite o cidade: ");
		cidade = sc.nextLine();
		return cidade;
	}
	
	private static String receberRua() {
		String rua;
		
		System.out.println("Digite o rua: ");
		rua = sc.nextLine();
		return rua;
	}
	
}
