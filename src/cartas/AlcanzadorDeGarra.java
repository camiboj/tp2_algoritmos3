package cartas;

import estadosDeCartas.Modo;
import jugador.Punto;
import tablero.Casillero;

public class AlcanzadorDeGarra extends CartaMonstruo {
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public AlcanzadorDeGarra() {
        super("Alcanzador de Garra", 1000, 800, 3);
        modo = null;
    }
}
