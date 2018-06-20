package cartas;

import estadosDeCartas.Modo;
import jugador.Punto;

public class RengeCustodioDelMundoOscuro extends CartaMonstruo{
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public RengeCustodioDelMundoOscuro() {
        super("Renge Custodio Del Mundo Oscuro", 100, 2100, 4);
        modo = null;
    }
}
