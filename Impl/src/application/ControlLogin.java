package application;

import atsilo.entity.Utente;

private class ControlLogin {
    private static final ControlLogin ISTANCE;

    ControlLogin() {
    }

    Boolean getValoreLogin(Utente utente) {
        return Boolean.TRUE;
    }

    public static ControlLogin getIstance() {
    }
}
