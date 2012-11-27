package atsilo.storage;
import java.util.*;
import java.util.Date;
import atsilo.entity.Classe;
import atsilo.entity.EducatoreDidattico;
import atsilo.entity.Psicopedagogo;
import atsilo.entity.Questionario;
import atsilo.entity.Registro;

public class DBRegistro extends DBBeans 
{
    Tabella tabella;
    
    public DBRegistro(Database db){
        
        super("Registro",db);
    }
    
    public boolean inserisciRegistroNelDatabase(Registro registro){
        return false;
    }
    
    public boolean assegnaRegistroAClasse(Registro registro, Classe classe){}
        
    public Registro ricercaRegistroPerClasse(Classe c){
         Registro p;
         return p;
    }
        
    public Registro ricercaRegistroPerAnno(Date d){
        Registro p;
        return p;
    }
    
    public List<EducatoreDidattico> ricercaEducatoriDidattici(){
        List<EducatoreDidattico> l;
        return l;
    }   

}