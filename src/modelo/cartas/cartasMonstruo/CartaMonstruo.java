package modelo.cartas.cartasMonstruo;

import modelo.Fase.Fase;
import modelo.Fase.FasePreparacion;
import modelo.cartas.Carta;
import modelo.estadosDeCartas.Modo;
import modelo.estadosDeCartas.ModoDeAtaque;
import modelo.estadosDeCartas.ModoDeDefensa;
import modelo.jugador.Punto;

import java.util.List;

public abstract class CartaMonstruo extends Carta {

    protected Modo modo;
    protected Punto puntosAtaque;
    protected Punto puntosDefensa;
    protected Nivel nivel;

    public CartaMonstruo(String unNombredeCarta, int unosPuntosAtaque, int unosPuntosDefensa, int cantidadEstrellas) {
        super(unNombredeCarta);
        descripcionEfecto = "no tiene";
        puntosAtaque = new Punto(unosPuntosAtaque);
        puntosDefensa = new Punto(unosPuntosDefensa);
        nivel = new Nivel(cantidadEstrellas);
        modo = null;
    }

    public void activarEfecto(){}

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

    public boolean puedeInvocarse(List<CartaMonstruo> cartasASacrificar, FasePreparacion fase) {
        return nivel.validarSacrificios(cartasASacrificar) & fase.validarMonstruo();
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
        //Punto punto = modo.obtenerPuntos();
        //puntosAtaque = punto.sumar(puntosAtaqueAdicionales);

        Punto resultado = puntosAtaque.sumar(puntosAtaqueAdicionales);
        if(modo != null)
            modo.actualizarPuntos(resultado);
        puntosAtaque = resultado;
    }

    public void aumentarDefensa(Punto puntosDefensaAdicionales) {
        if(modo != null)
            modo.actualizarPuntos(puntosDefensaAdicionales);
        puntosDefensa = puntosDefensa.sumar(puntosDefensaAdicionales);
    }

    public CartaMonstruo obtenerAtaqueMinimo(CartaMonstruo cartaDebil) {
        Punto puntosDebil = cartaDebil.obtenerPuntosAtaque();
        if (puntosDebil.esMenor(this.puntosAtaque)) { return cartaDebil; }
        return this;
    }

    public int obtenerSacrificios() {
        return nivel.devolverNumeroDeSacrificios();
    }
}