package vista.botones;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import modelo.cartas.Carta;
import javafx.stage.Stage;

import java.awt.*;

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
    }

    @Override
    public void handle(ActionEvent event) {
        //stage.show();
    }
}
