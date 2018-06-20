package cartas;

import estadosDeCartas.Modo;
import jugador.Punto;

public class Trent extends CartaMonstruo{
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public Trent() {
        super("Trent", 1500, 1800, 5);
        modo = null;
    }
}
