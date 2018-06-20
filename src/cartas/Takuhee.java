package cartas;

import estadosDeCartas.Modo;
import jugador.Punto;

public class Takuhee extends CartaMonstruo{
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public Takuhee() {
        super("Takuhee", 1450, 1000, 4);
        modo = null;
    }
}
