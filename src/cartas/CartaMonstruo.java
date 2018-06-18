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

    public void colocarEnModoDeAtaque() {
        cambiarEstado(new ModoDeAtaque(puntosAtaque));
    }

    public void colocarEnModoDeDefensa() {
        cambiarEstado(new ModoDeDefensa(puntosDefensa));
    }

    public Punto obtenerPuntos() {
        return modo.obtenerPuntos();
    }

    public void invocar() { }

    public boolean igualPuntos(CartaMonstruo unaCartaOponente) {
        return puntosAtaque.obtenerNumero() == (unaCartaOponente.obtenerPuntos().obtenerNumero());
    }

    public Modo obtenerModo() {
        return modo;
    }

    public CartaMonstruo obtenerGanadoraContra(CartaMonstruo cartaMonstruo) { //Devuelve la carta de mayor puntos de ataque
        Punto puntosAtaqueOponente = obtenerPuntos();
        if (puntosAtaqueOponente.esMayor(cartaMonstruo.puntosAtaque)) { return this; }
        return cartaMonstruo;
    }

    public boolean enModoAtaque() {return modo.enAtaque();}
    public boolean enModoDefensa() {return modo.enDefensa();}
}