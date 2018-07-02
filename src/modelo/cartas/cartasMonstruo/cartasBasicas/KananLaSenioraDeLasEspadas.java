package modelo.cartas.cartasMonstruo.cartasBasicas;

import modelo.cartas.cartasMonstruo.CartaMonstruo;
import modelo.cartas.cartasMonstruo.Nivel;
import modelo.estadosDeCartas.Modo;
import modelo.jugador.Punto;

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
