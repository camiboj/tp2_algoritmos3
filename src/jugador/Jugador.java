package jugador;

import cartas.Carta;

public class Jugador {
    private Punto puntosJuego;
    private Mazo mazo;

    public Jugador() {
        puntosJuego = new Punto(8000);
        mazo = new Mazo(); //El jugador empieza con 8000 puntos de vida
    }

    public Mazo obtenerMazo() {
        return mazo;
    }

    public Carta sacarCarta () {
        return mazo.sacarCarta();
    }

    public Punto obtenerPuntos () {
        return puntosJuego;
    }

    public void restarPuntos(Punto puntosRestados) {
        puntosJuego.restar(puntosRestados);
    }

    @Override
    public boolean equals(Object object){return this.getClass().equals(object.getClass());}
}
