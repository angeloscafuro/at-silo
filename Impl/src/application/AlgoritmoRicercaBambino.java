package application;

import atsilo.entity.Utente;

import java.util.Collections;
import java.util.List;

public class AlgoritmoRicercaBambino extends AlgoritmoRicerca {
    @Override
    public List<Utente> ricerca(List<String> parametriRicerca) {
        return Collections.emptyList();
    }
}
