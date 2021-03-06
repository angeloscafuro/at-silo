package atsilo.application;

import atsilo.application.notificheMail.ControlNotificaMail;
import atsilo.application.notificheMail.Messaggio;
import atsilo.application.notificheMail.NotificaMailEvento;
import atsilo.entity.Bambino;
import atsilo.entity.Classe;
import atsilo.entity.EducatoreDidattico;
import atsilo.entity.EventPlanner;
import atsilo.entity.Evento;
import atsilo.entity.Genitore;
import atsilo.entity.Partecipa;
import atsilo.entity.PersonaleAsilo;
import atsilo.entity.Psicopedagogo;
import atsilo.entity.Utente;

import atsilo.exception.DBConnectionException;
import atsilo.exception.EventoException;
import atsilo.storage.*;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.MessagingException;




/*
 *-----------------------------------------------------------------
 * This file is licensed under GPL 3.0:
 * http://www.gnu.org/licenses/gpl-3.0.html
 *-----------------------------------------------------------------
 * FILE: ControlRegistro.java
 *-----------------------------------------------------------------
 * PROGETTO: Atsilo
 *-----------------------------------------------------------------
 * OWNER
 * Antonio Cesarano, 27/11/2012
 *-----------------------------------------------------------------
 */

/**
 * ----------------------------------------------------------------- This file
 * is licensed under GPL 3.0: http://www.gnu.org/licenses/gpl-3.0.html
 * ----------------------------------------------------------------- FILE:
 * ControlEvento.java
 * ----------------------------------------------------------------- PROGETTO:
 * Atsilo -----------------------------------------------------------------
 * OWNER Antonio Cesarano,Gianfranco Bottiglieri 27/11/2012 (non responsabile)
 * 
 * -----------------------------------------------------------------
 **/

/*
 * ====EVENTO=== Evento avr� i seguenti attributi
 * 
 * -- -Nome -Descrizione -Data -Tipo -CC
 * 
 * Il tipo � una stringa e pu� essere: Evento organizzato, Riunione I CC � una
 * stringa ed indica i CC dell'evento (per esempio in una riunione devono essere
 * presenti i rappresentanti delle classi e l'event planner inserisce nei cc i
 * rappresentanti).
 */
public class ControlEvento {
    
    private static final ControlEvento INSTANCE = new ControlEvento();
    private static final Logger LOG = Logger.getLogger("global");
    
    
    /**
     * Contructor
     */
    private ControlEvento() {
    }
    
    
    /**
     * Adds a new event in a register
     * 
     * @param registro
     *            is the register in which add the event
     * @param evento
     *            is the evento to add
     * @return true if the event was added correctly, else false
     * @throws DBConnectionException
     * @throws EventoException
     */
    public void inserisciEvento(Evento evento) throws EventoException {
        Database db = new Database();
        
        if (!db.apriConnessione()) {
            throw new EventoException("Connessione al DataBase fallita");
        }
        try {
            DBPartecipa dbPartecipa = new DBPartecipa(db);
            DBEvento dbEvento = new DBEvento(db);
            dbEvento.inserisci(evento);
            
            for (Classe classe : evento.getClassi()) {
                Partecipa partecipa = new Partecipa(classe, evento.getId());
                dbPartecipa.inserisci(partecipa);
            }
            if(evento.getCC()!=null)
            {
                ControlNotificaMail control = ControlNotificaMail.getInstance();
                Messaggio messaggio = new NotificaMailEvento(
                        convertiCC(evento.getCC()), "Creazione ", " ", evento);
                try {
                    control.inviaMail(messaggio);
                } catch (MessagingException e) {
                    LOG.log(Level.SEVERE,
                            "<Errore nel invio del messaggio cauasato da: >", e);
                } catch (Throwable e) {
                    LOG.log(Level.SEVERE,
                            "<Errore nel invio del messaggio cauasato da: >", e);
                }
            }
            
        } finally {
            db.chiudiConnessione();
        }
    }
    
    /**
     * Changes an event in a register
     * 
     * @param registro
     *            is the register in which change the event
     * @param vecchioEvento
     *            is the event to change
     * @param nuovoEvento
     *            is the new event that substitutes vecchioEvento
     * @return true if the event was changed correctly, else true
     * @throws DBConnectionException
     * @throws EventoException
     */
    public boolean modificaEvento(Evento evento, Evento eventoModificato) {
        Database db = new Database();
        
        if (!db.apriConnessione()) {
            LOG.log(Level.SEVERE,
                    "Errore di esecuzione della query. Causato da: connessione fallita");
            return false;
        }
        try {
            DBEvento dbEvento = new DBEvento(db);
            DBPartecipa dbPartecipa = new DBPartecipa(db);
            try {
                Evento eventoOrigine = dbEvento.ricercaEventoPerChiave(evento
                        .getId());
                List<Integer> classiOrigine = dbPartecipa.getClassiPerEvento(eventoOrigine.getId());
                dbEvento.replace(eventoOrigine, eventoModificato);
                Iterable<Partecipa> classiDaCancellare = dbPartecipa.getAll();
                Iterator<Partecipa> classiDelete = classiDaCancellare
                        .iterator();
                while (classiDelete.hasNext()) {
                    Partecipa partecipa = classiDelete.next();
                    if (partecipa.getEventoId() == eventoOrigine.getId())
                        dbPartecipa.delete(partecipa);
                }
                for (Classe classe : eventoModificato.getClassi()) {
                    Partecipa partecipa = new Partecipa(classe, eventoModificato.getId());
                    dbPartecipa.inserisci(partecipa);
                }
                if(evento.getCC()!=null)
                {
                    ControlNotificaMail control = ControlNotificaMail.getInstance();
                    Messaggio messaggio = new NotificaMailEvento(
                            convertiCC(evento.getCC()), "Modifica", "", evento);
                    try {
                        control.inviaMail(messaggio);
                    } catch (MessagingException e) {
                        LOG.log(Level.SEVERE,
                                "<Errore nel invio del messaggio cauasato da: >", e);
                    } catch (Throwable e) {
                        LOG.log(Level.SEVERE,
                                "<Errore nel invio del messaggio cauasato da: >", e);
                    }
                }
                return true;
                
                
            } catch (SQLException e) {
                LOG.log(Level.SEVERE,
                        "Errore di esecuzione della query. Causato da:"
                                + e.getMessage(), e);
                return false;
            }
            
            
        } finally {
            db.chiudiConnessione();
        }
    }
    
    
    /**
     * Cancella l'evento dal registro altrimenti ritorna null
     * 
     * @param registro
     *            is the register from which delete the event
     * @param evento
     *            is the event to delete
     * @return the event deleted
     * @throws DBConnectionException
     * @throws EventoException
     */
    public Evento eliminaEvento(Evento evento) {
        Database db = new Database();
        
        if (!db.apriConnessione()) {
            LOG.log(Level.SEVERE,
                    "Errore di esecuzione della query. Causato da: connessione fallita");
            return null;
        }
        try {
            DBEvento dbEvento = new DBEvento(db);
            DBPartecipa dbPartecipa = new DBPartecipa(db);
            try {
                if (dbEvento.ricercaEventoPerChiave(evento.getId()) != null)
                    ;
            } catch (SQLException e) {
                LOG.log(Level.SEVERE,
                        "Errore di esecuzione della query. Causato da: "
                                + e.getMessage(), e);
                return null;
            }
            Iterable<Partecipa> classiDaCancellare = dbPartecipa.getAll();
            Iterator<Partecipa> classiDelete = classiDaCancellare.iterator();
            
            while (classiDelete.hasNext()) {
                Partecipa partecipa = classiDelete.next();
                if (partecipa.getEventoId() == evento.getId())
                    dbPartecipa.delete(partecipa);
            }
            
            dbEvento.delete(evento);
            if(evento.getCC()!=null)
            {
                ControlNotificaMail control = ControlNotificaMail.getInstance();
                Messaggio messaggio = new NotificaMailEvento(
                        convertiCC(evento.getCC()), "Cancellazione ",
                        "\n l'evento sopra descritto � stato cancellato", evento);
                try {
                    control.inviaMail(messaggio);
                } catch (MessagingException e) {
                    LOG.log(Level.SEVERE,
                            "<Errore nel invio del messaggio cauasato da: >", e);
                } catch (Throwable e) {
                    LOG.log(Level.SEVERE,
                            "<Errore nel invio del messaggio cauasato da: >", e);
                }
            }
            return evento;
        } finally {
            db.chiudiConnessione();
        }
    }
    
    
    /**
     * Gets all the events given its ud
     * 
     * @param pers
     *            is the event owner teacher
     * @return an event list about teacher
     * @throws SQLException
     * @throws DBConnectionException
     * @throws EventoException
     */
    public Evento getEventoPerId(int id)
            throws SQLException {
        Database db = new Database();
        
        if (!db.apriConnessione()) {
            LOG.log(Level.SEVERE,
                    "Errore di esecuzione della query. Causato da: connessione fallita");
            return null;
        }
        try{
            DBEvento dbEvento = new DBEvento(db);
            DBPartecipa dbp = new DBPartecipa(db);
            DBClasse dbc = new DBClasse(db);
            db.apriConnessione();
            Evento e =dbEvento.ricercaEventoPerChiave(id);
            List<Integer> classi = dbp.getClassiPerEvento(e.getId());
            List<Classe> toSet = new ArrayList<Classe>();
            for(Integer idc : classi)
            {
                toSet.add(dbc.RicercaClassePerId(idc.intValue()));
            }
            e.setClassi(toSet);
            
            return e;
        }
        finally {
            db.chiudiConnessione();
        }
    }
    
    /**
     * Restituisce gli eventi di un genitore in una data
     * @param codiceFiscale codice fiscale del genitore
     * @param data la data in cui si cercano gli eventi
     * @return
     * @throws SQLException
     * @throws DBConnectionException
     * @throws EventoException
     */
    public List<Evento> getEventiPerGenitoreInData(String codiceFiscale, Date data)
            throws SQLException, DBConnectionException, EventoException {
        Database db = new Database();
        
        if (!db.apriConnessione()) {
            LOG.log(Level.SEVERE,
                    "Errore di esecuzione della query. Causato da: connessione fallita");
            return null;
        }
        try{
            DBGenitore dbg = new DBGenitore(db);
            DBBambino dbb = new DBBambino(db);
            DBPartecipa dbp = new DBPartecipa(db);
            List<Evento> toReturn = new ArrayList<Evento>();
            db.apriConnessione();
            Genitore g = dbg.getGenitorePerCF(codiceFiscale);
            List<Bambino> lb = dbb.ricercaFigliGenitore(codiceFiscale);
            List<Evento> eventiInData = getEventiInData(data);
            //Filtro prima per email sui CC
            for(Evento e : eventiInData)
            {
                if(e.getCC().contains(g.getEmail()))
                {
                    toReturn.add(e);
                }
            }
            //Controllo se i figli del genitore sono legati ad alcuno degli eventi prelevati
            for(Evento e : eventiInData)
            {
                List<Integer> idClassi = dbp.getClassiPerEvento(e.getId());
                for(Bambino b : lb)
                {
                    if(idClassi.contains(b.getClasse()) && !toReturn.contains(e))
                    {
                        //Una volta trovato che uno dei figli porta il genitore nell'evento stop
                        toReturn.add(e);
                        break;    
                    }
                }
            }
            
            return toReturn;
        }
        finally {
            db.chiudiConnessione();
        }
    }
    
    /**
     * Gets all the events about a teacher
     * 
     * @param pers
     *            is the event owner teacher
     * @return an event list about teacher
     * @throws SQLException
     * @throws DBConnectionException
     * @throws EventoException
     */
    public List<Evento> getEventiPerOrganizzatore(EventPlanner organizzatore)
            throws SQLException {
        Database db = new Database();
        
        if (!db.apriConnessione()) {
            LOG.log(Level.SEVERE,
                    "Errore di esecuzione della query. Causato da: connessione fallita");
            return null;
        }
        // GiaNFrancaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
        // modificato da Fabio Napoli ma lo devi rivedere xk nn ho usato try
        // catch... :D
        // mi devi passare solo il COdiceFiscale non tutto lo ggetto :D cosi
        // dovrebbe andare :D
        try {
            DBEvento dbEvento = new DBEvento(db);
            if (organizzatore instanceof Psicopedagogo) {
                Psicopedagogo p = new Psicopedagogo();
                p = (Psicopedagogo) organizzatore;
                return dbEvento.getEventiPerOrganizzatore(p.getCodiceFiscale());
                
            } else if (organizzatore instanceof PersonaleAsilo) {
                PersonaleAsilo p = new PersonaleAsilo();
                p = (PersonaleAsilo) organizzatore;
                return dbEvento.getEventiPerOrganizzatore(p.getCodiceFiscale());
                
            } else if (organizzatore instanceof EducatoreDidattico) {
                EducatoreDidattico p = new EducatoreDidattico();
                p = (EducatoreDidattico) organizzatore;
                return dbEvento.getEventiPerOrganizzatore(p.getCodiceFiscale());
                
            } else
                return null;
            
        }
        
        finally {
            db.chiudiConnessione();
        }
    }
    
    
    /**
     * Gets all the events in a date
     * 
     * @param registro
     *            is the register in which get the events
     * @param data
     *            is the events date
     * @return an event list where all the events have their date equals to @param
     *         data
     * @throws DBConnectionException
     * @throws EventoException
     * @throws SQLException
     */
    public List<Evento> getEventiInData(Date data)
            throws DBConnectionException, EventoException, SQLException {
        Database db = new Database();
        
        if (!db.apriConnessione())
            throw new DBConnectionException("Connessione al DB fallita");
        try {
            DBEvento dbEvento = new DBEvento(db);
            return dbEvento.getEventiPerData(data);
            
        } finally {
            db.chiudiConnessione();
        }
    }
    
    /**
     * 
     * @param nome
     * @return
     */
    
    public List<Evento> getEventiPerNome(String nome) {
        Database db = new Database();
        
        if (!db.apriConnessione())
            try {
                throw new DBConnectionException("Connessione al DB fallita");
            } catch (DBConnectionException e) {
                LOG.log(Level.SEVERE, "<Problema nella query causato da: >", e);
                return null;
            }
        try {
            DBEvento dbEvento = new DBEvento(db);
            return dbEvento.getEventiPerNome(nome);
            
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "<Problema nella query causato da: >", e);
            return null;
        } finally {
            db.chiudiConnessione();
        }
    }
    
    /**
     * trasforma il CC in una lista di utenti
     * 
     * @param cc
     *            � una stringa che contiene le email separate da virgola
     * @return una lista di utenti in cui � settato solo il campo per l'email
     */
    private static ArrayList<Utente> convertiCC(String cc) {
        ArrayList<Utente> utenti = new ArrayList<Utente>();
        String mail[];
        mail = cc.split(",");
        for (int i = 0; i < mail.length; i++) {
            Utente utente = new Utente();
            utente.setEmail(mail[i]);
            utenti.add(utente);
        }
        
        return utenti;
    }
    public boolean verificaCreatoreEvento(Evento evento, String codiceFiscale)
    {    Database db = new Database();
    
    if (!db.apriConnessione())
        try {
            throw new DBConnectionException("Connessione al DB fallita");
        } catch (DBConnectionException e) {
            LOG.log(Level.SEVERE, "<Problema nella query causato da: >", e);
            return false;
        }
    try {
        DBEvento dbEvento=new DBEvento(db);
        Evento eventoDaControllare=dbEvento.ricercaEventoPerChiave(evento.getId());
        Utente organizattore=(Utente) eventoDaControllare.getOrganizzatore();
        if(organizattore.getCodiceFiscale().compareTo(codiceFiscale)==0)
            return true;
        else return false;
        
    } catch (SQLException e) {
        LOG.log(Level.SEVERE, "<Problema nella query causato da: >", e);
        return false;
    } finally {
        db.chiudiConnessione();
    }

        
    }
    
    
    /**
     * Gets the single istance of this class
     * 
     * @return a new ControlEvento
     */
    public static ControlEvento getIstance() {
        return INSTANCE;
    }
    
}
