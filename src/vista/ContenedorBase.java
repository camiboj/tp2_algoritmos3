package vista;
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
import vista.botones.BotonCambiarTurno;

import java.util.ArrayList;


public class ContenedorBase extends GridPane {

    private Tablero tablero;
    private Pane centro;
    private ArrayList <Jugador> jugadores;
    private Canvas fondo;
    private Consola consola;
    private Jugador jugadorTurno;
    private YuGiOh juego;
    private Stage stage;
    private VistaJugador vistaJugador1;
    private VistaJugador vistaJugador2;
    private VistaJugador vistaActual;
    private VistaJugador vistaContrincante;


    public ContenedorBase(Stage stage, YuGiOh juego, Tablero tablero) {
        this.stage = stage;
        this.juego = juego;
        this.jugadores = juego.obtenerJugadores();
        this.setFondo();
        this.jugadorTurno = juego.obtenerJugador1();
        this.vistaJugador1 = new VistaJugador(juego.obtenerJugador1(), tablero.mostrarLadoDelCampo(juego.obtenerJugador1()),
                juego.obtenerJugador1().obtenerNombre());
        this.vistaJugador2 = new VistaJugador(juego.obtenerJugador2(), tablero.mostrarLadoDelCampo(juego.obtenerJugador2()),
                juego.obtenerJugador2().obtenerNombre());

        this.vistaActual = vistaJugador1;
        this.vistaContrincante = vistaJugador2;

        this.tablero = tablero;
        this.setGrilla();
        this.setBotonera();
        this.setConsola();
        this.setVista();
    }

    private void setVista() {
        this.add(vistaActual, 0, 0, 2, 5);
        this.add(vistaContrincante, 9, 0, 2, 5);
    }

    private void setConsola() {
        consola = new Consola();
        this.add(consola.getScrollPane(), 0, 4, 12, 1);
        consola.escribirInstruccion("Es el turno de " + jugadorTurno.obtenerNombre());
    }

    public void cambiarTurno() {
        limpiarVista();
        jugadorTurno = obtenerSiguienteJugador(jugadorTurno);
        if (jugadorTurno == juego.obtenerJugador1()) {
            vistaActual = vistaJugador1;
            vistaContrincante = vistaJugador2;
        } else {
            vistaActual = vistaJugador2;
            vistaContrincante = vistaJugador1;
        }
        consola.escribirInstruccion("Es el turno de " + jugadorTurno.obtenerNombre());
        setVista();
    }

    private void limpiarVista() {
        this.getChildren().remove(vistaActual);
        this.getChildren().remove(vistaContrincante);
    }

    private Jugador obtenerSiguienteJugador(Jugador actual) {
        if (actual == juego.obtenerJugador1()) return juego.obtenerJugador2();
        return juego.obtenerJugador1();
    }

    public void setFondo() {
        fondo = new Canvas(1000, 1000);
        centro = new Pane(fondo);

        Image imagen = new Image("/vista/imagenes/fondoTablero.jpg");
        ImageView imagenFondo = new ImageView(imagen);
        this.add(imagenFondo, 3, 1, 6, 2);
        this.setStyle("-fx-background-color: black;");


       /* Image imagen = new Image("vista/imagenes/fondoTablero.jpg");

        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

        this.setBackground(new Background(imagenDeFondo));
        */
    }

    private void setBotonera() { //Faltarían los botones de cambiar de fase

        BotonCambiarTurno botonCambiarTurno = new BotonCambiarTurno(this);
        botonCambiarTurno.setText("Fin del Turno");
        botonCambiarTurno.setDefaultButton(true);
        botonCambiarTurno.setStyle("-fx-base: red;");
        botonCambiarTurno.setPrefSize(150, 30);

        botonCambiarTurno.setDefaultButton(true);
        botonCambiarTurno.setOnAction(botonCambiarTurno);

        this.add(botonCambiarTurno, 9, 3, 3, 1);

    }

    private void setGrilla() {
        this.setGridLinesVisible(false);
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

    private void ubicarObjeto(Node rectangle, int fila, int columna) {
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

        //Setteo modelo.cartas trampa
        for (int i = 0; i <= 3; i += 3) {
            for (int j = 3; j <= 7; j++) {
                Rectangle recTrampa = generarRectangulo(Color.DARKTURQUOISE, 125, 125);
                ubicarObjeto(recTrampa, i, j);
                ubicarTexto("Carta Trampa", 10, i, j);
            }
        }

        //Setteo modelo.cartas monstruo
        for (int i = 1; i <= 2; i++) {
            for (int j = 3; j <= 7; j++) {
                Rectangle recMonstruo = generarRectangulo(Color.DARKORANGE, 125, 125);
                ubicarObjeto(recMonstruo, i, j);
                ubicarTexto("Carta Monstruo", 10, i, j);
            }
        }

        //Setteo modelo.cartas campo
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
        Image imagen = new Image(getClass().getResourceAsStream("/vista/imagenes/cartaAtras.jpg"));
        ImageView mazo1 = new ImageView(imagen);
        ubicarObjeto(mazo1, 0, 2);
        ImageView mazo2 = new ImageView(imagen);
        ubicarObjeto(mazo2, 3, 8);

        //Setteo cartasContrincante
        ImageView carta1 = new ImageView(imagen);
        carta1.setRotate(360-20);
        ImageView carta2 = new ImageView(imagen);
        ImageView carta3 = new ImageView(imagen);
        carta3.setRotate(20);

        ubicarObjeto(carta1, 1, 9);
        ubicarObjeto(carta2, 1, 10);
        ubicarObjeto(carta3, 1, 11);
    }
}