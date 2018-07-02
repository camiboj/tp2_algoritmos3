package modelo.estadosDeCartas;
import modelo.jugador.Punto;

public abstract class Modo {
    private Punto punto;

    public Modo(Punto unPunto) {
        punto = unPunto;
    }

    public Punto obtenerPuntos(){
        return punto;
    }

    public abstract boolean enAtaque();

    public abstract boolean enDefensa();

    public void actualizarPuntos(Punto nuevoValor) {
        punto = nuevoValor;
    }


}
