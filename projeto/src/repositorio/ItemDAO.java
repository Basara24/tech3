package repositorio;

import model.Cena;
import model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemDAO {
    public static Item findItemById(Integer id){
        return new Item();
    }

    public static List<Item> FindItensByScena(Cena cena) {
        return new ArrayList<>();
    }
}
