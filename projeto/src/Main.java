import Controler.AntesDoJogoC;
import com.google.gson.Gson;
import model.Cena;
import model.Item;
import model.Save;
import repositorio.CenaDAO;
import repositorio.ItemDAO;
import repositorio.SaveDAO;
import spark.Spark;

import java.sql.SQLException;
import java.util.List;

public class Main {
    private static  final Gson Gson = new  Gson();
    public static void main(String[] args) {

        try {
            Save save = SaveDAO.novoJogo();
            String saveJson = Gson.toJson(save);
            Spark.get("/", (req, res) -> saveJson);

            Spark.get("cena/:id", (req,res) ->{
                Integer idCena = Integer.parseInt(req.params(":id"));
                return Gson.toJson(CenaDAO.FindCenaById(idCena));
            });

            Spark.get("/:comando", new AntesDoJogoC());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
