package service;

import model.Insumo;
import model.Movimento;
import repository.InsumoRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InsumoService {
    private InsumoRepository repo;

    public InsumoService(InsumoRepository repo) {
        this.repo = repo;
    }

    public void registrarMovimento(int id, int qtd, String tipo) {
        Insumo insumo = repo.buscar(id);
        if (insumo != null) {
            if (tipo.equals("ENTRADA")) {
                insumo.adicionarQuantidade(qtd);
            } else if (tipo.equals("SAIDA")) {
                insumo.removerQuantidade(qtd);
            }
            System.out.println(new Movimento(id, qtd, tipo, LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))));
        } else {
            System.out.println("Insumo não encontrado.");
        }
    }
}
