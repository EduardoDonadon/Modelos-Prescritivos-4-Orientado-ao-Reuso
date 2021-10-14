package br.ucsal.cepFinder.TUI;

import java.util.Scanner;

import br.ucsal.Auth;

public class MenuTUI {
	private static final Scanner sc = new Scanner(System.in);

	public static void executar(){
		Auth.login();
		menu();
	}
	
    private static void menu(){
		int op;
		
		do {
			mostrarOpcoes();
			op = sc.nextInt();
			
			if (op == 1) {
				EnderecoTUI.executar();			
			}
			
		} while (op != 2);
		
		System.out.println("Programa finalizado");
	}
	

	private static void mostrarOpcoes() {
		System.out.println("Digite a opção desejada:\n1 - Buscar CEP\n2 - Sair");
	}
	
	
}
