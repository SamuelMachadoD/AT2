package br.com.prova.Questao9;

import java.sql.Connection;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MAIN {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		try (Connection con = new ConnectionFactory().RecuperaConexão()) {
			produtoDAO pd = new produtoDAO(con);
			Menu menu = new Menu();
			System.out.println(menu);
			try {
				while (!menu.VerificaEntrada(sc.nextInt(), pd, sc)) {
					System.out.println(menu);
					menu.VerificaEntrada(sc.nextInt(), pd, sc);
				}
			}catch(Exception ex) {
				System.out.println("Opção invalida, digite um numero valido");
			}
			
			
			sc.close();
		}

	}

}