package model;

public class Item {
    private Integer IdItem;
    private String Nome;
    private String Utilize;
    private Integer IdProxiamCena;
    private Integer CenaAtual;

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

    public Integer getIdProxiamCena() {
        return IdProxiamCena;
    }

    public void setIdProxiamCena(Integer idProxiamCena) {
        IdProxiamCena = idProxiamCena;
    }

    public Integer getCenaAtual() {
        return CenaAtual;
    }

    public void setCenaAtual(Integer cenaAtual) {
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
