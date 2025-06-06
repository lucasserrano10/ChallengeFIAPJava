import controller.InsumoController;
import model.Usuario;

public class Main {
    public static void main(String[] args) {
        Usuario user = new Usuario("Lucas", "Auxiliar de Estoque");
        user.login();

        InsumoController controller = new InsumoController();
        controller.menu();
    }
}
