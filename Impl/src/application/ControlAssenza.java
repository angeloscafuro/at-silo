package application;

import atsilo.entity.*;

import atsilo.entity.Registro;

import java.sql.Date;

import java.util.List;

public class ControlAssenza {
        
    public ControlAssenza() {}

    public void inserisciAssenza(Registro registro, Assenza assenza){}
    
    public Assenza eliminaAssenza(Registro registro, Assenza assenza){
        return null;
    }
            
    public List<Assenza> getAssenzeGiorno(Registro registro, Date data){
        return null;  
    }
    
    public List<Assenza> getAssenzeBambino(Bambino bambino){
        return null;
    }
    
    
}
