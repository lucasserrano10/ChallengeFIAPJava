package repository;

import model.Insumo;
import java.util.*;

public class InsumoRepository {
    private Map<Integer, Insumo> estoque = new HashMap<>();

    public void salvar(Insumo insumo) {
        estoque.put(insumo.getId(), insumo);
    }

    public Insumo buscar(int id) {
        return estoque.get(id);
    }

    public Collection<Insumo> listarTodos() {
        return estoque.values();
    }
}
