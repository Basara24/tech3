package model;

import java.util.List;

public class Cena {
    private Integer idcena;
    private String descricao;
    private List<Item> Itens;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getIdcena() {
        return idcena;
    }

    public void setIdcena(Integer idcena) {
        this.idcena = idcena;
    }

    public List<Item> getItens() {
        return Itens;
    }

    public void setItens(List<Item> itens) {
        Itens = itens;
    }

    @Override
    public String toString() {
        return "Cena{" +
                "idcena=" + idcena +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
