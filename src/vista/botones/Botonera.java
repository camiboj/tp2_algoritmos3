package vista.botones;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import vista.Controlador;
import vista.handler.CambiarTurnoHandler;
import vista.handler.FinFasePreparacionHandler;

public class Botonera extends VBox {
    private Controlador controlador;
    private BotonBotonera botonFinFaseAtaque;
    private BotonBotonera botonFinFaseDePreparacion;
    private BotonBotonera botonFinFaseTrampas;
    private BotonBotonera botonCambioTurno;

    public Botonera(Controlador controlador) {
        this.botonFinFaseDePreparacion = new BotonBotonera("Fin Fase De Preparacion");
        this.botonFinFaseAtaque = new BotonBotonera("Fin Fase de Ataque");
        this.botonFinFaseTrampas = new BotonBotonera("Fin Fase de Trampas");
        this.botonCambioTurno = new BotonBotonera("Fin De Turno");
        this.controlador = controlador;
        this.setEspacio();
    }

    private void setEspacio() {
        this.setAlignment(Pos.TOP_CENTER);
        this.setSpacing(40);
        this.fijarBotones();
    }

    private void fijarBotones() {

        botonFinFaseDePreparacion.setDisable(true);
        botonFinFaseAtaque.setDisable(true);
        botonFinFaseTrampas.setDisable(true);
        botonCambioTurno.setDisable(true);

        botonCambioTurno.setOnAction(new CambiarTurnoHandler(controlador));
        botonCambioTurno.setDisable(true);

        botonFinFaseDePreparacion.setOnAction(new FinFasePreparacionHandler(botonFinFaseDePreparacion,botonFinFaseAtaque,
                controlador.obtenerContenedorBase(), controlador.obtenerVistaMano(), controlador.obtenerVistaJugador()));
        this.getChildren().addAll(botonFinFaseDePreparacion, botonFinFaseAtaque, botonFinFaseTrampas,
                botonCambioTurno);
    }

    public BotonBotonera obtenerBotonPreparacion() {
        return botonFinFaseDePreparacion;
    }
}
