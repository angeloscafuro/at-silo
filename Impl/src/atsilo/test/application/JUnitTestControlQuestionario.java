/*
 *-----------------------------------------------------------------
 * This file is licensed under GPL 3.0:
 * http://www.gnu.org/licenses/gpl-3.0.html
 *-----------------------------------------------------------------
 * FILE: JUnitTestControlQuestionario.java
 *-----------------------------------------------------------------
 * PROGETTO: Atsilo
 *-----------------------------------------------------------------
 * OWNER
 * Antonio, 15/dic/2012
 * REVISION
 * <nome revisore>, <data revisione>
 *-----------------------------------------------------------------
 */

package atsilo.test.application;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import atsilo.application.ControlQuestionario;
import atsilo.entity.CampoDomandaQuestionario;
import atsilo.entity.DomandaQuestionario;
import atsilo.entity.Questionario;
import atsilo.entity.RispostaQuestionario;
import atsilo.entity.StatisticheQuestionario;
import atsilo.exception.DBConnectionException;
import atsilo.exception.QuestionarioException;
import atsilo.storage.Database;

/**
 * Classe JUnitTestControlQuestionario
 * <Descrizione classe>
 * 
 * @author Antonio
 * 
 */
public class JUnitTestControlQuestionario {
    
    
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
       if(! db.apriConnessione())
           LOG.info("connessione al db fallita");
           
    }
    
    
    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        db.chiudiConnessione();
    }
    
    
    /**
     * Test method for {@link atsilo.application.ControlQuestionario#inserisciQuestionario(atsilo.entity.Questionario)}.
     * @throws QuestionarioException 
     * @throws DBConnectionException 
     * @throws SQLException 
     */
    //@Test  //OK
    public void testInserisciQuestionario() throws DBConnectionException, QuestionarioException, SQLException {
      
        Calendar dataIn = Calendar.getInstance();
        dataIn.set(2012, 11, 1);
        Calendar dataFin = Calendar.getInstance();
        dataFin.set(2012, 11, 11);
        Date dataInI= new Date(dataIn.getTimeInMillis());
        Date dataFini= new Date(dataFin.getTimeInMillis());

        Questionario questionario = new Questionario("Controllo qualita", null, "Qualita",25,  dataInI, dataFini);
        
        control.inserisciQuestionario(questionario);
        Questionario temp = control.getQuestionario(25);
        
        assertEquals(25, temp.getId());
    }
    
    
    
    
    
    
    /**Creo un nuovo questionario, lo inserisco nel DB, lo elimino
     *  dopodich� cerco di caricarlo. Se il caricamento fallisce allora � stato 
     *  eliminato correttamente.
     *   
     * Test method for {@link atsilo.application.ControlQuestionario#eliminaQuestionario(int)}.
     * @throws QuestionarioException 
     * @throws DBConnectionException 
     * @throws SQLException 
     */
    // @Test // OK 
    public void testEliminaQuestionario() throws DBConnectionException, QuestionarioException, SQLException {
        Calendar dataIn = Calendar.getInstance();
        dataIn.set(2012, 11, 1);
        Calendar dataFin = Calendar.getInstance();
        dataFin.set(2012, 11, 11);
        Date dataI= new Date(dataIn.getTimeInMillis());
        Date dataF= new Date(dataFin.getTimeInMillis());
        
        Questionario questionario = new Questionario("questionario 51", null, "Numero51",51,  dataI, dataF);
        control.inserisciQuestionario(questionario);
        
        boolean nonPresente = false;
        control.eliminaQuestionario(51);
        
        Questionario q = control.getQuestionario(51);
        if(q==null)
            nonPresente = true;
        
        assertTrue(nonPresente);
       
    }
    
    
    
    
    
    
    /**
     * Test method for {@link atsilo.application.ControlQuestionario#isEditable(atsilo.entity.Questionario)}.
     */
    //@Test // OK
    public void testIsEditableTrue() {
        
        Calendar dataIn = Calendar.getInstance();
        dataIn.set(2011, 1, 1);
        Calendar dataFin = Calendar.getInstance();
        dataFin.set(2011, 11, 30);
        Date dataI= new Date(dataIn.getTimeInMillis());
        Date dataF= new Date(dataFin.getTimeInMillis());
        Questionario questionario = new Questionario("questionario 51", null, "Numero51",51,  dataI, dataF);
        
       assertTrue( control.isEditable(questionario));
        
    }
    
    
    
    
    
    
    /**
     * Test method for {@link atsilo.application.ControlQuestionario#isEditable(atsilo.entity.Questionario)}.
     */
    //@Test  // OK
    public void testIsEditableFalse() {
        Calendar dataIn = Calendar.getInstance();
        dataIn.set(2012, 11, 1);
        Calendar dataFin = Calendar.getInstance();
        dataFin.set(2013, 5, 11);
        Date dataI= new Date(dataIn.getTimeInMillis());
        Date dataF= new Date(dataFin.getTimeInMillis());
        Questionario questionario = new Questionario("questionario 51", null, "Numero51",51,  dataI, dataF);
        
       assertFalse( control.isEditable(questionario));
        
    }
    
    
    
    
    
    
    /**
     * Test method for {@link atsilo.application.ControlQuestionario#modificaQuestionario(int, atsilo.entity.Questionario)}.
     * @throws QuestionarioException 
     * @throws DBConnectionException 
     * @throws SQLException 
     */
   // @Test // OK
    public void testModificaQuestionario() throws DBConnectionException, QuestionarioException, SQLException {
        Calendar dataIn = Calendar.getInstance();
        dataIn.set(2012, 11, 1);
        Calendar dataFin = Calendar.getInstance();
        dataFin.set(2012, 11, 11);
        Date dataI= new Date(dataIn.getTimeInMillis());
        Date dataF= new Date(dataFin.getTimeInMillis());
        Questionario questionario = new Questionario("questionario 84", null, "Numero84",84,  dataI, dataF);
        
        control.inserisciQuestionario(questionario);
        
        Questionario toSostitute = questionario;
        toSostitute.setDescrizione("questionario sostituito");
        toSostitute.setFlag_rinuncia("si");
        toSostitute.setNome("sostituito");
        
        control.modificaQuestionario(84, toSostitute);
        
        Questionario sostituito = control.getQuestionario(84);
        
        assertEquals("sostituito", sostituito.getNome());
        
    }
    
    
    
    
    
    
    
    /**
     * Test method for {@link atsilo.application.ControlQuestionario#spostaDataInizio(int, java.sql.Date)}.
     * @throws QuestionarioException 
     * @throws DBConnectionException 
     * @throws SQLException 
     */
    //@Test  //OK
    public void testSpostaDataInizio() throws DBConnectionException, QuestionarioException, SQLException {
        Calendar dataIn = Calendar.getInstance();
        dataIn.set(2012, 11, 1);
        Calendar dataFin = Calendar.getInstance();
        dataFin.set(2012, 11, 11);
        Date dataI= new Date(dataIn.getTimeInMillis());
        Date dataNuova= new Date(dataFin.getTimeInMillis());        
        
        Questionario questionario = new Questionario("questionario 91", null, "Numero91",91,  dataI, null);
        
        control.inserisciQuestionario(questionario);
        control.spostaDataInizio(91, dataNuova);
        Questionario q = control.getQuestionario(91);
        
        assertEquals(dataNuova.toString(), q.getPeriodo_inizio().toString());
    }
    
    
    
    
    
    /**
     * Test method for {@link atsilo.application.ControlQuestionario#spostaDataFine(int, java.sql.Date)}.
     * @throws QuestionarioException 
     * @throws DBConnectionException 
     * @throws SQLException 
     */
    //@Test // OK
    public void testSpostaDataFine() throws DBConnectionException, QuestionarioException, SQLException {

        Calendar dataIn = Calendar.getInstance();
        dataIn.set(2012, 11, 1);
        Calendar dataFin = Calendar.getInstance();
        dataFin.set(2012, 11, 11);
        Date dataNuova= new Date(dataIn.getTimeInMillis());
        Date dataF= new Date(dataFin.getTimeInMillis());
        
        
        Questionario questionario = new Questionario("questionario 97", null, "Numero97",97,  null, dataF);
        
        control.inserisciQuestionario(questionario);
        control.spostaDataFine(97, dataNuova);
        Questionario q = control.getQuestionario(97);
        
        assertEquals(dataNuova.toString(), q.getPeriodo_fine().toString());
        
    }
    
    
    
    
    
    
    /**
     * Test method for {@link atsilo.application.ControlQuestionario#ricercaQuestionario(java.lang.String)}.
     * @throws QuestionarioException 
     * @throws DBConnectionException 
     */
    //@Test  //OK
    public void testRicercaQuestionario() throws DBConnectionException, QuestionarioException {
        Calendar dataIn = Calendar.getInstance();
        dataIn.set(2012, 11, 1);
        Calendar dataFin = Calendar.getInstance();
        dataFin.set(2012, 11, 11);
        Date dataI= new Date(dataIn.getTimeInMillis());
        Date dataF= new Date(dataFin.getTimeInMillis());
        
        Questionario questionario = new Questionario("Controllo qualita 2012", null, "Qualita",26,  dataI, dataF);
        Questionario questionario1 = new Questionario("Controllo qualita20122", null, "Qualita",24,  dataI, dataF);
        
        control.inserisciQuestionario(questionario);
        control.inserisciQuestionario(questionario1);
        
        List<Questionario> Q = control.ricercaQuestionario("Qualita");
        
        assertEquals(24, Q.get(0).getId());
        assertEquals(26, Q.get(1).getId());
    }
    
    
    
    
    
    /**
     * Test method for {@link atsilo.application.ControlQuestionario#compilaQuestionario(int, java.util.List, java.lang.String)}.
     * @throws QuestionarioException 
     * @throws DBConnectionException 
     * @throws SQLException 
     */
    //@Test //OK
    public void testCompilaQuestionario() throws DBConnectionException, QuestionarioException, SQLException {
        
        Calendar dataIn = Calendar.getInstance();
        dataIn.set(2012, 11, 1);
        Calendar dataFin = Calendar.getInstance();
        dataFin.set(2012, 11, 11);
        Date dataI= new Date(dataIn.getTimeInMillis());
        Date dataF= new Date(dataFin.getTimeInMillis());
        
        Questionario questionario = new Questionario("Controllo compilazione", null, "Compilazione",103,  dataI, dataF);
       
        DomandaQuestionario d = new DomandaQuestionario(51,103,"anni?",null);
        CampoDomandaQuestionario c1= new CampoDomandaQuestionario("", "21", "21",51);
        CampoDomandaQuestionario c2= new CampoDomandaQuestionario("", "22", "22",51);  
        List<CampoDomandaQuestionario> campi = new ArrayList<CampoDomandaQuestionario>();
        campi.add(c1);
        campi.add(c2);
        d.setCampi(campi);
        
        DomandaQuestionario d1 = new DomandaQuestionario(52,103,"abiti a?",null);
        CampoDomandaQuestionario c3= new CampoDomandaQuestionario("", "pompei", "pompei",52);
        CampoDomandaQuestionario c4= new CampoDomandaQuestionario("", "salerno", "salerno",52);  
        List<CampoDomandaQuestionario> campi1 = new ArrayList<CampoDomandaQuestionario>();
        campi1.add(c3);
        campi1.add(c4);
        d1.setCampi(campi1);
        
                
        questionario.aggiungiDomanda(d);
        questionario.aggiungiDomanda(d1);
        
        RispostaQuestionario r = new RispostaQuestionario("21",51,"CVLMRA69A23B333C");
        RispostaQuestionario r1 = new RispostaQuestionario("pompei",52,"CVLMRA69A23B333C");
        List<RispostaQuestionario> risposte = new ArrayList<RispostaQuestionario>();
        risposte.add(r);
        risposte.add(r1);
        
        
        control.inserisciQuestionario(questionario);
        control.compilaQuestionario(103, risposte, "CVLMRA69A23B333C");
        
        Questionario q = control.caricaQuestionarioDaCompilare(103, "CVLMRA69A23B333C");
        
        RispostaQuestionario risp = q.getRispostePrecaricate().get(0);
      /*  System.out.println(risp);
        RispostaQuestionario risp1 = q.getRispostePrecaricate().get(1);
        System.out.println(risp1);
        */
        assertEquals("21", risp.getValore());
        
    }
    
    
    
    
    
    /**
     * Test method for {@link atsilo.application.ControlQuestionario#getQuestionariDaCompilare(java.lang.String)}.
     * @throws QuestionarioException 
     * @throws DBConnectionException 
     */
    //@Test   //OK
    public void testGetQuestionariDaCompilare() throws DBConnectionException, QuestionarioException {
        Calendar dataIn = Calendar.getInstance();
        dataIn.set(2012, 11, 1);
        Calendar dataFin = Calendar.getInstance();
        dataFin.set(2013, 11, 11);
        Date dataI= new Date(dataIn.getTimeInMillis());
        Date dataF= new Date(dataFin.getTimeInMillis());
        
        Questionario q1 = new Questionario("Controllo compilazione!!", null, "Compilazione",110,  dataI, dataF);
        Questionario q2 = new Questionario("Controllo compilazione??", null, "Compilazione",111,  dataI, dataF);

        control.inserisciQuestionario(q1);
        control.inserisciQuestionario(q2);
        
        List<RispostaQuestionario> R = new ArrayList<RispostaQuestionario>();
        R.add(new RispostaQuestionario());
        
        control.compilaQuestionario(110, R, "CVLMRA69A23B333C");
        
        //il genitore ha compilato uno dei due questionari inseriti
        //il test va bene se getQuestionari da compilare mi restituisce l'altro questionario
        
        List<Questionario> Q = control.getQuestionariDaCompilare("CVLMRA69A23B333C");
        
        Questionario test = Q.get(0);
        assertEquals(111,test.getId());
        
    }
    

    
    
    
    
    /**
     * Test method for {@link atsilo.application.ControlQuestionario#inserisciDomanda(int, atsilo.entity.DomandaQuestionario)}.
     * @throws QuestionarioException 
     * @throws DBConnectionException 
     * @throws SQLException 
     */
    //@Test //OK
    public void testInserisciDomanda() throws DBConnectionException, QuestionarioException, SQLException {
        Calendar dataIn = Calendar.getInstance();
        dataIn.set(2012, 11, 1);
        Calendar dataFin = Calendar.getInstance();
        dataFin.set(2013, 11, 11);
        Date dataI= new Date(dataIn.getTimeInMillis());
        Date dataF= new Date(dataFin.getTimeInMillis());
        
        Questionario q = new Questionario("Controllo inserimento domanda", null, "ControlloDomanda",127,  dataI, dataF);
      
        DomandaQuestionario d = new DomandaQuestionario(87,127,"che ore sono?", null);
        CampoDomandaQuestionario c1 = new CampoDomandaQuestionario("radio", "� presto", "17.00", 87);
        CampoDomandaQuestionario c2 = new CampoDomandaQuestionario("radio", "non tanto presto", "20.00", 87);
        CampoDomandaQuestionario c3= new CampoDomandaQuestionario("radio", "� tardi", "23.00", 87);
        d.aggiungiCampo(c1);
        d.aggiungiCampo(c2);
        d.aggiungiCampo(c3);
        
        control.inserisciQuestionario(q);
        control.inserisciDomanda(127, d);
        
        List<DomandaQuestionario> domande = control.caricaQuestionarioDaCompilare(127, "CVLMRA69A23B333C").getDomande();
        
        DomandaQuestionario test = domande.get(0);
        assertEquals(d.toString(), test.toString());
        assertEquals(c1.toString(), test.getCampi().get(0).toString());
        assertEquals(c2.toString(), test.getCampi().get(1).toString());
        assertEquals(c3.toString(), test.getCampi().get(2).toString());
        
    }
    
    
    
    
    
    
    
    /**
     * Test method for {@link atsilo.application.ControlQuestionario#eliminaDomanda(int)}.
     * @throws QuestionarioException 
     * @throws DBConnectionException 
     * @throws SQLException 
     */
   // @Test  //OK
    public void testEliminaDomanda() throws DBConnectionException, QuestionarioException, SQLException {
        Calendar dataIn = Calendar.getInstance();
        dataIn.set(2012, 11, 1);
        Calendar dataFin = Calendar.getInstance();
        dataFin.set(2013, 11, 11);
        Date dataI= new Date(dataIn.getTimeInMillis());
        Date dataF= new Date(dataFin.getTimeInMillis());
        
        Questionario q = new Questionario("Controllo eliminazione domanda", null, "ControlloElDomanda",132,  dataI, dataF);
      
        DomandaQuestionario dom1 = new DomandaQuestionario(200,132,"funziona??", null);
        dom1.aggiungiCampo(new CampoDomandaQuestionario("radio", "si", "si", 200));
        dom1.aggiungiCampo(new CampoDomandaQuestionario("radio", "no", "no", 200));
        
        DomandaQuestionario dom2 = new DomandaQuestionario(201,132,"funzioner�??", null);
        dom1.aggiungiCampo(new CampoDomandaQuestionario("radio", "si", "si", 201));
        dom1.aggiungiCampo(new CampoDomandaQuestionario("radio", "no", "no", 201));
        q.aggiungiDomanda(dom1);
        q.aggiungiDomanda(dom2);
        
        control.inserisciQuestionario(q);
        
        control.eliminaDomanda(201);
        
        List<DomandaQuestionario> D = control.caricaQuestionarioDaCompilare(132, "CVLMRA69A23B333C").getDomande();
        assertEquals(1, D.size() );
    }
    
    
    
    
    
    /**
     * Test method for {@link atsilo.application.ControlQuestionario#modificaDomanda(int, atsilo.entity.DomandaQuestionario)}.
     * @throws QuestionarioException 
     * @throws DBConnectionException 
     * @throws SQLException 
     */
    //@Test  //OK
    public void testModificaDomanda() throws DBConnectionException, QuestionarioException, SQLException {

        Calendar dataIn = Calendar.getInstance();
        dataIn.set(2012, 11, 1);
        Calendar dataFin = Calendar.getInstance();
        dataFin.set(2013, 11, 11);
        Date dataI= new Date(dataIn.getTimeInMillis());
        Date dataF= new Date(dataFin.getTimeInMillis());
        
        Questionario q = new Questionario("Controllo modifica domanda", null, "ControlloMoDomanda",153,  dataI, dataF);
        
        DomandaQuestionario d1 = new DomandaQuestionario(61,153,"domanda sabato sera",null);
        d1.aggiungiCampo(new CampoDomandaQuestionario("radio","non lo so", "boh",61));
        d1.aggiungiCampo(new CampoDomandaQuestionario("radio","forse", "forse",61));
        
        DomandaQuestionario d222 = new DomandaQuestionario(62,153,"domanda domenica sera",null);
        d222.aggiungiCampo(new CampoDomandaQuestionario("radio","non lo so", "boh",62));
        d222.aggiungiCampo(new CampoDomandaQuestionario("radio","forse", "forse",62));
   
        q.aggiungiDomanda(d1);
        
        control.inserisciQuestionario(q);
        control.modificaDomanda(61, d222);
        
        List<DomandaQuestionario> D = control.caricaQuestionarioDaCompilare(153, "CVLMRA69A23B333C").getDomande();    
        DomandaQuestionario test = D.get(0);
        
        assertEquals(62, test.getId());
    }
    
    
    
    
    
    /**
     * Test method for {@link atsilo.application.ControlQuestionario#getStatistische(int)}.
     * @throws QuestionarioException 
     * @throws DBConnectionException 
     */
    @Test
    public void testGetStatistische() throws DBConnectionException, QuestionarioException {
        Calendar dataIn = Calendar.getInstance();
        dataIn.set(2012, 11, 1);
        Calendar dataFin = Calendar.getInstance();
        dataFin.set(2013, 11, 11);
        Date dataI= new Date(dataIn.getTimeInMillis());
        Date dataF= new Date(dataFin.getTimeInMillis());
        
        Questionario questionario = new Questionario("Questionario Qualita Mensa", null, "Mensa",200,  dataI, dataF);
        
        DomandaQuestionario domanda1 = new DomandaQuestionario(201,200,"E' soddisfatto della mensa?",null);
        CampoDomandaQuestionario c1 = new CampoDomandaQuestionario("radio","molto","molto",201);
        c1.setId(21);
        CampoDomandaQuestionario c2 = new CampoDomandaQuestionario("radio","abbastanza","abbastanza",201);
        c2.setId(22);
        CampoDomandaQuestionario c3 = new CampoDomandaQuestionario("radio","poco","poco",201);
        c3.setId(23);
        domanda1.aggiungiCampo(c1);
        domanda1.aggiungiCampo(c2);
        domanda1.aggiungiCampo(c3);
        
        DomandaQuestionario domanda2 = new DomandaQuestionario(202,200,"Quanto usa la mensa suo figlio?",null);
        CampoDomandaQuestionario c4 = new CampoDomandaQuestionario("radio","2 volte/sett","poco",202);
        c4.setId(24);
        CampoDomandaQuestionario c5 = new CampoDomandaQuestionario("radio","4 volte/sett","abbastanza",202);
        c5.setId(25);
        CampoDomandaQuestionario c6 = new CampoDomandaQuestionario("radio","6 volte/sett","molto",202);
        c6.setId(26);
        domanda2.aggiungiCampo(c4);
        domanda2.aggiungiCampo(c5);
        domanda2.aggiungiCampo(c6);
        
        
        DomandaQuestionario domanda3 = new DomandaQuestionario(203, 200, "Suo figlio le sembra contento?", null);
        CampoDomandaQuestionario c7 = new CampoDomandaQuestionario("radio","si","si",203);
        c7.setId(27);
        CampoDomandaQuestionario c8 = new CampoDomandaQuestionario("radio","no","no",203);
        c8.setId(28);
        domanda3.aggiungiCampo(c7);
        domanda3.aggiungiCampo(c8);
        
        questionario.aggiungiDomanda(domanda1);
        questionario.aggiungiDomanda(domanda2);
        questionario.aggiungiDomanda(domanda3);
        
        //se gi� hai eseguito questo metodo, commenta la riga successiva
       // control.inserisciQuestionario(questionario);
        
        
        RispostaQuestionario r1 = new RispostaQuestionario("molto", 201, "csrntn91l26c129j");
        RispostaQuestionario r2 = new RispostaQuestionario("poco", 201,"abcdefghilmnopqr");
        RispostaQuestionario r3 = new RispostaQuestionario("molto", 201, "qualcuno");
              
        RispostaQuestionario r4 = new RispostaQuestionario("molto", 202, "csrntn91l26c129j");
        RispostaQuestionario r5 = new RispostaQuestionario("poco", 202,"abcdefghilmnopqr");
        RispostaQuestionario r6 = new RispostaQuestionario("poco", 202, "qualcuno");
        
        RispostaQuestionario r7 = new RispostaQuestionario("si", 203, "csrntn91l26c129j");
        RispostaQuestionario r8 = new RispostaQuestionario("si", 203,"abcdefghilmnopqr");
        RispostaQuestionario r9 = new RispostaQuestionario("no", 203, "qualcuno");
        
        List<RispostaQuestionario> primo = new ArrayList<RispostaQuestionario>();
        primo.add(r1);
        primo.add(r4);
        primo.add(r7);
        
        List<RispostaQuestionario> secondo = new ArrayList<RispostaQuestionario>();
        secondo.add(r2);
        secondo.add(r5);
        secondo.add(r8);
        
        List<RispostaQuestionario> terzo = new ArrayList<RispostaQuestionario>();
        terzo.add(r3);
        terzo.add(r6);
        terzo.add(r9);
        
        
        //se gi� hai eseguito questo metodo, commenta le 3 riga successiva

        /*
        control.compilaQuestionario(200, primo, "csrntn91l26c129j");
        control.compilaQuestionario(200, secondo, "abcdefghilmnopqr");
        control.compilaQuestionario(200, terzo, "qualcuno");
        */
        
        StatisticheQuestionario S = control.getStatistische(200);
        
        System.out.println("Hanno compilato il questionario "+S.getNumber_comp()+" persone");

        System.out.println(domanda1.getDescrizione());
        System.out.println( S.getPercentualiFromCampo(201, 21 ));
        System.out.println( S.getPercentualiFromCampo(201, 22 ));
        System.out.println( S.getPercentualiFromCampo(201, 23 ));
        
        
        System.out.println(domanda2.getDescrizione());  
        System.out.println( S.getPercentualiFromCampo(201, 24));
        System.out.println( S.getPercentualiFromCampo(201, 25));
        System.out.println( S.getPercentualiFromCampo(201, 26));
        
        
        System.out.println(domanda3.getDescrizione());    
        System.out.println( S.getPercentualiFromCampo(201, 27) );
        System.out.println( S.getPercentualiFromCampo(201, 28) );
        
    }
    
    
    
    
    
    /**
     * Test method for {@link atsilo.application.ControlQuestionario#getAllQuestionari()}.
     * @throws DBConnectionException 
     */
    //@Test //OK
    public void testGetAllQuestionari() throws DBConnectionException {
        List<Questionario> Q = new ArrayList<Questionario>();
        Q = control.getAllQuestionari();
        
        assertTrue(!Q.isEmpty());
    }
    
    
    
    /**
     * Test method for {@link atsilo.application.ControlQuestionario#getQuestionario(int)}.
     * @throws QuestionarioException 
     * @throws DBConnectionException 
     * @throws SQLException 
     */
   //@Test  //OK
    public void testGetQuestionario() throws DBConnectionException, QuestionarioException, SQLException {

        Calendar dataIn = Calendar.getInstance();
        dataIn.set(2012, 11, 1);
        Calendar dataFin = Calendar.getInstance();
        dataFin.set(2013, 11, 11);
        Date dataI= new Date(dataIn.getTimeInMillis());
        Date dataF= new Date(dataFin.getTimeInMillis());
        
        Questionario questionario = new Questionario("QuestionarioAmbarapaccicciccocc�", null, "Mensa",598,  dataI, dataF);
        
        control.inserisciQuestionario(questionario);
        
        Questionario Q = control.getQuestionario(598);
        
        assertEquals(questionario.getNome(), Q.getNome());
        
    }
    
    Database db = new Database();   //Logger
    private static final Logger LOG = Logger.getLogger(JUnitTestControlQuestionario.class.getName());
    ControlQuestionario control = ControlQuestionario.getIstance();

    
}