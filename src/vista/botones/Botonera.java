package vista.botones;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import vista.Controlador;

public class Botonera extends VBox {
    private final Controlador controlador;

    public Botonera(Controlador controlador) {
        this.controlador = controlador;
        this.setAlignment(Pos.TOP_CENTER);
        this.setSpacing(40);
        this.fijarBotones();
    }

    private void fijarBotones() {

        BotonBotonera botonFinFaseDePreparacion = new BotonBotonera("Fin Fase De Preparacion");
        botonFinFaseDePreparacion.setDisable(true);

        BotonBotonera botonFinFaseAtaque = new BotonBotonera("Fin Fase de Ataque");
        botonFinFaseAtaque.setDisable(true);

        BotonBotonera botonFinFaseTrampas = new BotonBotonera("Fin Fase de Trampas");
        botonFinFaseTrampas.setDisable(true);

        BotonBotonera botonCambioTurno = new BotonBotonera("Fin De Turno");
        botonCambioTurno.setDisable(true);

        botonCambioTurno.setOnAction(new HandlerCambiarTurno(controlador));
        botonCambioTurno.setDisable(true);

        this.getChildren().addAll(botonFinFaseDePreparacion, botonFinFaseAtaque, botonFinFaseTrampas,
                botonCambioTurno);
    }
}
