package cartas;

import estadosDeCartas.Modo;
import jugador.Punto;

public class BestiaDeTalwar extends CartaMonstruo {
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public BestiaDeTalwar() {
        super("Bestia de Talwar", 2400, 2150, 6);
        modo = null;
    }
}
