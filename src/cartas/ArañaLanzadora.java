package cartas;

import estadosDeCartas.Modo;
import jugador.Punto;

public class ArañaLanzadora extends CartaMonstruo {
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public ArañaLanzadora () {
        super("Araña Lanzadora", 2200, 2500, 7);
        modo = null;
    }
}
