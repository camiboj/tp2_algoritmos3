package cartas.cartasMonstruo;

import cartas.cartasMonstruo.CartaMonstruo;
import estadosDeCartas.Modo;
import jugador.Punto;

public class PicoExcavador extends CartaMonstruo {
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public PicoExcavador() {
        super("Pico Excavador", 500, 800, 2);
        modo = null;
    }
}
