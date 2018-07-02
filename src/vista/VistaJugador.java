package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import modelo.jugador.Jugador;
import modelo.tablero.LadoDelCampo;

public class VistaJugador extends VBox {
    private Jugador jugador;
    LadoDelCampo ladoDelCampo;
    private String nombre;

    public VistaJugador(Jugador jugador, LadoDelCampo ladoDelCampo, String nombre) {
        this.nombre = nombre;
        this.ladoDelCampo = ladoDelCampo;
        this.jugador = jugador;
        this.agregarTexto();
    }

    private void agregarTexto() {

        this.setAlignment(Pos.TOP_CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        Label nombreJugador = new Label(nombre);
        nombreJugador.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        nombreJugador.setTextAlignment(TextAlignment.CENTER);
        nombreJugador.setTextFill(Color.WHITE);

        Label puntosJugador = new Label("Puntos: " + String.valueOf(jugador.obtenerPuntos().obtenerNumero()));
        puntosJugador.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        puntosJugador.setTextAlignment(TextAlignment.CENTER);
        puntosJugador.setTextFill(Color.WHITE);

        this.getChildren().addAll(puntosJugador, nombreJugador);
    }

    public void reset(){
        this.getChildren().clear();
    }


}
