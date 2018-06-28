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
        Text text = new Text(">>> Consola");
        text.setFont(Font.font("Courier New", 12));
        text.setFill(Color.BLACK);

        HBox consola = new HBox(text);
        consola.setStyle("-fx-background-color: grey;");
        consola.setPrefHeight(70);
        contenedorConsola = consola;

        scrollPane = new ScrollPane(contenedorConsola);
        scrollPane.setStyle("-fx-background: grey;");
        scrollPane.vvalueProperty().bind(contenedorConsola.widthProperty());
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setStyle("");
    }

    public void escribirInstruccion(String instruccion) {

        /*if (contenedorConsola == null) {
            System.out.println(instruccion);
            return;
        }*/
        Text text = new Text(instruccion);
        text.setFont(Font.font("Courier New", 12));
        text.setFill(Color.BLACK);
        contenedorConsola.getChildren().add(text);
    }

    public Node getScrollPane() {
        return scrollPane;
    }
}
