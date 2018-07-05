package vista.vistaZonas;

import javafx.scene.Node;
import modelo.Fase.FasePreparacion;
import modelo.cartas.Carta;
import modelo.cartas.cartasCampo.CartaCampo;
import modelo.cartas.cartasMagicas.CartaMagica;
import modelo.cartas.cartasMonstruo.CartaMonstruo;
import modelo.cartas.cartasTrampa.CartaTrampa;
import modelo.jugador.Mano;
import vista.ContenedorBase;
import vista.VistaJugador;
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
            BotonCartaMano imagenCarta = null;
            if (carta instanceof  CartaMonstruo) {
                imagenCarta = new BotonCartaMano((CartaMonstruo) carta, vistaJugador, fasePreparacion);
            }
            if (carta instanceof  CartaTrampa) {
                imagenCarta = new BotonCartaMano((CartaTrampa) carta);
            }
            if (carta instanceof CartaMagica) {
                imagenCarta = new BotonCartaMano((CartaMagica) carta);
            }
            if (carta instanceof  CartaCampo) {
                imagenCarta = new BotonCartaMano((CartaCampo)carta);
            }

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

    public void esconder() {
        for (Node elemento : elementos) {
            contenedorBase.getChildren().remove(elemento);
        }
    }
}
