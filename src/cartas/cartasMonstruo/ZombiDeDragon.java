package cartas.cartasMonstruo;

import estadosDeCartas.Modo;
import jugador.Punto;

public class ZombiDeDragon extends CartaMonstruo {
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public ZombiDeDragon() {
        super("Zombi De Dragon", 1600, 0, 3);
        modo = null;
    }
}
