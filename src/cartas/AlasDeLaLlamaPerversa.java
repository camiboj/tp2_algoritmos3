package cartas;

import efectos.AgujeroNegro;
import estadosDeCartas.Modo;
import estadosDeCartas.ModoDeAtaque;
import estadosDeCartas.ModoDeDefensa;
import tablero.Casillero;
import tablero.Cementerio;

public class AlasDeLaLlamaPerversa {
    private Modo modo;

    public Object getUbicacion() {
        return new Casillero();
    }
    private void cambiarEstado(Modo m) {
        this.modo= m;
    }
    public void atacar(HuevoMonstruoso huevoMonstruoso) {
    }

    public void invocar() {
    }

    public void modoDeAtaque() {
        cambiarEstado(new ModoDeAtaque());
    }

    public Object modo() {
        return modo;
    }

    public void modoDeDefensa() {
        cambiarEstado(new ModoDeDefensa());
    }
}
