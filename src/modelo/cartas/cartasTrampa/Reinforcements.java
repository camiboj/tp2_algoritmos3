package modelo.cartas.cartasTrampa;
import modelo.efectos.EfectoTrampaReinforcements;

public class Reinforcements extends CartaTrampa {
    public Reinforcements() {
        super("Reinforcements", new EfectoTrampaReinforcements());
        this.descripcionEfecto = "Aumenta el ATK de un monstruo seleccionado en 500 puntos durante el turno en que " +
                "esta carta es activada.";
    }

    @Override
    public void activarEfecto() {}
}
