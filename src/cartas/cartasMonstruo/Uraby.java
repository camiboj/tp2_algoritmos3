package cartas.cartasMonstruo;

import estadosDeCartas.Modo;
import jugador.Punto;

public class Uraby extends CartaMonstruo {
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public Uraby() {
        super("Uraby", 1500, 800, 4);
        modo = null;
    }
}
