package modelo.cartas.cartasMonstruo.exodia;

import modelo.cartas.cartasMonstruo.CartaMonstruo;

public abstract class CartaMonstruoExodia extends CartaMonstruo {
    CartaMonstruoExodia(String unNombre, int puntosAtaque, int puntosDefensa, int cantidadEstrellas) {
        super(unNombre, puntosAtaque, puntosDefensa, cantidadEstrellas);
    }
}
