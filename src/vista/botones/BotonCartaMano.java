package vista.botones;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.WindowEvent;
import modelo.cartas.Carta;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.Label;

import java.awt.TextField;

public class BotonCartaMano extends Button implements EventHandler<ActionEvent> {

    private final Carta carta;

    public BotonCartaMano(String nombre, Carta carta) {
        String ruta = "/vista/imagenes/" + nombre + ".jpg";
        Image image = new Image(getClass().getResourceAsStream(ruta));

        BackgroundSize size = new BackgroundSize(70, 120, true, true, true, false);

        BackgroundImage imagenBoton = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, size);
        this.setBackground(new Background(imagenBoton));
        this.carta = carta;
        this.setPrefSize(70, 120);


        Tooltip tt = new Tooltip("Efecto: " + carta.obtenerEfecto());
        this.setTooltip(tt);
        
        final ContextMenu contextMenu = new ContextMenu();
        MenuItem modoAtaque = new MenuItem("Modo Ataque");
        MenuItem modoDefensa = new MenuItem("Modo Defensa");

        contextMenu.getItems().addAll(modoAtaque,modoDefensa);

        this.setContextMenu(contextMenu);


    }

    @Override
    public void handle(ActionEvent event) {







        //stage.show();
    }
}
