package modelo.cartas.cartasCampo;

import modelo.cartas.Carta;
import modelo.jugador.Jugador;
import modelo.jugador.Punto;
import modelo.tablero.Tablero;
import modelo.tablero.ZonaMonstruo;

public abstract class CartaCampo extends Carta {
    protected ZonaMonstruo zonaMonstruoPropia;
    protected ZonaMonstruo zonaMonstruoOponente;
    protected Punto puntosAdicionalesAtaque;
    protected Punto puntosAdicionalesDefensa;
    private Jugador jugadorPoseedor;
    private Tablero tablero;

    public CartaCampo(String unNombre,
                      Punto unosPuntosAdicionalesAtaque, Punto unosPuntosAdicionalesDefensa) {
        super(unNombre);
        puntosAdicionalesAtaque = unosPuntosAdicionalesAtaque;
        puntosAdicionalesDefensa = unosPuntosAdicionalesDefensa;
    }
    @Override
    public  void asignarJugador(Jugador jugador){
        jugadorPoseedor=jugador;
        if (tablero!=null){
            zonaMonstruoPropia= tablero.get(jugadorPoseedor).obtenerZonaMonstruos();
            zonaMonstruoOponente= tablero.get(tablero.obtenerJugadorOponente(jugadorPoseedor)).obtenerZonaMonstruos();

        }
    }
    @Override
    public  void asignarTablero(Tablero tablero){
        this.tablero=tablero;
        if (jugadorPoseedor!=null){
            zonaMonstruoPropia= tablero.get(jugadorPoseedor).obtenerZonaMonstruos();
            zonaMonstruoOponente= tablero.get(tablero.obtenerJugadorOponente(jugadorPoseedor)).obtenerZonaMonstruos();

        }
    }
    public abstract void activarEfecto();
}
