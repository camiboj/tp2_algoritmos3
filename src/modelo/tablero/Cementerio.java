package modelo.tablero;
import modelo.cartas.Carta;

import java.util.ArrayList;

public class Cementerio {
    private ArrayList<Carta> cartas;

    public Cementerio () {
        cartas = new ArrayList <Carta>();
    }

    public boolean colocarCarta(Carta carta) {
        cartas.add(carta);
        return true;
    }

    public void eliminarCarta(Carta carta) {
        cartas.remove(carta);
    }

    public boolean existe(Carta unaCarta) {
        return cartas.contains(unaCarta);
    }

    public boolean equals(Object object){return this.getClass().equals(object.getClass());}
}
