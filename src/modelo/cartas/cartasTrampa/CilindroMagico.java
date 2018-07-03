package modelo.cartas.cartasTrampa;

import modelo.efectos.EfectoTrampaCilindroMagico;

public class CilindroMagico extends CartaTrampa {
    public CilindroMagico() {
        super("Cilindro Magico", new EfectoTrampaCilindroMagico());
        this.descripcionEfecto = "Cuando un monstruo de tu adeversario declara un ataque: selecciona al montruo " +
                "atacante; niega el ataque y, si lo haces, inflige daño a tu adversario igual a su ATK";
    }

    @Override
    public void activarEfecto() { }
}
