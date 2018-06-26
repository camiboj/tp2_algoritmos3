package jugador;

import cartas.Carta;
import cartas.cartasMonstruo.exodia.CartaMonstruoExodia;

import java.util.List;

public class Jugador {
    private Punto puntosJuego;
    private Mazo mazo;
    private Mano mano;

    public Jugador() {
        puntosJuego = new Punto(8000);
        mazo = new Mazo(); //El jugador empieza con 8000 puntos de vida
        mano = this.crearMano();
    }

    public boolean sinMazo() {
        return mazo.estaVacio();
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
        Punto resultado = puntosJuego.restar(puntosRestados);
        puntosJuego = resultado;
    }

    public boolean pierde(Mano manoJugadorOponente) {
        return this.sinPuntos() || this.sinMazo() || manoJugadorOponente.sonTodasExodia();
    }

    public boolean gana() {
        return (! this.sinPuntos() && ! this.sinMazo()) || mano.sonTodasExodia();
    }

    public boolean equals(Object object){return this.getClass().equals(object.getClass());}

    public void agarraCartas(int cantidad) {
        for (int i = 0; i<cantidad; i += 1) {
            Carta carta = mazo.sacarCarta();
            mano.agregarCarta(carta);

        }
    }

    public void crearManoConCartas(List <Carta> cartas) {
        Mano unaMano = new Mano();
        for (Carta carta: cartas) {
            unaMano.agregarCarta(carta);
        }
        mano = unaMano;
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

    public boolean sinPuntos() {
        return puntosJuego.obtenerNumero()<0;
    }

    public Mano mostrarMano() { return mano; }
}
