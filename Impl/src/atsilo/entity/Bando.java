package atsilo.entity;

/*
 *-----------------------------------------------------------------
 * This file is licensed under GPL 3.0:
 * http://www.gnu.org/licenses/gpl-3.0.html
 *-----------------------------------------------------------------
 * FILE: Bando.java
 *-----------------------------------------------------------------
 * PROGETTO: Atsilo
 *-----------------------------------------------------------------
 * OWNER
 * Antonio Barba, 13/11/2012 (non responsabile)
 * REVISION
 * Andrea Micco, 5/12/2012
 *-----------------------------------------------------------------
 */

public class Bando implements Beans {
    
    /**
     * @attribute identificativo di tipo intero
     */
    private int id;
    
    /**
     * @attribute DataInizioBando di tipo stringa
     */
    private String dataInizioBando;
    
    /**
     * @attribute DataFineBando di tipo stringa
     */
    private String dataFineBando;
    
    /**
     * @attribute DataInizioPresentazioneRinuncia di tipo stringa
     */
    private String dataInizioPresentazioneRinuncia;
    
    /**
     * @attribute DataFinePresentazioneRinuncia di tipo stringa
     */
    private String dataFinePresentazioneRinuncia;
    
    /**
     * @attribute DataFineRinuncia di tipo stringa
     */
    private String dataFineRinuncia;
    
    /**
     * @attribute postiDisponibili di tipo intero
     */
    private int postiDisponibili;
    
    /**
     * @attribute path di tipo stringa
     */
    private String path;
    
    /**
     * Costruttore vuoto
     */
    public Bando() {
    }
    
    /**
     * 
     * @param id parametro fissato
     * @param dataInizioBando il parametro fissato
     * @param dataFineBando il parametro fissato
     * @param dataInizioPresentazioneRinuncia il parametro fissato
     * @param dataFinePresentazioneRinuncia il parametro fissato
     * @param dataFineRinuncia il parametro fissato
     * @param postiDisponibili il parametro fissato
     * @param path il parametro fissato
     */
    public Bando(int id, String dataInizioBando, String dataFineBando, String dataInizioPresentazioneRinuncia, 
            String dataFinePresentazioneRinuncia, String dataFineRinuncia, int postiDisponibili,
            String path) {
        super();
        this.id = id;
        this.dataInizioBando = dataInizioBando;
        this.dataFineBando = dataFineBando;
        this.dataInizioPresentazioneRinuncia = dataInizioPresentazioneRinuncia;
        this.dataFinePresentazioneRinuncia = dataFinePresentazioneRinuncia;
        this.dataFineRinuncia = dataFineRinuncia;
        this.postiDisponibili = postiDisponibili;
        this.path = path;
    }

    /**
     * Metodo che prende il valore Classe
     * @return classe il parametro inserito
     */
    public int getId() {
            return id;
    }

    /**
     * Metodo che setta il valore Id
     * @param iD il parametro fissato
     */
    public void setId(int iD) {
            this.id = iD;
    }

    /**
     * Metodo che prende il campo DataInizio
     * @return DataInizioBando il parametro inserito
     */
    public String getDataInizioBando() {
            return dataInizioBando;
    }

    /**
     * Metodo che setta il campo DataInizio
     * @param dataInizioBando il parametro fissato
     */
    public void setDataInizioBando(String dataInizioBando) {
            this.dataInizioBando = dataInizioBando;
    }

    /**
     * Metodo che prende il campo DataFine
     * @return DataFineBando il parametro inserito
     */
    public String getDataFineBando() {
            return dataFineBando;
    }
    
    /**
     * Metodo che setta il campo DataFine
     * @param dataFineBando il parametro fissato
     */
    public void setDataFineBando(String dataFineBando) {
            this.dataFineBando = dataFineBando;
    }
    
    /**
     * Metodo che prende il campo DataInizioPresentazioneRinuncia
     * @return DataInizioPresentazioneRinuncai il parametro inserito
     */
    public String getDataInizioPresentazioneRinuncia() {
            return dataInizioPresentazioneRinuncia;
    }
    
    /**
     * Metodo che setta il campo DataFine
     * @param dataFineBando il parametro fissato
     */
    public void setDataInizioPresentazioneRinuncia(String dataInizioPresentazioneRinuncia) {
            this.dataInizioPresentazioneRinuncia = dataInizioPresentazioneRinuncia;
    }
    
    /**
     * Metodo che prende il campo DataFinePresentazioneRinuncia
     * @return DataFinePresentazioneRinuncia il parametro inserito
     */
    public String getDataFinePresentazioneRinuncia() {
            return dataFinePresentazioneRinuncia;
    }
    
    /**
     * Metodo che setta il campo DataFine
     * @param dataFinePresentazioneRinuncia il parametro fissato
     */
    public void setDataFinePresentazioneRinuncia(String dataFinePresentazioneRinuncia) {
            this.dataFinePresentazioneRinuncia = dataFinePresentazioneRinuncia;
    }
    
    /**
     * Metodo che prende il campo DataFineRinuncia
     * @return DataFineRinuncia il parametro inserito
     */
    public String getDataFineRinuncia() {
            return dataFineRinuncia;
    }
    
    /**
     * Metodo che setta il campo DataFine
     * @param dataFineRinuncia il parametro fissato
     */
    public void setDataFineRinuncia(String dataFineRinuncia) {
            this.dataFineRinuncia = dataFineRinuncia;
    }
    
    /**
     * Metodo che prende il campo postiDisponibili
     * @return postiDisponibili il parametro inserito
     */
    public int getPostiDisponibili() {
            return postiDisponibili;
    }

    /**
     * Metodo che setta il valore postiDisponibili
     * @param postiDisponibili il parametro fissato
     */
    public void setPostiDisponibili(int postiDisponibili) {
            this.postiDisponibili = postiDisponibili;
    }
    
    /**
     * Metodo che prende il campo path
     * @return path il parametro inserito
     */
    public String getPath() {
            return path;
    }

    /**
     * Metodo che setta il valore path
     * @param path il parametro fissato
     */
    public void setPath(String path) {
            this.path = path;
    }
}
