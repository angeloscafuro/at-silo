package atsilo.entity;

public class Servizio {
    private String orarioInizio;
    private String orarioFine;
    private String pianoPasto;
    private Bambino bambino;

    public Servizio(){}
    

    public String getOrarioInizio() {
            return orarioInizio;
    }
    public void setOrarioInizio(String orarioInizio) {
            this.orarioInizio = orarioInizio;
    }
    public String getOrarioFine() {
            return orarioFine;
    }
    public void setOrarioFine(String orarioFine) {
            this.orarioFine = orarioFine;
    }
    public String getPianoPasto() {
            return pianoPasto;
    }
    public void setPianoPasto(String pianoPasto) {
            this.pianoPasto = pianoPasto;
    }

    public Bambino getBambino() {
            return bambino;
    }

    public void setBambino(Bambino bambino) {
            this.bambino = bambino;
    }
}