package cartas;

import estadosDeCartas.Modo;
import jugador.Punto;

public class MagoOscuro extends CartaMonstruo{
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public MagoOscuro() {
        super("Mago Oscuro", 2500, 2100, 7);
        modo = null;
    }
}
