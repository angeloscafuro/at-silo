package atsilo.entity;

public class ProgrammaEducativoSettimanale {
    /**
     * @attribute
     */
    private String settimana;

    /**
     * @attribute
     */
    private String descrizione;

    /**
     * @attribute
     */
    private String obiettivi;

    /**
     * @attribute
     */
    private Psicopedagogo psicopedagogo;

    /**
     * @attribute
     */
    private int id;

    public ProgrammaEducativoSettimanale() {
    }

    public void setDescrizione(String d) {
    }

    public int getId() {
        return id;
    }

    public void setObiettivi(String o) {
    }

  

    public void setSettimana(String s) {
    }

    public String getObiettivi() {
        return obiettivi;
    }

    public String getSettimana() {
        return settimana;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setPsicopedagogo(Psicopedagogo psicopedagogo) {
        this.psicopedagogo = psicopedagogo;
    }

    public Psicopedagogo getPsicopedagogo() {
        return psicopedagogo;
    }
}