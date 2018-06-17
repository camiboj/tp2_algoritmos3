package jugador;
public class Jugador {
    private Punto puntosJuego;

    /*
    public Jugador() {
        puntosJuego = new Punto(8000); //El jugador empieza con 8000 puntos de vida
    }
    */

    @Override
    public boolean equals(Object object){return this.getClass().equals(object.getClass());}
}
