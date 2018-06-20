package cartas;

import estadosDeCartas.Modo;
import jugador.Punto;

public class DragonBlancoDeOjosAzules extends CartaMonstruo{
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public DragonBlancoDeOjosAzules() {
        super("Dragon Blanco De Ojos Azules", 3000, 2500, 8);
        modo = null;
    }
}
