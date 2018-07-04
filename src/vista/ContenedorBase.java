package vista;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import modelo.jugador.Jugador;
import modelo.jugador.YuGiOh;
import modelo.tablero.Tablero;
import vista.botones.*;

import java.util.ArrayList;
import java.util.List;


public class ContenedorBase extends GridPane {

    private Tablero tablero;
    private Pane centro;
    private ArrayList <Jugador> jugadores;
    private Canvas fondo;
    private Consola consola;

    public ContenedorBase(Stage stage, YuGiOh juego, Tablero tablero) {

        this.jugadores = juego.obtenerJugadores();
        this.setFondo();
        this.setGrilla();
        this.setConsola();
    }

    private void setConsola() {
        consola = new Consola();
        this.add(consola.getScrollPane(), 0, 4, 12, 1);
    }

    public void escribirEnConsola(String mensaje) {
        consola.escribirInstruccion(mensaje);
    }

    public void setFondo() {
        fondo = new Canvas(1000, 1000);
        centro = new Pane(fondo);

        Image imagen = new Image("/vista/imagenes/fondoTablero.jpg");
        ImageView imagenFondo = new ImageView(imagen);
        this.add(imagenFondo, 3, 1, 6, 2);
        this.setStyle("-fx-background-color: black;");
    }

    public void setBotonera(Botonera botonera) {

        this.add(botonera, 9, 2, 3, 1);
    }

    private void setGrilla() {
        this.setGridLinesVisible(true);
        final int numColumnas = 11;
        final int numFilas = 4;
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

    public void ubicarObjeto(Node rectangle, int fila, int columna) {
        this.setRowIndex(rectangle, fila);
        this.setColumnIndex(rectangle, columna);
        this.getChildren().addAll(rectangle);
    }

    public void ubicarTexto(String name, int tam, int fila, int columna) {
        Label text = new Label(name);
        text.setFont(Font.font("Tahoma", FontWeight.BOLD, tam));
        text.setTextAlignment(TextAlignment.CENTER);
        text.setTextFill(Color.web("000000"));
        this.setRowIndex(text, fila);
        this.setColumnIndex(text, columna);
        this.getChildren().addAll(text);
    }

    private void setTablero() {

        //Setteo cartas trampa
        for (int i = 0; i <= 3; i += 3) {
            for (int j = 3; j <= 7; j++) {
                Rectangle recTrampa = generarRectangulo(Color.DARKTURQUOISE, 125, 125);
                ubicarObjeto(recTrampa, i, j);
                ubicarTexto("Carta Trampa", 10, i, j);
            }
        }

        //Setteo cartas monstruo
        for (int i = 1; i <= 2; i++) {
            for (int j = 3; j <= 7; j++) {
                Rectangle recMonstruo = generarRectangulo(Color.DARKORANGE, 125, 125);
                ubicarObjeto(recMonstruo, i, j);
                ubicarTexto("Carta Monstruo", 10, i, j);
            }
        }

        //Setteo cartas campo
        Rectangle recCampo1 = generarRectangulo(Color.GREEN, 80, 125);
        ubicarObjeto(recCampo1, 2, 2);
        ubicarTexto("Carta Campo", 10, 2, 2);
        Rectangle recCampo2 = generarRectangulo(Color.GREEN, 80, 125);
        ubicarObjeto(recCampo2, 1, 8);
        ubicarTexto("Carta Campo", 10, 1, 8);

        //Setteo modelo.cartas cementerio
        Rectangle recCementerio1 = generarRectangulo(Color.GRAY, 80, 125);
        ubicarObjeto(recCementerio1, 1, 2);
        ubicarTexto("Cementerio", 10, 1, 2);
        Rectangle recCementerio2 = generarRectangulo(Color.GRAY, 80, 125);
        ubicarObjeto(recCementerio2, 2, 8);
        ubicarTexto("Cementerio", 10, 2, 8);

        //Setteo mazo
         BotonCartaBocaAbajo mazoOponente = new BotonCartaBocaAbajo(0,2);
        ubicarObjeto(mazoOponente, 0, 2);
        mazoOponente.setDisable(true);

        //Setteo cartasContrincante
        Image cartaOponenteImagen = new Image(getClass().getResourceAsStream("/vista/imagenes/cartasOponente.jpg"));
        ImageView cartaOponente = new ImageView(cartaOponenteImagen);
        ubicarObjeto(cartaOponente, 0, 9);

    }

    public void colocarCartaMonstruo(BotonCartaMano boton) {

        this.ubicarObjeto(boton, 2,3);
    }

}