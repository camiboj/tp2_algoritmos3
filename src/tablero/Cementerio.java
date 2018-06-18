package tablero;
import cartas.Carta;

import java.util.ArrayList;

public class Cementerio implements Zona {
    private ArrayList<Carta> cartas;

    public Cementerio () {
        cartas = new ArrayList <Carta>();
    }

    public boolean colocarCarta(Carta unaCarta) {
        cartas.add(unaCarta);
        return true;
    }

    public void eliminar(Carta carta) {
        cartas.remove(carta);
    }

    public boolean existe(Carta unaCarta) {
        return cartas.contains(unaCarta);
    }

    public boolean equals(Object object){return this.getClass().equals(object.getClass());}
}
