package cartas;
import estadosDeCartas.Modo;
import estadosDeCartas.ModoDeDefensa;
import jugador.Punto;
import tablero.Casillero;

public class AlasDeLaLlamaPerversa extends CartaMonstruo {
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public AlasDeLaLlamaPerversa() {
        super("Alas De La Llama Perversa", 700, 600, 2);
        modo = null;
    }
}
