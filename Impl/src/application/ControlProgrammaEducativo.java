package application;

import atsilo.entity.ProgrammaEducativoSettimanale;

import java.util.List;

public class ControlProgrammaEducativo {
    public ControlProgrammaEducativo() {
        super();
    }
    
    public boolean inserisciProgrammaEducativoSett(ProgrammaEducativoSettimanale p){
        return false;
    }
    
    public boolean modificaProgrammaEducativoSett(String id, String descrizione, String obiettivo){
        return false;
    }
    
    public List<ProgrammaEducativoSettimanale> getProgrammiEducativi(){
        return null;
    }
    
    public ProgrammaEducativoSettimanale getProgrammaEducativo(String id){
        return null;
    }
    
    
}