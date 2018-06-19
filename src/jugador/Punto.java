package jugador;

public class Punto {
    private int numero;

    public Punto(int unValor) {
        numero = unValor;
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

    public Punto sumar(Punto puntosDefensaAdicionales) {
        Punto resultado = new Punto(numero + puntosDefensaAdicionales.obtenerNumero());
        return resultado;
    }
}
