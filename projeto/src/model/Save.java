package model;

public class Save {
    private Integer idSave;
    private Cena cenaatual;

    public Integer getIdSave() {
        return idSave;
    }

    public void setIdSave(Integer idSave) {
        this.idSave = idSave;
    }



    public Cena getCenaatual() {
        return cenaatual;
    }

    public void setCenaatual(Cena cenaatual) {
        this.cenaatual = cenaatual;
    }
    @Override
    public String toString() {
        return "Save{" +
                "idSave=" + idSave +
                ", cenaatual=" + cenaatual +
                '}';
    }
}
