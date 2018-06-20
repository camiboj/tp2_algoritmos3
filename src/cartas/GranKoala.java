package cartas;

import estadosDeCartas.Modo;
import jugador.Punto;

public class GranKoala extends CartaMonstruo{
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public GranKoala() {
        super("Gran Koala", 2700, 2000, 7);
        modo = null;
    }
}
