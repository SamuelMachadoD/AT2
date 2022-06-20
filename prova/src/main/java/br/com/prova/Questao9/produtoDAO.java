package br.com.prova.Questao9;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class produtoDAO {
	private Connection connection;

	public produtoDAO(Connection connection) {
		this.connection = connection;
	}

	
	public List<Produto> Listar(Scanner sc) throws Exception{
		List<Produto> resultados = new ArrayList<>();
		sc.nextLine();
		System.out.println("Digite o nome do produto que você quer procurar: ");
		String n = sc.nextLine();
		
		String sql = "SELECT ID, NOME FROM PRODUTOS WHERE NOME LIKE ?";
	  
		
		try(PreparedStatement stm = connection.prepareStatement(sql)){
			stm.setString(1, n);
			stm.execute();
			try(ResultSet rst = stm.getResultSet()){
				while(rst.next()) {
					Produto resultado = new Produto(rst.getInt(1), rst.getString(2));
					resultados.add(resultado);
				}
			}
		}
		return resultados;
	}
	public boolean ValidaInserir(Scanner sc) throws Exception{
		
		String sql = "SELECT * FROM PRODUTOS";
		
		try(PreparedStatement stm = connection.prepareStatement(sql)){
			stm.execute();
			try(ResultSet rst = stm.getResultSet()){
				if(!rst.next()) {
					throw new BancoVazio("Banco de Dados vazio! Insira 3 produtos.");
				}
			}catch(SQLException | BancoVazio e) {
				System.out.println("Banco de Dados vazio! Insira 3 produtos.");
				return false;
			}
			return true;
		}
	}

	public void Inserir(Scanner sc) throws Exception{
		
		sc.nextLine();
		System.out.println("Digite o nome do produto:");
		String n = sc.nextLine();
		System.out.println("Digite uma descricao:");
		String d = sc.nextLine();
		System.out.println("Digite o valor do desconto:");
		double dp = sc.nextDouble();
		System.out.println("Digite o preço do produto:");
		double p = sc.nextDouble();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		Produto produto = new Produto(n, d, dp, p, dtf.format(LocalDateTime.now()));
		
		String sql = "INSERT INTO PRODUTOS (NOME, DESCRIÇÃO, DESCONTO, PREÇO, DATA_INICIO) VALUES (?,?,?,?,?)";
		
		try(PreparedStatement stm = connection.prepareStatement(sql)){
			
			stm.setString(1, produto.getNome());
			stm.setString(2, produto.getDescricao());
			stm.setDouble(3, produto.getDesconto());
			stm.setDouble(4, produto.getPreco());
			stm.setString(5, produto.getData_inicio());
			stm.execute();
		}
		
	}
	public void Atualizar(Scanner sc) throws Exception {
		
		sc.nextLine();
		System.out.println("Digite o ID do produto: ");
		int id = sc.nextInt();
		String sql = "SELECT ID FROM PRODUTOS WHERE ID = ?";
		
		try(PreparedStatement stm = connection.prepareStatement(sql)){
			stm.setInt(1, id);
			stm.execute();
			try(ResultSet rst = stm.getResultSet()){
				Integer idr = rst.getInt("ID");
			}catch(SQLException | InputMismatchException e) {
				System.out.println("Id não encontrado, por favor digite um id valido");
				Atualizar(sc);
			}
		}
		
		
		sc.nextLine();
		System.out.println("Digite o NOVO nome do produto:");
		String n = sc.nextLine();
		System.out.println("Digite uma NOVA descricao:");
		String d = sc.nextLine();
		System.out.println("Digite o NOVO valor do desconto:");
		double dp = sc.nextDouble();
		System.out.println("Digite o NOVO preço do produto:");
		double p = sc.nextDouble();
		Produto produto = new Produto(n, d, dp, p);
		
		sql = "UPDATE PRODUTOS SET NOME = ?, DESCRIÇÃO = ?, DESCONTO = ?, PREÇO = ? WHERE ID = ?";
		
		try(PreparedStatement stm = connection.prepareStatement(sql)){
			
			stm.setString(1, produto.getNome());
			stm.setString(2, produto.getDescricao());
			stm.setDouble(3, produto.getDesconto());
			stm.setDouble(4, produto.getPreco());
			stm.setInt(5, id);
			stm.execute();
		}
		
	}

	public void Deletar(Scanner sc) throws Exception {

		System.out.println("Digite o ID do produto que você quer excluir: ");
		int id = sc.nextInt();
		
		String sql = "DELETE FROM PRODUTOS WHERE ID = ?";
		
		try(PreparedStatement stm = connection.prepareStatement(sql)){
			
			stm.setInt(1, id);
			stm.execute();
		}
		
	}

}
