package cartas;

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
        return cartasASacrificar.size() == devolverNumeroDeSacrificios();
    }
}