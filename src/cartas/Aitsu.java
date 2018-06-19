package cartas;
import estadosDeCartas.Modo;
import jugador.Punto;

public class Aitsu extends CartaMonstruo {
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public Aitsu() {
        super("Aitsu", 100, 100, 4);
        modo = null;
    }
}
