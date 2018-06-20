package cartas;

import estadosDeCartas.Modo;
import jugador.Punto;

public class EscarabajoHercules extends CartaMonstruo{
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public EscarabajoHercules() {
        super("Escarabajo Hercules", 1500, 2000, 5);
        modo = null;
    }
}
