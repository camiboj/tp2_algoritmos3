package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import modelo.Fase.FasePreparacion;
import modelo.cartas.Carta;
import modelo.cartas.cartasMonstruo.CartaMonstruo;
import modelo.cartas.invocacion.InvocacionCartaMonstruoGenerica;
import modelo.excepciones.InvocacionExcepcion;
import modelo.excepciones.ZonaMonstruoLlenaException;
import modelo.jugador.Jugador;
import modelo.jugador.Mano;
import modelo.tablero.Tablero;
import vista.botones.BotonCartaMano;

import java.util.ArrayList;
import java.util.List;

public class VistaJugador extends VBox {
    private final Tablero tablero;
    private final VistaZonaMonstruo vistaZonaMonstruo;
    private final VistaMano vistaMano;
    private Jugador jugador;
    private ContenedorBase contenedorBase;
    private List<Node> elementos;

    public VistaJugador(ContenedorBase contenedorBase, Jugador jugador,
                        Tablero tablero) {
        this.tablero = tablero;
        this.jugador = jugador;
        this.contenedorBase = contenedorBase;
        this.elementos = new ArrayList<>();
        this.vistaZonaMonstruo = new VistaZonaMonstruo(tablero.mostrarZonaMonstruo(jugador), contenedorBase);
        this.vistaMano = new VistaMano(jugador.mostrarMano(), contenedorBase, this);
    }


    public void activar(boolean abajo, FasePreparacion fasePreparacion){
        int x = 0; int y = 8; int fila = 1;
        if (abajo) {
            x = 3; y = 2; fila = 2;
            vistaMano.mostrar(fasePreparacion);
        }
        this.agregarTexto(x, y);
        vistaZonaMonstruo.activar(fila);
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
        vistaMano.reset();
    }

   public void ColocarCartaMonstruoEnAtaque(CartaMonstruo carta, BotonCartaMano boton, FasePreparacion fase) {
        InvocacionCartaMonstruoGenerica invocacionCartaMonstruoGenerica = new InvocacionCartaMonstruoGenerica(carta, fase);
       int indice = 0;
       try {
           indice = tablero.colocarZonaMonstruo(invocacionCartaMonstruoGenerica, jugador );
           carta.colocarEnModoDeAtaque();
           int columna = indice + 3;
           vistaZonaMonstruo.colocarCartaModoAtaque(carta, columna);
           contenedorBase.getChildren().remove(boton);
       } catch (ZonaMonstruoLlenaException excepcion) {
           contenedorBase.escribirEnConsola(excepcion.obtenerMotivo());
       } catch (InvocacionExcepcion invocacionExcepcion) {
           contenedorBase.escribirEnConsola(invocacionExcepcion.obtenerMotivo());
       }
   }

    public void ColocarCartaMonstruoEnDefensa(CartaMonstruo carta, BotonCartaMano boton, FasePreparacion fase) {
        InvocacionCartaMonstruoGenerica invocacionCartaMonstruoGenerica = new InvocacionCartaMonstruoGenerica(carta, fase);
        try {
            int indice = tablero.colocarZonaMonstruo(invocacionCartaMonstruoGenerica,jugador);
            carta.colocarEnModoDeDefensa();
            int columna = indice + 3;
            vistaZonaMonstruo.colocarCartaModoDefensa(carta, columna);
            contenedorBase.getChildren().remove(boton);
        } catch (ZonaMonstruoLlenaException excepcion) {
            contenedorBase.escribirEnConsola(excepcion.obtenerMotivo());
        } catch (InvocacionExcepcion invocacionExcepcion) {
            contenedorBase.escribirEnConsola(invocacionExcepcion.obtenerMotivo());
        }
    }

    public VistaMano getVistaMano() {
        return vistaMano;
    }

    public void setOpcionAtacar(ContextMenu contextMenu) {
        vistaZonaMonstruo.setOpcionAtacar(contextMenu);
    }
}
