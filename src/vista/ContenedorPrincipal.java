package vista;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import jugador.Jugador;
import tablero.Tablero;
import vista.botones.Boton;

import java.util.ArrayList;


public class ContenedorPrincipal extends BorderPane {

    Tablero tablero;
    VBox contenedorCentral;
    static Pane centro;
    static ArrayList<Jugador> jugadores = new ArrayList<>();
    static VistaTablero vistaTablero;
    static Canvas fondo;

    public ContenedorPrincipal(Tablero tablero) {
        this.setFondo();
        this.tablero = tablero;
        this.setCentro(tablero);
        this.setBotonera();
    }

    public static ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setFondo() {
        fondo = new Canvas(800, 500);
        fondo.getGraphicsContext2D().setFill(Color.WHITE);
        fondo.getGraphicsContext2D().fillRect(0, 0, 720, 420);
        centro = new Pane(fondo);
    }

    private void setBotonera() {
    }

    private void setCentro(Tablero tablero) {
        vistaTablero = new VistaTablero(tablero, centro, fondo);
        vistaTablero.dibujar();
        contenedorCentral = new VBox(centro);
        contenedorCentral.setPadding(new Insets(25));
        this.setCenter(contenedorCentral);
    }
}