package cartas.cartasMonstruo;

import estadosDeCartas.Modo;
import jugador.Punto;

public class CerebrusDeLlamas extends CartaMonstruo {
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public CerebrusDeLlamas() {
        super("Cerebrus De Llamas", 2100, 1800, 6);
        modo = null;
    }
}
