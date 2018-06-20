package cartas;

import estadosDeCartas.Modo;
import jugador.Punto;

public class Frostosaurus extends CartaMonstruo{
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public Frostosaurus() {
        super("Frostosaurus", 2600, 1700, 6);
        modo = null;
    }
}
