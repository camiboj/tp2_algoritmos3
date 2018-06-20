package cartas;

import estadosDeCartas.Modo;
import jugador.Punto;

public class HierbaDeFuego extends CartaMonstruo{
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public HierbaDeFuego() {
        super("Hierba De Fuego", 700, 600, 2);
        modo = null;
    }
}
