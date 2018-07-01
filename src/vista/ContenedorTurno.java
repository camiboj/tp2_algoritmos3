package vista;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import jugador.Jugador;
import jugador.YuGiOh;
import tablero.Tablero;

import java.util.ArrayList;
import java.util.Random;

public class ContenedorTurno extends GridPane {
    private ContenedorBase contenedorBase;
    private Jugador jugadorTurno;
    private Tablero tablero;
    private ArrayList<Jugador> jugadores;
    private YuGiOh juego;
    private Stage stage;

    public ContenedorTurno(Stage stage, YuGiOh juego, ContenedorBase contenedorBase){
        this.stage = stage;
        this.juego = juego;
        this.contenedorBase = contenedorBase;
        this.setearBase();
        this.generarTitulos();
        this.jugadores = juego.obtenerJugadores();
        jugadorTurno = elegirPrimerJugador();
        contenedorBase.obtenerConsola().escribirInstruccion("Es el turno de " + jugadorTurno.obtenerNombre());
    }

    public void generarTitulos() {
       /*contenedorBase.ubicarTexto("Jugador: " + jugadorTurno.obtenerNombre(),
                15,0, 0);
        contenedorBase.ubicarTexto("Puntos:" + String.valueOf(jugadorTurno.obtenerPuntos().obtenerNumero()),
                15, 1, 1);*/
    }


    private void setearBase() {
        this.getChildren().addAll(contenedorBase);




        //contenedorBase.ubicarTexto("Jugador: " + jugadorTurno.obtenerNombre(),
            //    15,0, 0);
        //contenedorBase.ubicarTexto("Puntos:" + String.valueOf(jugadorTurno.obtenerPuntos().obtenerNumero()),
          //      15, 1, 1);
    }


    private void generarBotonera() {



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

