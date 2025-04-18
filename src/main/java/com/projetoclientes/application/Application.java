package com.projetoclientes.application;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.projetoclientes.entities.Cliente;

public class Application {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BancoTeste");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();

	private static void mainMenu() {
		StringBuilder str = new StringBuilder();
		str.append("\n+--------------------------+");
		str.append("\n|      Menu Principal      |");
		str.append("\n+--------------------------+");
		str.append("\n| 1 - Cadastrar cliente    |");
		str.append("\n| 2 - Clientes cadastrados |");
		str.append("\n| 3 - Buscar por ID        |");
		str.append("\n| 4 - Fechar programa      |");
		str.append("\n+--------------------------+");
		System.out.println(str);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			mainMenu();

			try {
				System.out.print("\nEscolha uma opção: ");
				Integer escolha = sc.nextInt();
				sc.nextLine();

				switch (escolha) {
				case 1:
					System.out.print("\nNome do cliente: ");
					String nome = sc.nextLine();

					System.out.print("Email: ");
					String email = sc.nextLine();

					System.out.print("Telefone: ");
					String telefone = sc.nextLine();

					System.out.print("Endereço: ");
					String endereco = sc.nextLine();

					// Adicionando dados do cliente na classe
					Cliente cliente = new Cliente(nome, email, telefone, endereco);

					// Persistindo dados diretamente no Banco de Dados
					entityManager.getTransaction().begin();
					entityManager.persist(cliente);
					entityManager.getTransaction().commit();
					System.out.print("\nCliente cadastrado com sucesso!");
					break;

				case 2:
					List<Cliente> clientes = entityManager.createQuery("FROM Cliente", Cliente.class).getResultList();

					if (clientes.isEmpty()) {
						System.out.print("\nNenhum cliente cadastrado no Banco!");
					} else {
						for (Cliente c : clientes) {
							System.out.print("\nClientes cadastrados");
							System.out.print("\nNome do cliente: " + c.getNome());
							System.out.print("\nEmail: " + c.getEmail());
							System.out.print("\nTelefone: " + c.getTelefone());
							System.out.print("\nEndereço: " + c.getEndereco());
							System.out.println();
						}
					}
					break;

				case 3:
					System.out.print("\nInforme o ID do cliente: ");
					Integer id = sc.nextInt();
					sc.nextLine();

					Cliente buscarCliente = entityManager.find(Cliente.class, id);

					if (buscarCliente != null) {
						System.out.print("\nCliente encontrado:");
						System.out.print("\nNome do cliente: " + buscarCliente.getNome());
						System.out.print("\nEmail: " + buscarCliente.getEmail());
						System.out.print("\nTelefone: " + buscarCliente.getTelefone());
						System.out.print("\nEndereço: " + buscarCliente.getEndereco());
					}
					else {
						System.out.print("\nCliente não encontrado!");
					}
					break;
					
				case 4:
					System.out.print("Programa Finalizado!");
					entityManagerFactory.close();
					entityManager.close();
					sc.close();
					System.exit(0);
					break;
				}
			}

			catch (Exception e) {
				System.out.print("\nErro: " + e.getMessage());
			}
		}

	}

}
