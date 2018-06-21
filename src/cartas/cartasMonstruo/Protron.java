package cartas.cartasMonstruo;

import estadosDeCartas.Modo;
import jugador.Punto;

public class Protron extends CartaMonstruo {
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public Protron() {
        super("Protron", 100, 100, 1);
        modo = null;
    }
}
