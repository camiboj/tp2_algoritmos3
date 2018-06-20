package cartas;

import estadosDeCartas.Modo;
import jugador.Punto;

public class ElFuriosoReyDeLosMares extends CartaMonstruo{
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public ElFuriosoReyDeLosMares() {
        super("El Furioso Rey De Los Mares", 800, 700, 3);
        modo = null;
    }
}
