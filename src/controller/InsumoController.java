package controller;

import model.*;
import repository.InsumoRepository;
import service.InsumoService;

import java.util.Scanner;

public class InsumoController {
    private InsumoRepository repo = new InsumoRepository();
    private InsumoService service = new InsumoService(repo);
    private Scanner sc = new Scanner(System.in);
    private boolean usuarioLogado = false; // Controle de login

    public void menu() {
        int opc;
        do {
            System.out.println("\n1 - Cadastrar Insumo\n2 - Listar Estoque\n3 - Registrar Movimento\n4 - Cadastrar Produto Químico\n5 - Cadastrar Insumo Perecível\n6 - Login Usuário \n0 - Sair");
            opc = sc.nextInt();
            sc.nextLine();
            switch (opc) {
                case 1 -> {
                    if (usuarioLogado) {
                        cadastrar();
                    } else {
                        System.out.println("Você precisa estar logado para cadastrar um insumo.");
                    }
                }
                case 2 -> {
                    if (usuarioLogado) {
                        listar();
                    } else {
                        System.out.println("Você precisa estar logado para listar o estoque.");
                    }
                }
                case 3 -> {
                    if (usuarioLogado) {
                        movimentar();
                    } else {
                        System.out.println("Você precisa estar logado para registrar um movimento.");
                    }
                }
                case 4 -> {
                    if (usuarioLogado) {
                        cadastrarProdutoQuimico();
                    } else {
                        System.out.println("Você precisa estar logado para registrar um produto químico.");
                    }
                }
                case 5 -> {
                    if (usuarioLogado) {
                        cadastrarInsumoPerecivel();
                    } else {
                        System.out.println("Você precisa estar logado para registrar um produto perecível.");
                    }
                }
                case 6 -> loginUsuario();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opc != 0);
    }

    private void cadastrar() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Quantidade: ");
        int qtd = sc.nextInt();
        sc.nextLine();

        repo.salvar(new Insumo(id, nome, qtd));
        System.out.println("Cadastrado com sucesso!");
    }

    private void listar() {
        for (Insumo i : repo.listarTodos()) {
            System.out.println(i);
        }
    }

    private void movimentar() {
        System.out.print("ID do insumo: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Quantidade: ");
        int qtd = sc.nextInt();
        sc.nextLine();
        System.out.print("Tipo (ENTRADA/SAIDA): ");
        String tipo = sc.nextLine();

        service.registrarMovimento(id, qtd, tipo);
    }

    private void loginUsuario() {
        System.out.println("Nome Usuário: ");
        String nomeUsuario = sc.nextLine();
        System.out.println("Cargo: ");
        String cargoUsuario = sc.nextLine();
        System.out.println("CPF Usuário (somente números): ");
        String cpfUsuario = sc.nextLine();
        Usuario user = new Usuario(nomeUsuario, cargoUsuario, cpfUsuario);
        user.login();
        usuarioLogado = true; // Marca o usuário como logado
        System.out.println("Login realizado com sucesso!");
    }

    private void cadastrarProdutoQuimico() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Quantidade: ");
        int qtd = sc.nextInt();
        sc.nextLine();
        System.out.print("Nível Toxicidade: ");
        int toxicidade = sc.nextInt();

        ProdutoQuimico pq = new ProdutoQuimico(id, nome, qtd, toxicidade);
        repo.salvar(pq);
        System.out.println("Produto químico cadastrado com sucesso!");
    }

    private void cadastrarInsumoPerecivel() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Quantidade: ");
        int qtd = sc.nextInt();
        sc.nextLine();
        System.out.print("Data de validade (yyyy-MM-dd): ");
        String dataValidade = sc.nextLine();

        InsumoPerecivel ip = new InsumoPerecivel(id, nome, qtd, dataValidade);
        repo.salvar(ip);
        System.out.println("Insumo perecível cadastrado com sucesso!");
    }

}
