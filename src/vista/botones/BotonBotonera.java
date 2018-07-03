package vista.botones;

import javafx.scene.control.Button;

public class BotonBotonera extends Button {

    public BotonBotonera(String nombreBoton) {
        this.setStyle("-fx-base: red;");
        this.setPrefSize(150, 50);
        this.setText(nombreBoton);
        this.setDefaultButton(true);
    }
}
