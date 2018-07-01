package jugador;

import cartas.Carta;
import cartas.cartasMonstruo.exodia.CartaMonstruoExodia;
import excepciones.FinDelJuegoException;
import excepciones.VictoriaException;
import tablero.ZonaMonstruo;

import java.util.EmptyStackException;
import java.util.List;

public class Jugador {
    private Punto puntosJuego;
    private Mazo mazo;
    private Mano mano;
    private String nombre;

    public Jugador () {
        puntosJuego = new Punto(8000);
        //mazo = new Mazo(nombreDelMazo, jugador, jugadorContrario, zonaMonstruoAtacante, zonaMonstruoPropia); //El jugador empieza con 8000 puntos de vida
    }

    public void guardarMazo(Mazo mazo) throws VictoriaException {
        this.mazo = mazo;
        this.crearMano();
    }

    public boolean sinMazo() {
        return mazo.estaVacio();
    }

    public Mazo obtenerMazo() {
        return mazo;
    }

    public Carta sacarCarta () throws FinDelJuegoException {
        try{
        return mazo.sacarCarta();

        }
        catch (EmptyStackException datosDelFinal){
            throw new FinDelJuegoException("No hay mas cartas en el mazo", this);
        }
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

    public void agarraCartas(int cantidad) throws VictoriaException {
        for (int i = 0; i<cantidad; i += 1) {
            Carta carta = mazo.sacarCarta();
            mano.agregarCarta(carta);

        }
    }

    public void crearManoConCartas(List <Carta> cartas) throws VictoriaException {
        mano = new Mano();
        for (Carta carta: cartas) {
            mano.agregarCarta(carta);
        }

    }

    public void crearMano() throws VictoriaException {
        mano = new Mano();
        for (int i = 0; i<5; i += 1) {
            Carta carta = mazo.sacarCarta();
            mano.agregarCarta(carta);
        }

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

    public void guardarNombre(String nombre1) {
        this.nombre = nombre1;
    }

    public String obtenerNombre() {
        return nombre;
    }
}
