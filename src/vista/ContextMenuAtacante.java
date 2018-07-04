package vista;

import javafx.scene.control.ContextMenu;
import vista.botones.BotonCartaZonaMonstruo;

public class ContextMenuAtacante extends ContextMenu {
    private BotonCartaZonaMonstruo botonCarta;

    public void agregarCarta(BotonCartaZonaMonstruo botonCarta) {
        this.botonCarta = botonCarta;
    }

    public BotonCartaZonaMonstruo obtenerBotonAtacante() {
        return botonCarta;
    }
}
