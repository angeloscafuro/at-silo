package atsilo.storage;

import atsilo.entity.Bambino;

import atsilo.entity.DomandaIscrizione;
import atsilo.entity.Genitore;
import java.util.Date;
public class DBDomandaIscrizione extends DBBeans {
    
    public DBDomandaIscrizione(Database db){
        super("DomandaIscrizione",db);
    }

    public DomandaIscrizione ricercaDomandaDaBambino(Bambino b) {
        return null;
    }

    public DomandaIscrizione ricercaDomandaDaGenitore(Genitore g) {
        return null;
    }


    public DomandaIscrizione ricercaDomandaDaId(int Id) {
        return null;
    }
    
    public List<DomandaIscrizione> ricercaDomandaPerData(Date d){}//aggiunto
    
    public List<DomandaIscrizione> ricercaDomandaPerPunteggio(int p){}//aggiunto
    
    
}
