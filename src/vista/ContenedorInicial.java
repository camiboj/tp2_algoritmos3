package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import jugador.YuGiOh;
import vista.botones.BotonInicializar;
import vista.botones.BotonJugar;

public class ContenedorInicial extends VBox {

    public ContenedorInicial(Stage stage, YuGiOh yuGiOh) {
        super();

        //Agrego titulo y subtitulo
        Label titulo = new Label("Yu-Gi-Oh!");
        titulo.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        titulo.setTextAlignment(TextAlignment.CENTER);
        titulo.setTextFill(Color.web("000000"));
        Label subtitulo = new Label("The Darkest Side Of Dimensions");
        subtitulo.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
        subtitulo.setTextAlignment(TextAlignment.CENTER);
        subtitulo.setTextFill(Color.web("000000"));

        /*
        this.getChildren().addAll(titulo,subtitulo);
        */


        this.setAlignment(Pos.TOP_CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        Image imagen = new Image("vista/imagenes/YuGiOhInicial2.png");
        BackgroundPosition position = new BackgroundPosition(Side.LEFT, 0.5,
                true, Side.BOTTOM, 0, true);
        BackgroundSize size = new BackgroundSize(0.20, 0.40, true, true, true, false);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                position, size);
        this.setBackground(new Background(imagenDeFondo));

        Button botonJugar = new Button();
        botonJugar.setText("Iniciar partida");
        botonJugar.setDefaultButton(true);
        botonJugar.setStyle("-fx-base: red;");
        botonJugar.setPrefSize(120, 30);
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
        botonNombres.setStyle("-fx-base: red;");
        BotonInicializar botonInicializar = new BotonInicializar(this);
        botonNombres.setOnAction(botonInicializar);

        BotonJugar botonJugarHandler = new BotonJugar(stage, yuGiOh);
        botonJugar.setOnAction(botonJugarHandler);

        this.getChildren().addAll(botonJugar, titulo, subtitulo, jugador1, jugador2, botonNombres);
    }

    public void habilitarJugarTrasAceptar() {
        this.getChildren().get(0).setDisable(false);
    }
}
