package cartas.cartasMonstruo;

import estadosDeCartas.Modo;
import jugador.Punto;

public class MaldicionDeDragon extends CartaMonstruo {
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public MaldicionDeDragon() {
        super("Maldicion De Dragon", 2000, 1500, 5);
        modo = null;
    }
}
