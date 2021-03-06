/*
 *-----------------------------------------------------------------
 * This file is licensed under GPL 3.0:
 * http://www.gnu.org/licenses/gpl-3.0.html
 *-----------------------------------------------------------------
 * FILE: Partecipa.java
 *-----------------------------------------------------------------
 * PROGETTO: Atsilo
 *-----------------------------------------------------------------
 * OWNER
 * Fabio Napoli, 17/dic/2012
 * REVISION
 * <nome revisore>, <data revisione>
 *-----------------------------------------------------------------
 */

package atsilo.entity;

import java.sql.Date;


/**
 * Classe Partecipa entity per la tabella "Partecipa"
 * 
 * 
 */
public class Partecipa {
    
    private int evento;
    private Classe classe;
    
    /**
     * 
     */
    public Partecipa() {
    }
    /**
     * Costruttore
     * @param id id evento
     * @param classe classe interessata all'evento
     */
    public Partecipa(Classe classe,int id) {
        super();
        this.evento=id;
        this.classe = classe;
    }

   
    public int getEventoId(){
        return evento;
    }
    public void setEventoId(int i){
        this.evento=i;
    }
    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
   
    
    
    //Logger
    /*
     * private static final java.util.Logger LOG
     *         = Logger.getLogger(Insegna.class.getName());
     */
    
    //Variabili di istanza
    
    
    //Costruttori
    
    
    //Metodi
}
