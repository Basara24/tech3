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
            Save save = SaveDAO.novoJogo();

            Console console = new Console();
            console.setMensagem("Digite start para começar ou Digite help para receber comandos");
            console.setIdSave(save.getIdSave());

            String consoleJson = Gson.toJson(console);

            Spark.get("/", (req, res) -> consoleJson);

            Spark.get("/cena/:id", (req, res) -> {
                Integer idCena = Integer.parseInt(req.params(":id"));
                return Gson.toJson(CenaDAO.FindCenaById(idCena));
            });

            Spark.get("/:comando", new AntesDoJogoC());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}