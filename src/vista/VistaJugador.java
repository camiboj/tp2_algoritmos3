package vista;

import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import jugador.Jugador;
import tablero.LadoDelCampo;

public class VistaJugador extends GridPane { //Revisar
    Jugador jugador;
    LadoDelCampo ladoDelCampo;
    Text nombre;

    public VistaJugador(Jugador jugador, LadoDelCampo ladoDelCampo, String nombre) {
        this.nombre = new Text(nombre);
        this.ladoDelCampo = ladoDelCampo;
        this.jugador = jugador;
    }

    public void reset(){
        this.getChildren().clear();
    }


}
