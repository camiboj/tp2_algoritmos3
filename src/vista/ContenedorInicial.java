package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import jugador.YuGiOh;
import vista.botones.BotonInicializar;
import vista.botones.BotonJugar;

public class ContenedorInicial extends VBox {

    public ContenedorInicial(Stage stage, YuGiOh yuGiOh) {
        super();
        MediaPlayer mediaplayer;

        //Reproductor de la cancion de inicio
        String path = Main.class.getResource("sonidos/cancionInicio.mp3").toString(); //Agregar cancion_inicio
        Media file = new Media(path);
        mediaplayer = new MediaPlayer(file);
        mediaplayer.setAutoPlay(true);
        mediaplayer.setVolume(0.3);
        mediaplayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaplayer.play();

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        Image imagen = new Image("vista/imagenes/YuGiOhInicial2.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        Button botonJugar = new Button();
        botonJugar.setText("Iniciar partida");
        botonJugar.setDefaultButton(true);
        botonJugar.setPrefSize(100, 50);
        botonJugar.setDisable(true);

        TextField jugador1 = new TextField();
        jugador1.setPromptText("nombre");
        jugador1.setMaxWidth(250);
        jugador1.setText("Jugador 1");

        TextField jugador2 = new TextField();
        jugador2.setPromptText("nombre");
        jugador2.setMaxWidth(250);
        jugador2.setText("Jugador 2");

        Button botonNombres = new Button();
        botonNombres.setText("Aceptar");
        BotonInicializar botonInicializar = new BotonInicializar(this);
        botonNombres.setOnAction(botonInicializar);

        BotonJugar botonJugarHandler = new BotonJugar(stage, yuGiOh, mediaplayer);
        botonJugar.setOnAction(botonJugarHandler);

        this.getChildren().addAll(botonJugar, jugador1, jugador2, botonNombres);
    }

    public void habilitarJugarTrasAceptar() {
        this.getChildren().get(0).setDisable(false);
    }
}
