package cartas;

import estadosDeCartas.Modo;
import jugador.Punto;

public class Lobo extends CartaMonstruo{
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public Lobo() {
        super("Lobo", 1200, 800, 3);
        modo = null;
    }
}
