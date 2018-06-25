package vista.botones;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Tooltip;

public class Boton extends Button {

    public Boton (String texto, javafx.event.EventHandler<ActionEvent> controlador){
        setTexto(texto);
        setControlador(controlador);
    }
    public void textoAlPasarMouse(String texto){
        setTooltip(new Tooltip(texto));
    }

    public void setTexto(String texto){
        setText(texto);
    }
    public void setControlador(javafx.event.EventHandler<ActionEvent> controlador) {
        setOnAction(controlador);
    }
}
