package jugador;

import cartas.Carta;

public class Jugador {
    private Punto puntosJuego;
    private Mazo mazo;
    private Mano mano;

    public Jugador() {
        puntosJuego = new Punto(8000);
        mazo = new Mazo(); //El jugador empieza con 8000 puntos de vida
        mano = this.crearMano();
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

    public void agarraCartas(int cantidad) {
        for (int i = 0; i<2; i += 1) {
            Carta carta = mazo.sacarCarta();
            mano.agregarCarta(carta);

        }
    }

    public Mano crearMano(){
        Mano unaMano = new Mano();
        for (int i = 0; i<5; i += 1) {
            Carta carta = mazo.sacarCarta();
            unaMano.agregarCarta(carta);
        }
        return unaMano;
    }

    public int cantidadDeCartasEnMano() {
        return mano.obtenerCantidad();
    }

    public int cantidadDeCartasEnMazo() {
        return mazo.obtenerCantidad();
    }

    public void sacarDeMano(Carta carta) {
        mano.sacar(carta);
    }
}
