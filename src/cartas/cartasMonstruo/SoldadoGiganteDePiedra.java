package cartas.cartasMonstruo;

import estadosDeCartas.Modo;
import jugador.Punto;

public class SoldadoGiganteDePiedra extends CartaMonstruo {
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public SoldadoGiganteDePiedra() {
        super("Murcielago De Meda", 1300, 2000, 3);
        modo = null;
    }
}
