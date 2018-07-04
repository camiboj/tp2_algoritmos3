package vista;

import javafx.scene.Node;
import modelo.Fase.FasePreparacion;
import modelo.cartas.Carta;
import modelo.cartas.cartasMonstruo.CartaMonstruo;
import modelo.jugador.Mano;
import vista.botones.BotonCartaMano;

import java.util.ArrayList;
import java.util.List;

public class VistaMano {
    private final Mano mano;
    private final ContenedorBase contenedorBase;
    private final VistaJugador vistaJugador;
    private List<Node> elementos;

    public VistaMano(Mano mano, ContenedorBase contenedorBase, VistaJugador vistaJugador) {
        this.mano = mano;
        this.contenedorBase = contenedorBase;
        this.elementos = new ArrayList<>();
        this.vistaJugador = vistaJugador;
    }

    public void activarCartas() {
        for (Node node : elementos) {
            BotonCartaMano botonCartaMano = (BotonCartaMano) node;
            botonCartaMano.setDisable(false);
        }
    }

    public void desactivarCartas() {
        for (Node node : elementos) {
            BotonCartaMano botonCartaMano = (BotonCartaMano) node;
            botonCartaMano.setDisable(true);
        }
    }

    public void mostrar(FasePreparacion fasePreparacion) {
        List<Carta> cartas = mano.mostrarCartas();
        int i = 0;
        int j = 0;
        for(Carta carta : cartas) {
            BotonCartaMano imagenCarta = new BotonCartaMano((CartaMonstruo) carta, vistaJugador, fasePreparacion);
            imagenCarta.setDisable(true);
            elementos.add(imagenCarta);
            contenedorBase.ubicarObjeto(imagenCarta, i, j);
            i++;
            if (i == 4) {
                j = 1;
                i = 0;
            }
        }
    }

    public void reset() {
        for (Node elemento : elementos) {
            contenedorBase.getChildren().remove(elemento);
        }
    }
}
