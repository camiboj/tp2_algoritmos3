package vista;

import javafx.scene.control.CheckBox;
import modelo.cartas.Carta;
import modelo.cartas.cartasMonstruo.CartaMonstruo;
import vista.botones.BotonCarta;

public class CheckBoxCarta extends CheckBox {

    private final BotonCarta botonCarta;

    public CheckBoxCarta(BotonCarta botonCarta){
        this.botonCarta = botonCarta;
    }

    public BotonCarta obtenerBotonCarta() {
        return botonCarta;
    }
}
