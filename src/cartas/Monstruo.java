package cartas;
import estadosDeCartas.Modo;
import jugador.Punto;

public class Monstruo extends Carta {
    protected Punto puntosAtaque;
    protected Punto puntosDefensa;
    protected Nivel nivel;
    protected Modo modo;
    protected String nombre;

    public Monstruo(String nombre, Punto puntosAtaque, Punto puntosDefensa, Nivel nivel) {
        super(nombre);
        this.puntosAtaque = puntosAtaque;
        this.puntosDefensa = puntosDefensa;
        this.nivel = nivel;
        this.nombre = nombre;
    }


    public void colocarEnPosicionDeAtaque() {

    }
}
