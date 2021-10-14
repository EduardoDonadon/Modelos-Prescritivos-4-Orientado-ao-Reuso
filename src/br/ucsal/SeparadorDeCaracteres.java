package br.ucsal;

import java.util.Scanner;

public class SeparadorDeCaracteres {
	private static Scanner sc = new Scanner(System.in);
	
    public static void main(String[] args) throws Exception {
        execute();
    }
    
    public static void execute() {
        Auth.login();

        System.out.println("\n\n\t --==Separador de caracteres==--\n");
        
        String input = userInput();
        String numbers = getNumbers(input);
        String text = removeNumbers(input);

        System.out.println("Numeros da frase: " + numbers);
        System.out.println("Frase sem numeros: " + text);
    }

    public static String userInput() {
        String input;

        System.out.println("Digite uma frase: ");
        input = sc.nextLine();

        return input;        
    }

    public static String getNumbers(String word) {
        String numbers = "";
        
        for (int i = 0; i < word.length(); i++) {
            int ascNumber = (int) word.charAt(i);
            
            if ((ascNumber >= 48 && ascNumber <= 57)) {       
                numbers += word.substring(i, i+1);
            }
        }

        return numbers;
    }

    public static String removeNumbers(String word) {
        String text = "";
        
        for (int i = 0; i < word.length(); i++) {
            int ascNumber = (int) word.charAt(i);
            
            if ((ascNumber < 48 || ascNumber > 57)) {       
                text += word.substring(i, i+1);
            }
        }

        return text;
    }
}
