import Controler.AntesDoJogoC;
import com.google.gson.Gson;
import model.Cena;
import model.Console;
import model.Save;
import repositorio.CenaDAO;
import repositorio.SaveDAO;
import spark.Spark;

public class Main {
    private static final Gson Gson = new Gson();

    public static void main(String[] args) {
        try {
            // Iniciar um novo jogo e obter o estado inicial
            Save save = SaveDAO.novoJogo();

            // Cria um objeto Console e atribui a mensagem inicial da primeira cena
            Console console = new Console();
            console.setMensagem(save.getCenaatual().getDescricao());
            console.setIdSave(save.getIdSave());

            // Converte o objeto Console em JSON
            String consoleJson = Gson.toJson(console);

            // Define a rota principal que retorna a mensagem inicial do jogo
            Spark.get("/", (req, res) -> consoleJson);

            // Define a rota para carregar uma cena específica
            Spark.get("/cena/:id", (req, res) -> {
                Integer idCena = Integer.parseInt(req.params(":id"));
                return Gson.toJson(CenaDAO.FindCenaById(idCena));
            });

            // Define a rota para processar comandos
            Spark.get("/:comando", new AntesDoJogoC());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}