package vista;

import jugador.Jugador;
import jugador.YuGiOh;
import tablero.Tablero;

import java.util.ArrayList;
import java.util.Random;

public class ContenedorTurno { //Singleton
    private static ContenedorBase contenedorBase;
    private Jugador jugadorTurno;
    private Tablero tablero;
    private ArrayList<Jugador> jugadores;
    private YuGiOh juego;

    private ContenedorTurno(YuGiOh juego, ContenedorBase contenedorBase, ArrayList<Jugador> jugadores){

        this.juego = juego;
        this.contenedorBase = contenedorBase;
        this.jugadores = jugadores;
        jugadorTurno = elegirPrimerJugador();
        contenedorBase.obtenerConsola().escribirInstruccion("Es el turno de " + jugadorTurno.obtenerNombre());
    }

    private Jugador elegirPrimerJugador() {

        return jugadores.get(new Random().nextInt(jugadores.size()));
    }

    public Jugador obtenerJugadorActual(){
        return jugadorTurno;
    }

    public boolean jugar(){
        if (! juego.finDelJuego()) {
            //algo relativo a pasar de fase
            //imprimir algo por consola
            //
        }
        this.actualizar(); //Algun metodo que me actualice la vista
        return true;
    }

    private void actualizar() {
    }

    public void cambiarTurno(){
        jugadorTurno = obtenerSiguienteJugador(jugadorTurno);
        contenedorBase.obtenerConsola().escribirInstruccion("\nEs el turno de " + jugadorTurno.obtenerNombre());
        actualizar();
    }

    private Jugador obtenerSiguienteJugador(Jugador actual) {
        if (jugadores.indexOf(actual) == jugadores.size()-1){
            return jugadores.get(0);
        }
        return jugadores.get(jugadores.indexOf(actual)+1);
    }

    public void terminarTurno(){

    }
}

