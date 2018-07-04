package modelo.jugador;
import modelo.excepciones.FinDelJuegoException;
import modelo.excepciones.VictoriaException;
import modelo.tablero.LadoDelCampo;
import modelo.tablero.Tablero;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class YuGiOh {
    private Jugador jugador1;
    private Jugador jugador2;
    private Tablero tablero;
    private HashMap<Jugador, Turno> turnos;

    public YuGiOh() throws VictoriaException {
        jugador1 = new Jugador();
        jugador2 = new Jugador();
        tablero = new Tablero(jugador1, jugador2);
        turnos = new HashMap<>();
        turnos.put(jugador1, new Turno(jugador1));
        turnos.put(jugador2, new Turno(jugador2));
    }

    public boolean finDelJuego() {
        return (jugador1.pierde(jugador2.mostrarMano()) && jugador2.gana() ||
                jugador1.gana() && jugador2.pierde(jugador1.mostrarMano()));
    }

    public void ejecutarJuego() {

        while (! finDelJuego()) {
        //    try {
                turnos.get(0).cambiarDeFase();
                turnos.get(1).cambiarDeFase(); }}
          //  }
            /*
            catch (FinDelJuegoException datosDePartidaTerminada){
                 datosDePartidaTerminada.obtenerMotivo();
                 if (jugador1.equals(datosDePartidaTerminada.obtenerPerdedor()) && jugador1.pierde(jugador2.mostrarMano()) && jugador2.gana()) {
                     //mostrar victoria jugador2
                 }
                 else if (jugador2.equals(datosDePartidaTerminada.obtenerPerdedor()) && jugador1.gana() && jugador2.pierde(jugador1.mostrarMano())){
                     //mostrar victoria modelo.jugador 1
                 }
                 else {
                         //empate
                     }
                 }
                 */
    public Jugador obtenerJugador1() { return jugador1; }

    public Jugador obtenerJugador2() { return jugador2; }

    public Tablero mostrarTablero() {
        return tablero;
    }

    public ArrayList<Jugador> obtenerJugadores() {
        ArrayList<Jugador> jugadores = new ArrayList <>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        return jugadores;
    }

    public void ejecutarFaseInicial(Jugador jugador) throws VictoriaException {
        turnos.get(jugador).ejecutarFaseInicial();
    }

    public void ejecutarFasePreparacion(Jugador jugadorTurno) throws VictoriaException {
        turnos.get(jugadorTurno).ejecutarFasePreparacion();
    }
}
