package atsilo.entity;

/*
 *-----------------------------------------------------------------
 * This file is licensed under GPL 3.0:
 * http://www.gnu.org/licenses/gpl-3.0.html
 *-----------------------------------------------------------------
 * FILE: Richiesta.java
 *-----------------------------------------------------------------
 * PROGETTO: Atsilo
 *-----------------------------------------------------------------
 * OWNER
 * Antonio Cesarano, 13/11/2012 (non responsabile)
 *-----------------------------------------------------------------
 */

public class Richiesta {
    private int id;
    private String tipo;
    private String menuRichiesto;
    private String orarioRichiesto;
    private String allegato;
    
    /**
     * La variabile genitore � nulla c'� bisogno di una lettura della classe Genitore
     */
    private Genitore genitore;
    
    /**
     * La variabile servizio � nulla c'� bisogno di una lettura della classe Servizio
     */
    private Servizio servizio;

    /**
     * Costruttore vuoto
     */
    public Richiesta(){
    }

    /**
     * @param id il paramentro � fissato
     * @param tipo il paramentro � fissato
     * @param menuRichiesto il paramentro � fissato
     * @param orarioRichiesto il paramentro � fissato
     * @param allegato il paramentro � fissato
     * @param genitore � settato dopo la lettura 
     * @param servizio � settato dopo la lettura
     */
    public Richiesta(int id, String tipo, String menuRichiesto,
            String orarioRichiesto, String allegato, Genitore genitore,
            Servizio servizio) {
        super();
        this.id = id;
        this.tipo = tipo;
        this.menuRichiesto = menuRichiesto;
        this.orarioRichiesto = orarioRichiesto;
        this.allegato = allegato;
        this.genitore = genitore;
        this.servizio = servizio;
    }


    /**
     * Metodo che setta il valore id
     * @param id il parametro fissato
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metodo che prende il valore Id
     * @return id il parametro inserito
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo che setta il campo tipo
     * @param tipo il parametro fissato
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo che prende il campo tipo
     * @return tipo il parametro inserito
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Metodo che setta il campo menu richiesto
     * @param menuRichiesto il parametro fissato
     */
    public void setMenuRichiesto(String menuRichiesto) {
        this.menuRichiesto = menuRichiesto;
    }

    /**
     * Metodo che prende il campo menurichiesto
     * @return menuRichiesto il parametro inserito
     */
    public String getMenuRichiesto() {
        return menuRichiesto;
    }

    /**
     * Metodo che setta il campo orario richiesto
     * @param orarioRichiesto il parametro fissato
     */
    public void setOrarioRichiesto(String orarioRichiesto) {
        this.orarioRichiesto = orarioRichiesto;
    }

    /**
     * Metodo che prende il valore campo richiesto
     * @return orarioRichiesto il parametro inserito
     */
    public String getOrarioRichiesto() {
        return orarioRichiesto;
    }

    /**
     * Metodo che setta il campo allegato
     * @param allegato il parametro fissato
     */
    public void setAllegato(String allegato) {
        this.allegato = allegato;
    }

    /**
     * Metodo che prende il campo allegato
     * @return allegato il parametro inserito
     */
    public String getAllegato() {
        return allegato;
    }

    /**
     * Metodo che setta il parametro letto dalla classe Genitore
     * @param genitore � settato dopo la lettura
     */
    public void setGenitore(Genitore genitore) {
        this.genitore = genitore;
    }

    /**
     * Metodo che prende il parametro letto dalla classe Genitore
     * @return genitore preso dalla lettura
     */
    public Genitore getGenitore() {
        return genitore;
    }

    /**
     * Metodo che setta il parametro letto dalla classe Servizio
     * @param servizio � settato dopo la lettura
     */
    public void setServizio(Servizio servizio) {
        this.servizio = servizio;
    }

    /**
     * Metodo che prende il parametro letto dalla classe Servizio
     * @return servizio preso dalla lettura
     */
    public Servizio getServizio() {
        return servizio;
    }
}
