/*
 *-----------------------------------------------------------------
 * This file is licensed under GPL 3.0:
 * http://www.gnu.org/licenses/gpl-3.0.html
 *-----------------------------------------------------------------
 * FILE: Utente.java
 *-----------------------------------------------------------------
 * PROGETTO: Atsilo
 *-----------------------------------------------------------------
 * OWNER
 * Elisa, 01/dic/2012
 * REVISION
 * <nome revisore>, <data revisione>
 *-----------------------------------------------------------------
 */

package test.storage;

import atsilo.entity.Account;
import atsilo.entity.Utente;
import atsilo.storage.Database;

public class StubUtente
{
   Utente u;
    Database database;
    
    public StubUtente(Database db){
        database=db;
        u = new Utente();
    }
        
    public Utente ricercaUtente(String cf){
        return u;
    }
    
    public boolean inserisci(Utente u){
        return true;
    }
    

}