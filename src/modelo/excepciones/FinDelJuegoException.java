package modelo.excepciones;

import modelo.jugador.Jugador;

public class FinDelJuegoException extends Exception {
    private String motivo;
    private Jugador perdedor;
    public FinDelJuegoException(String motivo, Jugador perdedor){
        this.motivo=motivo;
        this.perdedor=perdedor;
    }
    public String obtenerMotivo() {
        return motivo;
    }

    public Jugador obtenerPerdedor() {
        return perdedor;
    }
}
