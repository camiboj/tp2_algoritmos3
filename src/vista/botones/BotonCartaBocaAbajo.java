package vista.botones;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class BotonCartaBocaAbajo extends Button implements EventHandler<ActionEvent> {

    public BotonCartaBocaAbajo() {
        Image image = new Image(getClass().getResourceAsStream("/vista/imagenes/cartaAtras.jpg"));
        this.setGraphic(new ImageView(image));
    }

    @Override
    public void handle(ActionEvent event) {
        //stage.show();
    }
}