package br.ucsal;

import java.util.Scanner;

public class Auth {
  private static Scanner sc = new Scanner(System.in);
	
  private static String[] getAuthKeys() {
    String[] keys = new String[2];

    System.out.println("Digite o usuario: ");
    keys[0] = sc.nextLine();
    
    System.out.println("Digite a senha: ");
    keys[1] = sc.nextLine();

    return keys;
  }

  public static void login() {
    boolean isLoggedIn = false;
    String[] keys = new String[2];

    do {
      keys = getAuthKeys();

      if (keys[0].equals("user") && keys[1].equals("123")) {
        isLoggedIn = true;
      } else {
        System.out.println("Credenciais erradas, tente novamente!");
      }
    } while (!isLoggedIn);
  }
}
