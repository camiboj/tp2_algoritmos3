package modelo.cartas.cartasMonstruo.cartasBasicas;

import modelo.cartas.cartasMonstruo.CartaMonstruo;
import modelo.cartas.cartasMonstruo.Nivel;
import modelo.estadosDeCartas.Modo;
import modelo.jugador.Punto;

public class CementerioDeMamuts extends CartaMonstruo {
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;

    public CementerioDeMamuts() {
        super("Cementerio De Mamuts", 1200, 800, 3);
        modo = null;
    }
}
