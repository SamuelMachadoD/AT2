package br.com.prova.Questao9;

import java.util.List;
import java.util.Scanner;

public class Menu {
	Boolean inseriu = false;
	@Override
	public String toString() {
		return "-----------------------------"
				+ "\nEscolha uma opção: \n"
				+ "-----------------------------\n"
				+ "1 - INSERIR ofertas \n"
				+ "2 - ATUALIZAR ofertas \n"
				+ "3 - DELETAR ofertas \n"
				+ "4 - LISTAR ofertas \n"
				+ "5 - SAIR"
				+ "\n-----------------------------";
	}
	
	public boolean VerificaEntrada(int entrada, produtoDAO pd, Scanner sc) throws Exception {
		
		switch (entrada) {
		case 1:
			if(pd.ValidaInserir(sc)) {
				pd.Inserir(sc);
			}else{
				for(int i = 0; i < 3; i++) {
					pd.Inserir(sc);
				}
			}
			return false;
		case 2:
			pd.Atualizar(sc);
			return false;
		case 3:
			pd.Deletar(sc);
			return false;
		case 4:
			List<Produto> listaDeProdutos = pd.Listar(sc);
			listaDeProdutos.stream().forEach(lp -> 
				System.out.println(lp));
			return false;
		case 5:
			System.exit(0);
		default:
			System.out.println("Entrada invalida, digite novamente!");
			return false;
		}
	}
}
