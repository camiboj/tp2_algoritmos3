package cartas;

import estadosDeCartas.Modo;
import estadosDeCartas.ModoDeAtaque;
import estadosDeCartas.ModoDeDefensa;
import jugador.Punto;

import java.util.List;

public abstract class CartaMonstruo extends Carta {
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public CartaMonstruo(String unNombredeCarta, int unosPuntosAtaque, int unosPuntosDefensa, int cantidadEstrellas) {
        super(unNombredeCarta);
        puntosAtaque = new Punto(unosPuntosAtaque);
        puntosDefensa = new Punto(unosPuntosDefensa);
        nivel = new Nivel(cantidadEstrellas);
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

    public Punto obtenerPuntosAtaque() { return puntosAtaque;} //Para test de Wasteland

    public Punto obtenerPuntosDefensa() { return puntosDefensa;} //Para test de Wasteland

    public boolean puedeInvocarse(List<CartaMonstruo> cartasASacrificar) {
        return nivel.validarSacrificios(cartasASacrificar);
    }

    public boolean igualPuntos(CartaMonstruo unaCartaOponente) {
        return puntosAtaque.obtenerNumero() == (unaCartaOponente.obtenerPuntos().obtenerNumero());
    }

    public Modo obtenerModo() {
        return modo;
    }

    public CartaMonstruo obtenerGanadoraContra(CartaMonstruo cartaOponente) { //Devuelve la carta de mayor puntos de ataque
        Punto puntosOponente = cartaOponente.obtenerPuntos();
        if (puntosOponente.esMayor(this.puntosAtaque)) { return cartaOponente; }
        return this;
    }

    public boolean enModoAtaque() {return modo.enAtaque();}
    public boolean enModoDefensa() {return modo.enDefensa();}

    public void aumentarAtaque(Punto puntosAtaqueAdicionales) {
        puntosAtaque = puntosAtaque.sumar(puntosAtaqueAdicionales);
    }

    public void aumentarDefensa(Punto puntosDefensaAdicionales) {

        puntosDefensa = puntosDefensa.sumar(puntosDefensaAdicionales);
    }
}