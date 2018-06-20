package cartas;

import estadosDeCartas.Modo;
import jugador.Punto;

public class OjamaAmarillo extends CartaMonstruo{
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public OjamaAmarillo() {
        super("Ojama Amarillo", 0, 1000, 2);
        modo = null;
    }
}
