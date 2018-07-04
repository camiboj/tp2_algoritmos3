package modelo.cartas.invocacion;

import modelo.cartas.Carta;
import modelo.excepciones.InvocacionExcepcion;

public abstract class Invocacion {
    protected Carta carta;

    public Invocacion(Carta unaCarta) {
        carta = unaCarta;
    }
}
