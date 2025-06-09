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
            System.out.println("\n1 - Cadastrar Insumo\n2 - Listar Estoque\n3 - Registrar Movimento\n4 - Login Usuário\n0 - Sair");
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
                case 4 -> loginUsuario();
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
}
