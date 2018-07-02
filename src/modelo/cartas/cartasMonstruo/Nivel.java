package modelo.cartas.cartasMonstruo;

import modelo.cartas.cartasMonstruo.CartaMonstruo;

import java.util.List;

public class Nivel {
    private int cantidadEstrellas;

    public Nivel(int unaCantidad) {
        cantidadEstrellas = unaCantidad;
    }

    public int devolverNumeroDeSacrificios() {
        if (cantidadEstrellas <= 4) return 0;
        if (cantidadEstrellas <= 6) return 1;
        return 2;
    }

    public boolean validarSacrificios(List<CartaMonstruo> cartasASacrificar) {
        if (cartasASacrificar == null && devolverNumeroDeSacrificios() == 0) return true;
        return cartasASacrificar.size() == devolverNumeroDeSacrificios();
    }
}