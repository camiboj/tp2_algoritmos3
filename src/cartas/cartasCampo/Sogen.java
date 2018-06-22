package cartas.cartasCampo;

import cartas.cartasCampo.CartaCampo;
import jugador.Punto;
import tablero.ZonaMonstruo;

public class Sogen extends CartaCampo {

    public Sogen(ZonaMonstruo unaZonaMonstruoAtacante, ZonaMonstruo unaZonaMonstruoPropia) {
        super("Sogen", unaZonaMonstruoPropia, unaZonaMonstruoAtacante, new Punto(200),
                new Punto(500));
    }

    @Override
    public void activarEfecto() {
        this.zonaMonstruoPropia.aumentarDefensa(puntosAdicionalesDefensa);
        this.zonaMonstruoOponente.aumentarAtaque(puntosAdicionalesAtaque);
    }
}
