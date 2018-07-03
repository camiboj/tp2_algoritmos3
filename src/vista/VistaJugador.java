package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import modelo.cartas.Carta;
import modelo.jugador.Jugador;
import modelo.jugador.Mano;
import modelo.tablero.LadoDelCampo;
import vista.botones.BotonCartaMano;

import java.util.ArrayList;
import java.util.List;

public class VistaJugador extends VBox {
    private Jugador jugador;
    private LadoDelCampo ladoDelCampo;
    private ContenedorBase contenedorBase;
    private List<Node> elementos;

    public VistaJugador(ContenedorBase contenedorBase, Jugador jugador,
                        LadoDelCampo ladoDelCampo) {
        this.ladoDelCampo = ladoDelCampo;
        this.jugador = jugador;
        this.contenedorBase = contenedorBase;
        this.elementos = new ArrayList<>();

    }

    public void activar(boolean abajo){
        int x = 0; int y = 8;
        if (abajo) {
            x = 3; y = 2;
            this.mostrarMano();
        }
        this.agregarTexto(x, y);
    }

    private void agregarTexto(int x, int y) {

        this.setAlignment(Pos.TOP_CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        Label datosJugador = new Label(jugador.obtenerNombre() + "\n Puntos: \n" + String.valueOf(jugador.obtenerPuntos().obtenerNumero()));
        datosJugador.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        datosJugador.setTextAlignment(TextAlignment.CENTER);
        datosJugador.setTextFill(Color.WHITE);

        elementos.add(datosJugador);

        contenedorBase.ubicarObjeto(datosJugador, x, y);
    }

    public void reset() {
        for (Node elemento : elementos) {
            contenedorBase.getChildren().remove(elemento);
        }
    }

    public void mostrarMano() {
        Mano mano = jugador.mostrarMano();
        List<Carta> cartas = mano.mostrarCartas();
        //System.out.println(cartas.size());
        int i = 0;
        int j = 0;
        for(Carta carta : cartas) {
            BotonCartaMano imagenCarta = new BotonCartaMano(carta.getNombre(), carta);
            contenedorBase.ubicarObjeto(imagenCarta, i, j);
            i++;
            if (i == 4) {
                j = 1;
                i = 0;
            }
        }
    }
}
