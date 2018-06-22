package cartas.cartasCampo;

import cartas.Carta;
import cartas.cartasMonstruo.CartaMonstruo;
import jugador.Punto;
import tablero.LadoDelCampo;
import tablero.ZonaMonstruo;

import java.util.List;

public abstract class CartaCampo extends Carta {
    protected ZonaMonstruo zonaMonstruoPropia;
    protected ZonaMonstruo zonaMonstruoOponente;
    protected Punto puntosAdicionalesAtaque;
    protected Punto puntosAdicionalesDefensa;


    public CartaCampo(String unNombre, ZonaMonstruo unaZonaMonstruoOponente, ZonaMonstruo unaZonaMonstruoPropio,
                      Punto unosPuntosAdicionalesAtaque, Punto unosPuntosAdicionalesDefensa) {
        super(unNombre);
        zonaMonstruoOponente = unaZonaMonstruoOponente;
        zonaMonstruoPropia = unaZonaMonstruoPropio;
        puntosAdicionalesAtaque = unosPuntosAdicionalesAtaque;
        puntosAdicionalesDefensa = unosPuntosAdicionalesDefensa;
    }

    public abstract void activarEfecto();
}
