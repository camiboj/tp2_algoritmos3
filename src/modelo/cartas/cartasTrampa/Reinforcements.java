package modelo.cartas.cartasTrampa;
import modelo.efectos.EfectoTrampaReinforcements;

public class Reinforcements extends CartaTrampa {
    public Reinforcements() {
        super("Reinforcements", new EfectoTrampaReinforcements());
    }

    @Override
    public void activarEfecto() {}
}
