package jugador;
import cartas.Carta;
import cartas.HuevoMonstruoso;

import java.util.Stack;
public class Mazo {
    private Stack<Carta> cartas;
    private int cantidadDeCartas;

    public Mazo() {
        cartas = new Stack();
        cantidadDeCartas = 40;
        for(int i = 0; i<40; i++) {
            HuevoMonstruoso carta = new HuevoMonstruoso();
            cartas.push(carta);
        }
    }

    public Carta sacarCarta() {
        Carta carta = cartas.pop();
        cantidadDeCartas --;
        return carta;
    }

    public int obtenerCantidad() {
        return cantidadDeCartas;
    }
}