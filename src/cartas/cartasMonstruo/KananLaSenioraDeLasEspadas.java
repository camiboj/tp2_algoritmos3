package cartas.cartasMonstruo;

import cartas.cartasMonstruo.CartaMonstruo;
import estadosDeCartas.Modo;
import jugador.Punto;

public class KananLaSenioraDeLasEspadas extends CartaMonstruo {
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public KananLaSenioraDeLasEspadas() {
        super("Kanan La Seniora De Las Espadas", 1400, 1400, 4);
        modo = null;
    }
}
