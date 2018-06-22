package cartas.cartasMonstruo.cartasBasicas;

import cartas.cartasMonstruo.CartaMonstruo;
import cartas.cartasMonstruo.Nivel;
import estadosDeCartas.Modo;
import jugador.Punto;

public class OgroDeAcero extends CartaMonstruo {
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public OgroDeAcero() {
        super("Ogro De Acero", 1400, 1800, 5);
        modo = null;
    }
}
