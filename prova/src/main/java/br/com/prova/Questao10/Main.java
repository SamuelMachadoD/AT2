package br.com.prova.Questao10;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception{
		String mensagem;
		char[] texto;
		Scanner sc = new Scanner(System.in);
		int chateado = 0 , divertido = 0;
		System.out.println("Digite sua mensagem:");
		try {
			mensagem = sc.nextLine();
			texto = mensagem.toCharArray();
		} catch (Exception ex) {
			System.out.println("Mensagem invalida, por favor tente novamnete!");
			mensagem = sc.nextLine();
			texto = mensagem.toCharArray();
		}
		
		for (char a : texto) {
			if(a == '(') {
				chateado++;
			}else if(a== ')') {
				divertido++;
			}
		}
		if(chateado < divertido) {
			System.out.println("Divertido");
		}else if(chateado > divertido) {
			System.out.println("Chateado");
		}else {
			System.out.println("neutro");
		}

	}

}
