package cartas;

import estadosDeCartas.Modo;
import estadosDeCartas.ModoDeAtaque;
import estadosDeCartas.ModoDeDefensa;
import jugador.Punto;

public abstract class CartaMonstruo extends Carta {
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    //nivel
    //efecto

    public CartaMonstruo(String unNombredeCarta, int unosPuntosAtaque, int unosPuntosDefensa) {
        super(unNombredeCarta);
        puntosAtaque = new Punto(unosPuntosAtaque);
        puntosDefensa = new Punto(unosPuntosDefensa);
    }

    private void cambiarEstado(Modo m) {
        this.modo= m;
    }

    public void modoDeAtaque() {
        cambiarEstado(new ModoDeAtaque());
    }

    public void modoDeDefensa() {
        cambiarEstado(new ModoDeDefensa());
    }

    public Punto obtenerPuntosAtaque () {
        return puntosAtaque;
    }

    public void invocar() { }

    public CartaMonstruo atacar(CartaMonstruo unaCartaOponente) { //Devuelve la carta de mayor puntos de ataque
        Punto puntosAtaqueOponente = unaCartaOponente.obtenerPuntosAtaque();
        if (puntosAtaqueOponente.esMayor(puntosAtaque)) { return unaCartaOponente; }
        return this;

    }

    public Modo obtenerModo() {
        return modo;
    }
}