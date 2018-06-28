package vista;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import jugador.Jugador;
import tablero.Tablero;
import vista.botones.Boton;

import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;


public class ContenedorPrincipal extends BorderPane {

    Tablero tablero;
    VBox contenedorCentral;
    static Pane centro;
    static ArrayList<Jugador> jugadores = new ArrayList<>();
    static VistaTablero vistaTablero;
    static Canvas fondo;
    Consola consola;


    public ContenedorPrincipal(Tablero tablero) {
        this.setFondo();
        this.tablero = tablero;
        this.setCentro(tablero);
        this.setBotonera();
        this.setConsola();
    }

    private void setConsola() {
        consola = new Consola();
        this.setBottom(consola.getScrollPane());
    }

    public static ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setFondo() {
        fondo = new Canvas(1000, 1000);
        centro = new Pane(fondo);
        centro.setStyle("-fx-background-color: white;");
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