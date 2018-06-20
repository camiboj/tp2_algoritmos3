package cartas;

import estadosDeCartas.Modo;
import jugador.Punto;

public class CementerioDeMamuts extends CartaMonstruo{
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public CementerioDeMamuts() {
        super("Cementerio De Mamuts", 1200, 800, 3);
        modo = null;
    }
}
