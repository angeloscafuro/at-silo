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
 * Classe Insegna entity per la tabella "Insegna"
 * <Descrizione classe>
 * 
 * @author Alfonso
 * 
 */
public class Partecipa {
    
    private Date eventoData;
    private Classe classe;
    private String eventoNome;
    
    /**
     * 
     */
    public Partecipa() {
        // TODO Scheletro di costruttore autogenerato
    }
    
    public Partecipa(Date eventoData, Classe classe,String eventoNome) {
        super();
        this.eventoData=eventoData;
        this.classe = classe;
        this.eventoNome=eventoNome;
    }

    public Date getEventoData() {
        return eventoData;
    }

    public void setEventoData(Date date) {
        this.eventoData = date;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
    public String getEventoNome() {
        return eventoNome;
    }

    public void setEventoNome(String nome) {
        this.eventoNome = eventoNome;
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