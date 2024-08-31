package controllers;

import java.util.Scanner;
import java.util.UUID;

import entities.Produto;
import repositories.ProdutoRepository;

public class ProdutoController {

	private Scanner scanner = new Scanner(System.in);

	public void cadastrarProduto() {

		try {

			System.out.println("\nCADASTRO DE PRODUTO:\n");

			System.out.println("Nome do Produto.......:");
			var nome = scanner.nextLine();

			System.out.println("Preço.........:");
			var preco = Double.parseDouble(scanner.nextLine());

			System.out.println("Quantidade........:");
			var quantidade = Integer.parseInt(scanner.nextLine());
			
		

			var produto = new Produto(UUID.randomUUID(), nome, preco, quantidade);

			var produtoRepository = new ProdutoRepository();
			produtoRepository.inserir(produto);

		}

		catch (Exception e) {

			System.out.println("\nFalha ao cadastrar o produto!");
			System.out.println(e.getMessage());

		}
	}

	public void atualizarProduto() {

		try {

			System.out.println("ATUALIZAÇÃO DE PRODUTOS:");

			System.out.println("Informe o ID do produto.:");
			var id = UUID.fromString(scanner.nextLine());

			var produtoRepository = new ProdutoRepository();
			var produto = produtoRepository.obterPorId(id);

			if (produto != null) {

				System.out.println("\nDADOS DO PRODUTO:");
				System.out.println("\nId........:" + produto.getId());
				System.out.println("\nNOME......:" + produto.getNome());
				System.out.println("\nPREÇO.....:" + produto.getPreco());
				System.out.println("\nQUANTIDADE....:" + produto.getQuantidade());
				System.out.println("");

				System.out.print("ALTERE O NOME.........: ");
				produto.setNome(scanner.nextLine());

				System.out.print("ALTERE O PREÇO........: ");
				produto.setPreco(Double.parseDouble(scanner.nextLine()));

				System.out.print("ALTERE A QUANTIDADE...: ");
				produto.setQuantidade(Integer.parseInt(scanner.nextLine()));
				
				produtoRepository.atualizar(produto);

			}

			else {

				System.out.println("\nProduto não encontrado. Verifique o ID informado.");
			}

		}

		catch (Exception e) {
			System.out.println("\nFalha aon cadastrar produto!");
			System.out.println(e.getMessage());

		}
	}
	
	public void excluirProduto() {

		try {

			System.out.println("EXCLUSÃO DE PRODUTOS:");

			System.out.println("Informe o ID do produto.:");
			var id = UUID.fromString(scanner.nextLine());

			var produtoRepository = new ProdutoRepository();
			var produto = produtoRepository.obterPorId(id);

			if (produto != null) {

				System.out.println("\nDADOS DO PRODUTO:");
				System.out.println("\nId........:" + produto.getId());
				System.out.println("\nNOME......:" + produto.getNome());
				System.out.println("\nPREÇO.....:" + produto.getPreco());
				System.out.println("\nQUANTIDADE....:" + produto.getQuantidade());
				System.out.println("");

				
				
				produtoRepository.excluir(produto.getId());

			}

			else {

				System.out.println("\nProduto não encontrado. Verifique o ID informado.");
			}

		}

		catch (Exception e) {
			System.out.println("\nFalha ao excluir produto!");
			System.out.println(e.getMessage());

		}
	}
	
	public void consultarProdutos() {
		
		try {
			
			System.out.println("\nCONSULTA DE PRODUTOS:\n");
			
			var produtoRepository = new ProdutoRepository();
			var lista = produtoRepository.consultar();
			
			for (Produto produto : lista) {
				
				System.out.println("ID....:" + produto.getId());
				System.out.println("NOME....:" + produto.getNome());
				System.out.println("PRECÇO.....:" + produto.getPreco());
				System.out.println("QUANTIDADE........:" + produto.getQuantidade());
				System.out.println("");
			}
			
		}
		
		catch (Exception e) {
			
			System.out.println("\nFalha ao consultar produtos!");
			System.out.println(e.getMessage());
		}
	}
	

}
