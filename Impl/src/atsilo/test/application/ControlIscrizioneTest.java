/*
 *-----------------------------------------------------------------
 * This file is licensed under GPL 3.0:
 * http://www.gnu.org/licenses/gpl-3.0.html
 *-----------------------------------------------------------------
 * FILE: ControlIscrizioneTest.java
 *-----------------------------------------------------------------
 * PROGETTO: Atsilo
 *-----------------------------------------------------------------
 * OWNER
 * Elisa, 05/dic/2012
 * REVISION
 * <nome revisore>, <data revisione>
 *-----------------------------------------------------------------
 */

package atsilo.test.application;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import atsilo.application.ControlIscrizione;
import atsilo.entity.Assenza;
import atsilo.entity.Bambino;
import atsilo.entity.Genitore;
import atsilo.entity.Questionario;
import atsilo.entity.Servizio;
import atsilo.exception.AccountException;
import atsilo.exception.BambinoException;
import atsilo.exception.DBConnectionException;
import atsilo.exception.DomandaIscrizioneException;
import atsilo.exception.GenitoreException;
import atsilo.exception.InserimentoDatiException;
import atsilo.exception.UtenteException;

/**
 * Classe ControlIscrizioneTest
 * <Descrizione classe>
 * 
 * @author Elisa
 * 
 */
public class ControlIscrizioneTest {
    
    ControlIscrizione control = new  ControlIscrizione();
    Genitore g;
    Bambino b;

    
    @Test
    //creazione account normale
    public void creaAccountTest() throws AccountException, DBConnectionException, UtenteException, InserimentoDatiException {
        assertTrue(control.creaAccount("MarioB", new Date(1975, 11, 11), "Mario", "Bianchi", "MSCGNN75H43H654K", "marioB@hotmail.it",
                "Salerno", "0895245687", "italiana", "Via Roma", "56", "85800", "Salerno", "Salerno", "Via Roma",
            "56", "85800", "Salerno", "Salerno"));  
    }
    
    @Test
    //creazione account con valori null
    public void creaAccountTest2() throws AccountException, DBConnectionException, UtenteException, InserimentoDatiException {
        assertTrue(control.creaAccount("MarioB", new Date(1975, 11, 11), "Mario", "Bianchi", "MSCGNN75H43H654K", "marioB@hotmail.it",
                "Salerno", "0895245687", "italiana", null, "56", "85800", "Salerno", "Salerno", "Via Roma",
            "56", "85800", "Salerno", "Salerno"));  
    }

    @Test
    //creazione account con codice fiscale non valido (15 caratteri)
    public void creaAccountTest3() throws AccountException, DBConnectionException, UtenteException, InserimentoDatiException {
        assertTrue(control.creaAccount("MarioB", new Date(1975, 11, 11), "Mario", "Bianchi", "AMSCGNN75H43H654K", "marioB@hotmail.it",
                "Salerno", "0895245687", "italiana","Via Roma", "56", "85800", "Salerno", "Salerno", "Via Roma",
            "56", "85800", "Salerno", "Salerno"));  
    }
    
    @Test
    //creazione account con mail non valida
    public void creaAccountTest4() throws AccountException, DBConnectionException, UtenteException, InserimentoDatiException {
        assertTrue(control.creaAccount("MarioB", new Date(1975, 11, 11), "Mario", "Bianchi", "AMSCG75H43H654K", "marioBhotmail.it",
                "Salerno", "0895245687", "italiana","Via Roma", "56", "85800", "Salerno", "Salerno", "Via Roma",
            "56", "85800", "Salerno", "Salerno"));  
    }
    
    @Test
    //creazione account con cap non valido 
    public void creaAccountTest5() throws AccountException, DBConnectionException, UtenteException, InserimentoDatiException {
        assertTrue(control.creaAccount("MarioB", new Date(1975, 11, 11), "Mario", "Bianchi", "AMSCG75H43H654K", "marioB@hotmail.it",
                "Salerno", "0895245687", "italiana","Via Roma", "56", "858005", "Salerno", "Salerno", "Via Roma",
            "56", "85800", "Salerno", "Salerno"));  
    }
    
    @Test
    //visualizzazione account normale
    public void getAccountTest() throws AccountException, SQLException, DBConnectionException, InserimentoDatiException {
        assertNotNull(control.getAccount("AMSCG75H43H654K"));  
    }
    
    @Test
    //visualizzazione account con codice fiscale non valido
    public void getAccountTest2() throws AccountException, SQLException, DBConnectionException, InserimentoDatiException {
        assertNotNull(control.getAccount("AMS5CG75H43H654K"));  
    }
    
    @Test
    //visualizzazione account con codice fiscale non valido
    public void getDomandaTest() throws DomandaIscrizioneException, DBConnectionException {
        assertNotNull(control.getDomanda(12));  
    }
    
    @Test
    //inserimento iscritto normale
    public void inserisciIscrittoTest() throws BambinoException, DBConnectionException, InserimentoDatiException  {
        assertTrue(control.inserisciIscritto(new Date(1975, 11, 11), "Marco", "Bianchi", "GFTHG75H43H654K", 
                "Salerno", "italiana","Via Roma", "56", "85805", "Salerno", "Salerno", "Via Roma",
            "56", "85800", "Salerno", "Salerno", "Lattanti", 1, g, null));  
    }
    
    @Test
    //inserimento iscritto con codice fiscale non valido
    public void inserisciIscrittoTest1() throws BambinoException, DBConnectionException, InserimentoDatiException  {
        assertTrue(control.inserisciIscritto(new Date(1975, 11, 11), "Marco", "Bianchi", "GFTGHG75H43H654K", 
                "Salerno", "italiana","Via Roma", "56", "85805", "Salerno", "Salerno", "Via Roma",
            "56", "85800", "Salerno", "Salerno", "Lattanti", 1, g, null));  
    }
    
    @Test
    //inserimento iscritto con cap non valido
    public void inserisciIscrittoTest2() throws BambinoException, DBConnectionException, InserimentoDatiException  {
        assertTrue(control.inserisciIscritto(new Date(1975, 11, 11), "Marco", "Bianchi", "GFTHG75H43H654K", 
                "Salerno", "italiana","Via Roma", "56", "8505", "Salerno", "Salerno", "Via Roma",
            "56", "85800", "Salerno", "Salerno", "Lattanti", 1, g, null));  
    }
    
    @Test
    //inserimento domanda di iscrizione normale
    public void inserisciDomandaIscrizioneTest() throws DomandaIscrizioneException, DBConnectionException  {
        assertTrue(control.inserisciDomandaIscrizione(new Date(2012, 8, 8), 2, 50, 10, g, b, "convalidata", "consegnato",
                "mancante", "consegnato", false, false, false, false, false, false, false, false, false, "condizioni", 
                24500, null));             
    }
       
    @Test
    //cancellazione domanda di iscrizione normale
    public void eliminaDomandaIscrizioneTest() throws DomandaIscrizioneException, DBConnectionException, SQLException  {
        assertNotNull(control.eliminaDomandaIscrizione(1));             
    }
    
    @Test
    //cancellazione iscritto normale
    public void eliminaIscrittoTest() throws BambinoException, DBConnectionException, SQLException, InserimentoDatiException  {
        assertNotNull(control.eliminaIscritto("AMSCG75H43H654K"));             
    }
    
    @Test
    //inserimento genitore normale
    public void inserisciGenitoreTest() throws GenitoreException, DBConnectionException, InserimentoDatiException {
        assertTrue(control.inserisciGenitore(new Date(1975, 11, 11), "Mario", "Bianchi", "GFTHG75H43H654K", "marioB@hotmail.it",
                "Salerno", "0896524587", "italiana","Via Roma", "56", "85805", "Salerno", "Salerno", "Via Roma",
            "56", "85800", "Salerno", "Salerno", null, null, "Altro", "Unisa", "residente", "pensione", null, null, "categoria", "pap�"));  
    }
    
    @Test
    //inserimento genitore con codice fiscale non valido
    public void inserisciGenitoreTest2() throws GenitoreException, DBConnectionException, InserimentoDatiException {
        assertTrue(control.inserisciGenitore(new Date(1975, 11, 11), "Mario", "Bianchi", "FTHG75H43H654K", "marioB@hotmail.it",
                "Salerno", "0896524587", "italiana","Via Roma", "56", "85805", "Salerno", "Salerno", "Via Roma",
            "56", "85800", "Salerno", "Salerno", null, null, "Altro", "Unisa", "residente", "pensione", null, null, "categoria", "pap�"));  
    }
    
    @Test
    //inserimento genitore con mail non valida
    public void inserisciGenitoreTest3() throws GenitoreException, DBConnectionException, InserimentoDatiException {
        assertTrue(control.inserisciGenitore(new Date(1975, 11, 11), "Mario", "Bianchi", "GFTHG75H43H654K", "marioB@hotmailit",
                "Salerno", "0896524587", "italiana","Via Roma", "56", "85805", "Salerno", "Salerno", "Via Roma",
            "56", "85800", "Salerno", "Salerno", null, null, "Altro", "Unisa", "residente", "pensione", null, null, "categoria", "pap�"));  
    }
    
    @Test
    //inserimento genitore con cap non valido
    public void inserisciGenitoreTest4() throws GenitoreException, DBConnectionException, InserimentoDatiException {
        assertTrue(control.inserisciGenitore(new Date(1975, 11, 11), "Mario", "Bianchi", "GFTHG75H43H654K", "marioB@hotmail.it",
                "Salerno", "0896524587", "italiana","Via Roma", "56", "85805", "Salerno", "Salerno", "Via Roma",
            "56", "85800", "Salerno", "Salerno", null, null, "Altro", "Unisa", "residente", "pensione", null, null, "categoria", "pap�"));  
    }
    
    @Test
    //visualizzazione stato iscrizione
    public void visualizzaStatoIscrizioneTest() throws DomandaIscrizioneException, DBConnectionException {
        assertNotNull(control.visualizzaStatoIscrizione(12));  
    }
    
}