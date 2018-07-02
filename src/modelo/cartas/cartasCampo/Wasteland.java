package modelo.cartas.cartasCampo;

import modelo.jugador.Punto;
import modelo.tablero.ZonaMonstruo;

public class Wasteland extends CartaCampo {

    public Wasteland(ZonaMonstruo unaZonaMonstruoAtacante, ZonaMonstruo unaZonaMonstruoPropia) {
        super("Wasteland", unaZonaMonstruoPropia, unaZonaMonstruoAtacante, new Punto(200),
                    new Punto(300));
    }

    @Override
    public void activarEfecto() {
        this.zonaMonstruoPropia.aumentarAtaque(puntosAdicionalesAtaque);
        this.zonaMonstruoOponente.aumentarDefensa(puntosAdicionalesDefensa);
    }
}





