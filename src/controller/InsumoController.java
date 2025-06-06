package controller;

import model.*;
import repository.InsumoRepository;
import service.InsumoService;

import java.util.Scanner;

public class InsumoController {
    private InsumoRepository repo = new InsumoRepository();
    private InsumoService service = new InsumoService(repo);
    private Scanner sc = new Scanner(System.in);

    public void menu() {
        int opc;
        do {
            System.out.println("\n1 - Cadastrar Insumo\n2 - Listar Estoque\n3 - Registrar Movimento\n0 - Sair");
            opc = sc.nextInt();
            sc.nextLine();
            switch (opc) {
                case 1 -> cadastrar();
                case 2 -> listar();
                case 3 -> movimentar();
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
}
