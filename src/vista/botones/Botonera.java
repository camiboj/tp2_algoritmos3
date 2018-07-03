package vista.botones;

import javafx.geometry.Insets;
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

        BotonBotonera botonFinFaseInicial = new BotonBotonera("Fin Fase Inicial");

        BotonBotonera botonFinFaseDePreparacion = new BotonBotonera("Fin Fase De Preparacion");

        BotonBotonera botonFinFaseAtaque = new BotonBotonera("Fin Fase de Ataque");

        BotonBotonera botonFinFaseTrampas = new BotonBotonera("Fin Fase de Trampas");

        BotonBotonera botonCambioTurno = new BotonBotonera("Fin De Turno");

        botonCambioTurno.setOnAction(new HandlerCambiarTurno(controlador));

        this.getChildren().addAll(botonFinFaseInicial,botonFinFaseDePreparacion, botonFinFaseAtaque, botonFinFaseTrampas,
                botonCambioTurno);
    }
}
