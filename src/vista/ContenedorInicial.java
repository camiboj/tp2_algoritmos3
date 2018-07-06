package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import modelo.jugador.YuGiOh;
import vista.botones.BotonIniciarJuego;

public class ContenedorInicial extends VBox {

    private final MediaPlayer mediaplayer;

    public ContenedorInicial(Stage stage, YuGiOh yuGiOh) {
        super();

        String path = Main.class.getResource("sonidos/cancionInicial.mp3").toString();

        Media file = new Media(path);
        this.mediaplayer = new MediaPlayer(file);
        mediaplayer.setAutoPlay(true);
        mediaplayer.setVolume(0.3);
        mediaplayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaplayer.play();

        this.ubicarTituloSubtitulo();

        this.setAlignment(Pos.TOP_CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        this.fijarFondo();

        this.fijarBotones(stage, yuGiOh);
    }

    private void fijarBotones(Stage stage, YuGiOh yuGiOh) {
        TextField jugador1 = new TextField();
        jugador1.setPromptText("Ingrese su nombre");
        jugador1.setMaxWidth(250);
        jugador1.setText("Jugador 1");

        TextField jugador2 = new TextField();
        jugador2.setPromptText("Ingrese su nombre");
        jugador2.setMaxWidth(250);
        jugador2.setText("Jugador 2");

        BotonIniciarJuego botonJugar = new BotonIniciarJuego(stage, yuGiOh, jugador1, jugador2, mediaplayer);
        botonJugar.setText("Iniciar partida");
        botonJugar.setDefaultButton(true);
        botonJugar.setStyle("-fx-base: red;");
        botonJugar.setPrefSize(120, 30);

        botonJugar.setDefaultButton(true);
        botonJugar.setOnAction(botonJugar);

        this.getChildren().addAll(botonJugar, jugador1, jugador2);
    }

    private void fijarFondo() {

        Image imagen = new Image("vista/imagenes/YuGiOhInicial2.png");
        BackgroundPosition position = new BackgroundPosition(Side.LEFT, 0.5,
                true, Side.BOTTOM, 0, true);
        BackgroundSize size = new BackgroundSize(0.20, 0.40, true, true, true, false);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                position, size);
        this.setBackground(new Background(imagenDeFondo));
        this.setBackground(new Background(imagenDeFondo));

    }

    private void ubicarTituloSubtitulo() {
        Label titulo = new Label("Yu-Gi-Oh!");
        titulo.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        titulo.setTextAlignment(TextAlignment.CENTER);
        titulo.setTextFill(Color.web("000000"));
        Label subtitulo = new Label("The Darkest Side Of Dimensions");
        subtitulo.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
        subtitulo.setTextAlignment(TextAlignment.CENTER);
        subtitulo.setTextFill(Color.web("000000"));
        this.getChildren().addAll(titulo, subtitulo);
    }
}
