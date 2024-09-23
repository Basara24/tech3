package Servisos;

import com.google.gson.Gson;
import model.Console;

public class ComandoServico {
    private String[] comando;

    public ComandoServico(String comandoBruto){
        this.comando = comandoBruto.split(" ");
    }

    public static Console help(){
        Console console = new Console();
        console.setMensagem("aaah test");
        return console;
    }
}
