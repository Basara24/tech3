package Controler;

import Servisos.ComandoServico;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

public class AntesDoJogoC implements Route {
    @Override
    public Object handle(Request request, Response response) throws Exception {
        String comandoBruto = request.params(":comando");

        ComandoServico comandoServico = new ComandoServico(comandoBruto);
        Gson Gson = new Gson();

        return Gson.toJson(ComandoServico.help());
    }
}
