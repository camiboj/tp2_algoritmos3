package cartas.cartasTrampa;

import efectos.EfectoTrampaCilindroMagico;

public class CilindroMagico extends CartaTrampa {
    public CilindroMagico() {
        super("Cilindro Magico", new EfectoTrampaCilindroMagico());
    }
}
