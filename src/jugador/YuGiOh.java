package jugador;
import excepciones.FinDelJuegoException;
import tablero.Tablero;

import java.util.ArrayList;
import java.util.List;

public class YuGiOh {
    private Jugador jugador1;
    private Jugador jugador2;
    private Tablero tablero;
    private List<Turno> turnos;

    public YuGiOh() {
        jugador1 = new Jugador();
        jugador2 = new Jugador();
        tablero = new Tablero(jugador1, jugador2);
        turnos = new ArrayList <>();
        turnos.add(new Turno(jugador1));
        turnos.add(new Turno(jugador2));
    }
    public YuGiOh(String mazoJugador1, String mazoJugador2) {
        jugador1 = new Jugador(mazoJugador1);
        jugador2 = new Jugador(mazoJugador2);
        tablero = new Tablero(jugador1, jugador2);
        turnos = new ArrayList <>();
        turnos.add(new Turno(jugador1));
        turnos.add(new Turno(jugador2));
    }

    public boolean finDelJuego() {
        return (jugador1.pierde(jugador2.mostrarMano()) && jugador2.gana() ||
                jugador1.gana() && jugador2.pierde(jugador1.mostrarMano()));
    }

    public void ejecutarJuego() {

            try {
                while (! finDelJuego()) {
                turnos.get(0).cambiarDeFase();
                turnos.get(1).cambiarDeFase();
                }
            }
            catch (FinDelJuegoException datosDePartidaTerminada){
                 datosDePartidaTerminada.obtenerMotivo();
                 if (jugador1.equals(datosDePartidaTerminada.obtenerPerdedor()) && jugador1.pierde(jugador2.mostrarMano()) && jugador2.gana()) {
                     //mostrar victoria jugador2
                 }
                 else if (jugador2.equals(datosDePartidaTerminada.obtenerPerdedor()) && jugador1.gana() && jugador2.pierde(jugador1.mostrarMano())){
                     //mostrar victoria jugador 1
                 }
                 else {
                         //empate
                     }
                 }
            }



    public Jugador obtenerJugador1() { return jugador1; }

    public Jugador obtenerJugador2() { return jugador2; }

    public Tablero mostrarTablero() {
        return tablero;
    }
}
