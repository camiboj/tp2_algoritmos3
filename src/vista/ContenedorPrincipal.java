package vista;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import jugador.Jugador;
import tablero.Tablero;

import java.util.ArrayList;


public class ContenedorPrincipal extends GridPane {

    private Tablero tablero;
    private VistaJugador vistaActual;
    static Pane centro;
    static ArrayList<Jugador> jugadores = new ArrayList<>();
    static Canvas fondo;
    private Consola consola;


    public ContenedorPrincipal(Tablero tablero) {
        this.setFondo();
        this.tablero = tablero;
        this.setGrilla();
        this.setBotonera();
        this.setConsola();
    }

    private void setConsola() {
        consola = new Consola();
        this.add(consola.getScrollPane(), 0, 4, 11, 1);
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

    private void setGrilla() {
        this.setGridLinesVisible(true);
        final int numColumnas = 11 ;
        final int numFilas = 4 ;
        for (int i = 0; i < 3; i++) {
            ColumnConstraints columna = new ColumnConstraints();
            columna.setPercentWidth(7.09);
            this.getColumnConstraints().add(columna);
        }
        for (int i = 3; i < 8; i++) {
            ColumnConstraints columna = new ColumnConstraints();
            columna.setPercentWidth(11.49);
            this.getColumnConstraints().add(columna);
        }
        for (int i = 7; i < numColumnas; i++) {
            ColumnConstraints columna = new ColumnConstraints();
            columna.setPercentWidth(7.09);
            this.getColumnConstraints().add(columna);
        }
        for (int i = 0; i < numFilas; i++) {
            RowConstraints fila = new RowConstraints();
            fila.setPercentHeight(22.5);
            this.getRowConstraints().add(fila);
        }
        RowConstraints ultimaFila = new RowConstraints();
        ultimaFila.setPercentHeight(10);
        this.getRowConstraints().add(ultimaFila);

        this.setTablero();
    }

    private Rectangle generarRectangulo(Color color, int ancho, int alto) {
        Rectangle rec = new Rectangle();
        rec.setWidth(ancho);
        rec.setHeight(alto);
        rec.setStroke(Color.BLACK);
        rec.setFill(color);
        return rec;
    }

    private void ubicarObjeto(Node rectangle, int fila, int columna) {
        this.setRowIndex(rectangle, fila);
        this.setColumnIndex(rectangle, columna);
        this.getChildren().addAll(rectangle);
    }

    private void ubicarTexto(String name, int fila, int columna){
        Label text = new Label(name);
        text.setFont(Font.font("Tahoma", FontWeight.BOLD, 10));
        text.setTextAlignment(TextAlignment.CENTER);
        text.setTextFill(Color.web("000000"));
        this.setRowIndex(text, fila);
        this.setColumnIndex(text, columna);
        this.getChildren().addAll(text);
    }

    private void setTablero(){

        //Setteo cartas trampa
        for(int i = 0; i <= 3; i+=3) {
            for (int j = 3; j <= 7; j++) {
                Rectangle recTrampa = generarRectangulo(Color.DARKTURQUOISE, 125, 125);
                ubicarObjeto(recTrampa, i, j);
                ubicarTexto("Carta Trampa",i,j);
            }
        }

        //Setteo cartas monstruo
        for(int i = 1; i <= 2; i++) {
            for (int j = 3; j <= 7; j++) {
                Rectangle recMonstruo = generarRectangulo(Color.DARKORANGE, 125, 125);
                ubicarObjeto(recMonstruo, i, j);
                ubicarTexto("Carta Monstruo", i, j);
            }
        }

        //Setteo cartas campo
        Rectangle recCampo1 = generarRectangulo(Color.GREEN, 80, 125);
        ubicarObjeto(recCampo1, 2, 2);
        ubicarTexto("Carta Campo", 2, 2);
        Rectangle recCampo2 = generarRectangulo(Color.GREEN, 80, 125);
        ubicarObjeto(recCampo2, 1, 8);
        ubicarTexto("Carta Campo", 1, 8);

        //Setteo cartas cementerio
        Rectangle recCementerio1 = generarRectangulo(Color.GRAY, 80, 125);
        ubicarObjeto(recCementerio1, 1, 2);
        ubicarTexto("Cementerio", 1, 2);
        Rectangle recCementerio2 = generarRectangulo(Color.GRAY, 80, 125);
        ubicarObjeto(recCementerio2, 2, 8);
        ubicarTexto("Cementerio", 2, 8);

        //Setteo mazo
        Image imagen = new Image(getClass().getResourceAsStream("/vista/imagenes/cartaAtras.jpg"));
        ImageView mazo1 = new ImageView(imagen);
        ubicarObjeto(mazo1, 0, 2);
        ImageView mazo2 = new ImageView(imagen);
        ubicarObjeto(mazo2, 3, 8);
    }
    /*
    public static void actualizar() {
        visorActual.reset();
        VistaJugador vjActual = VistaJugador.getPorNombre(ControladorDeTurno.getInstance().getJugadorActual().getNombre());
        visorActual = new Visor(vjActual, centro);
    }
    */
}