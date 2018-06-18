package tablero;

import cartas.Carta;
import cartas.CartaMonstruo;
import cartas.HuevoMonstruoso;

public class ZonaMonstruo implements Zona {
    private Casillero[] casilleros;

    public ZonaMonstruo() {
        casilleros = new Casillero[5];
        for (int i = 0; i < 5; i += 1) {
            casilleros[i] = new Casillero();
        }
    }

    public boolean colocarCarta(Carta carta) {
        //Devuelve true si pudo colocarla y false si la zona estaba completa
        for (int i = 0; i < 5; i += 1) {
            if (casilleros[i].estaVacio()) {
                casilleros[i].colocarCarta(carta);
                return true;
            }
        }
        return false;
    }

    public void eliminarCarta(Carta carta) {
        for (int i = 0; i < 5; i += 1) {
            if (casilleros[i].comparar(carta)) {
                casilleros[i].borrarCarta();
            }
        }
    }

    public boolean existe(CartaMonstruo unaCarta) {
        for (int i = 0; i < 5; i += 1) {
            if (casilleros[i].comparar(unaCarta)) {
                return true;
            }
        }
        return false;
    }
}