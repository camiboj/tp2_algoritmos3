package cartas.cartasMonstruo;

import estadosDeCartas.Modo;
import jugador.Punto;

public class MurcielagoDeMeda extends CartaMonstruo {
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public MurcielagoDeMeda() {
        super("Murcielago De Meda", 800, 400, 2);
        modo = null;
    }
}
