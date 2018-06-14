public abstract class Monstruo extends Carta {
    protected Punto puntosAtaque;
    protected Punto puntosDefensa;
    protected Nivel nivel;
    protected Modo modo;
    protected String nombre;

    public Monstruo(String nombre, Punto puntosAtaque, Punto puntosDefensa, Nivel nivel) {
        this.puntosAtaque = puntosAtaque;
        this.puntosDefensa = puntosDefensa;
        this.nivel = nivel;
        this.nombre = nombre;
    }


    public void colocarEnPosicionDeAtaque() {

    }
}
