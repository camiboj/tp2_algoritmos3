package vista;

import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import jugador.Jugador;
import tablero.LadoDelCampo;

public class VistaJugador extends GridPane {
    private final ContenedorBase contenedorBase; //Revisar
    private Jugador jugador;
    //LadoDelCampo ladoDelCampo;
    private Text nombre;

    public VistaJugador(Jugador jugador, String nombre, ContenedorBase contenedorBase) {
        this.nombre = new Text(nombre);
        //this.ladoDelCampo = ladoDelCampo;
        this.jugador = jugador;
        this.contenedorBase = contenedorBase;
        //this.getChildren().addAll(contenedorBase);
    }

    public void reset(){
        this.getChildren().clear();
    }


}
