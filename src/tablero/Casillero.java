package tablero;
//import estadosDeCartas.Estado;
//import estadosDeCartas.Modo;
import cartas.Carta;

public class Casillero {
    private Carta carta;
    private boolean estaVacio;

    public Casillero() {
        estaVacio = true;
    }

    public Carta mostrarCarta() {
        return carta;
    }

    public void colocarCarta(Carta unaCarta) {
        estaVacio = false;
        carta = unaCarta;
        carta.colocarBocaArriba();
    }

    public void borrarCarta() {
        estaVacio = true;
    }

    public boolean estaVacio() {
        return estaVacio;
    }

    @Override
    public boolean equals(Object object){return this.getClass().equals(object.getClass());}

    public boolean comparar(Carta unaCarta) {
        return carta == unaCarta && !estaVacio;
    }
}