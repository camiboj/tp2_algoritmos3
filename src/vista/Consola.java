package vista;

import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javax.swing.*;

public class Consola {
    HBox contenedorConsola;
    ScrollPane scrollPane;

    public Consola() {

        HBox consola = new HBox();
        consola.setStyle("-fx-background-color: grey;");
        consola.setPrefHeight(70);
        consola.setPrefWidth(20000);
        contenedorConsola = consola;

        scrollPane = new ScrollPane(contenedorConsola);
        scrollPane.setStyle("-fx-background: grey;");
        scrollPane.vvalueProperty().bind(contenedorConsola.widthProperty());
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setStyle("");
    }

    public void escribirInstruccion(String instruccion) {

        Text text = new Text(">>> " + instruccion);
        text.setFont(Font.font("Courier New", 12));
        text.setFill(Color.BLACK);
        contenedorConsola.getChildren().add(text);
    }

    public Node getScrollPane() {
        return scrollPane;
    }
}