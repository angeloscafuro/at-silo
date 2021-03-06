package atsilo.entity;
import java.util.List;

/*
 *-----------------------------------------------------------------
 * This file is licensed under GPL 3.0:
 * http://www.gnu.org/licenses/gpl-3.0.html
 *-----------------------------------------------------------------
 * FILE: Classe.java
 *-----------------------------------------------------------------
 * PROGETTO: Atsilo
 *-----------------------------------------------------------------
 * OWNER
 * Antonio Cesarano, 14/11/2012 (non responsabile)
 * Mariella Ferrara, 7/12/2012
 *-----------------------------------------------------------------
 */

public class Classe {
    
    /**
     * @attribute id di tipo stringa
     * @attribute statoClasse di tipo int
     */
    private int id;
    private String sezione;
   
    /** 
     * La variabile educatori � settatta a Null quindi c'� bisogno di una lettura
     */
    private List<EducatoreDidattico> educatori;
    
    /**
     * La variabile eventi avr� i valore della lista Evento
     * La variabile eventi � nulla c'� bisogno di una lettura della classe Evento
     */
    private List<Bambino> bambini;

    /**
     * Costruttore vuoto
     */
    public Classe() {
    }

    /**
     * @param id il paramentro � fissato
     * @param educatori � settato dopo la lettura 
     * @param eventi � settato dopo la lettura
     * @param statoClasse � settato dopo la lettura
     */
    public Classe(int id,String sezione, List<EducatoreDidattico> educatori) {
        this.id = id;
        this.educatori = educatori;
        this.sezione=sezione;
    }
    
    
    /**
     * Costruttore senza Id
     * @param educatori � settato dopo la lettura 
     * @param eventi � settato dopo la lettura
     * @param statoClasse � settato dopo la lettura
     */
    public Classe(String sezione, List<EducatoreDidattico> educatori) {
        this.educatori = educatori;
        this.sezione=sezione;
    }
    
    /**
     * Metodo che setta il campo Id
     * @param id il parametro fissato
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metodo che prende il campo Id
     * @return Id il paramentro inserito
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo che setta il parametro letto dalla classe EducatoreDidattico
     * @param educatori � settato dopo la lettura
     */
    public void setEducatori(List<EducatoreDidattico> educatori) {
        this.educatori = educatori;
    }

    /**
     * Metodo che prende il parametro letto dalla classe EducatoreDidattico
     * @return educatori parametro preso dalla lettura
     */
    public List<EducatoreDidattico> getEducatori() {
        return educatori;
    }

    /**
     * @return bambino
     */
    public List<Bambino> getBambino() {
        return bambini;
    }

    /**
     * @param bambino nuovo bambino
     */
    public void setBambino(List<Bambino> bambino) {
        this.bambini = bambino;
    }

   public void aggiungiBambino(int classe, Bambino b){
       bambini.add(b);
   }

   /**
     * Metodo che prende il campo statoClasse
     * @return statoClasse il paramentro inserito
    */
   public String getSezione() {
       return sezione;
   }

   /**
    * Metodo che setta il campo statoClasse
     * @param statoClasse il parametro fissato
         */
   public void setSezione(String sezione) {
       this.sezione = sezione;
   }
   
   
   
   
   
   
}
