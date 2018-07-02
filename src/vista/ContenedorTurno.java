package vista;

import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import modelo.jugador.Jugador;
import modelo.jugador.YuGiOh;
import modelo.tablero.Tablero;

import java.util.ArrayList;

public class ContenedorTurno extends GridPane {
    private ContenedorBase contenedorBase;
    private Jugador jugadorTurno;
    private Tablero tablero;
    private ArrayList<Jugador> jugadores;
    private YuGiOh juego;
    private Stage stage;
    private VistaJugador vistaJugador1;
    private VistaJugador vistaJugador2;
    private VistaJugador vistaActual;

    public ContenedorTurno(Stage stage, YuGiOh juego, ContenedorBase contenedorBase){
        this.stage = stage;
        this.juego = juego;
        this.contenedorBase = contenedorBase; //Ni se si hace falta
        this.setearBase();
        this.generarTitulos();
        this.jugadores = juego.obtenerJugadores();
        //vistaJugador1 = new VistaJugador(juego.obtenerJugador1(),juego.obtenerJugador1().obtenerNombre(), contenedorBase);
        //vistaJugador2 = new VistaJugador(juego.obtenerJugador2(),juego.obtenerJugador2().obtenerNombre(), contenedorBase);
        vistaActual = vistaJugador1;
        jugadorTurno = juego.obtenerJugador1(); //Ya se que esta harcodeadisimo pero despues lo cambiamos
        contenedorBase.obtenerConsola().escribirInstruccion("Es el turno de " + jugadorTurno.obtenerNombre());
    }

    public void generarTitulos() {
    }


    private void setearBase() {
        this.getChildren().addAll(vistaActual);
    }


    private void generarBotonera() {

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
        if (jugadorTurno == juego.obtenerJugador1()) vistaActual = vistaJugador1;
        else vistaActual = vistaJugador2;
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

