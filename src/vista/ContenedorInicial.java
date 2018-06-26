package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
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


        this.setAlignment(Pos.TOP_CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        Image imagen = new Image("vista/imagenes/YuGiOhInicial2.png");
        BackgroundPosition position = new BackgroundPosition(Side.LEFT, 0.5,
                true, Side.BOTTOM, 0, true);
        BackgroundSize size = new BackgroundSize(0.75, 0.60, true, true, true, false);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                position, size);
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

        BotonJugar botonJugarHandler = new BotonJugar(stage, yuGiOh);
        botonJugar.setOnAction(botonJugarHandler);

        this.getChildren().addAll(botonJugar, jugador1, jugador2, botonNombres);
    }

    public void habilitarJugarTrasAceptar() {
        this.getChildren().get(0).setDisable(false);
    }
}
