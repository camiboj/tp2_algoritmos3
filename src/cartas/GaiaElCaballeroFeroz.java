package cartas;

import estadosDeCartas.Modo;
import jugador.Punto;

public class GaiaElCaballeroFeroz extends CartaMonstruo{
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public GaiaElCaballeroFeroz() {
        super("Gaia El Caballero Feroz", 2300, 2100, 7);
        modo = null;
    }
}
