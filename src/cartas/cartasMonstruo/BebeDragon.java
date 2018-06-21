package cartas.cartasMonstruo;

import estadosDeCartas.Modo;
import jugador.Punto;

public class BebeDragon extends CartaMonstruo {
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public BebeDragon() {
        super("Bebe Dragon", 1200, 700, 3);
        modo = null;
    }
}
