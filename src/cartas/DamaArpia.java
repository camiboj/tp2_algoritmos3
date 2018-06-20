package cartas;

import estadosDeCartas.Modo;
import jugador.Punto;

public class DamaArpia extends CartaMonstruo{
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public DamaArpia() {
        super("Dama Arpia", 1300, 1400, 4);
        modo = null;
    }
}
