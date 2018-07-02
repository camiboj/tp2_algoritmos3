package modelo.cartas.cartasTrampa;

import modelo.efectos.EfectoTrampaCilindroMagico;

public class CilindroMagico extends CartaTrampa {
    public CilindroMagico() {
        super("Cilindro Magico", new EfectoTrampaCilindroMagico());
    }

    @Override
    public void activarEfecto() { }
}
