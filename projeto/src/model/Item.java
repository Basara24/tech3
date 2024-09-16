package model;

public class Item {
    private Integer IdItem;
    private String Nome;
    private String Utilize;
    private Cena IdProxiamCena;
    private Cena CenaAtual;

    public Integer getIdItem() {
        return IdItem;
    }

    public void setIdItem(Integer idItem) {
        IdItem = idItem;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getUtilize() {
        return Utilize;
    }

    public void setUtilize(String utilize) {
        Utilize = utilize;
    }

    public Cena getIdProxiamCena() {
        return IdProxiamCena;
    }

    public void setIdProxiamCena(Cena idProxiamCena) {
        IdProxiamCena = idProxiamCena;
    }

    public Cena getCenaAtual() {
        return CenaAtual;
    }

    public void setCenaAtual(Cena cenaAtual) {
        CenaAtual = cenaAtual;
    }

    @Override
    public String toString() {
        return "Item{" +
                "IdItem=" + IdItem +
                ", Nome='" + Nome + '\'' +
                ", Utilize='" + Utilize + '\'' +
                ", IdProxiamCena=" + IdProxiamCena +
                ", CenaAtual=" + CenaAtual +
                '}';
    }
}
