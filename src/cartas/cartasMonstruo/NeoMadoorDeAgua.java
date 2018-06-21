package cartas.cartasMonstruo;

import estadosDeCartas.Modo;
import jugador.Punto;

public class NeoMadoorDeAgua extends CartaMonstruo {
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public NeoMadoorDeAgua() {
        super("Neo Madoor De Agua", 1200, 3000, 6);
        modo = null;
    }
}
