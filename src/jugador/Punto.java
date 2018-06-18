package jugador;

public class Punto {
    private int numero;

    public Punto(int unPunto) {
        numero = unPunto;
    }

    public int obtenerNumero() {
        return numero;
    }

    public boolean esMayor(Punto unPunto) {
        return numero > unPunto.obtenerNumero();
    }

    public Punto restar(Punto unPunto) {
        Punto resultado = new Punto(numero - (unPunto.obtenerNumero()));
        return resultado;
    }

    public boolean equals(Object object){return this.getClass().equals(object.getClass());}
}
