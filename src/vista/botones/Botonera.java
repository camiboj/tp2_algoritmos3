package vista.botones;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import vista.Controlador;
import vista.handler.BotonAtacarHandler;
import vista.handler.BotonFinFaseAtaqueHandler;
import vista.handler.CambiarTurnoHandler;
import vista.handler.FinFasePreparacionHandler;

public class Botonera extends VBox {
    private BotonBotonera botonAtaque;
    private Controlador controlador;
    private BotonBotonera botonFinFaseAtaque;
    private BotonBotonera botonFinFaseDePreparacion;
    private BotonBotonera botonCambioTurno;

    public Botonera(Controlador controlador) {

        this.botonAtaque = new BotonBotonera("Atacar");
        this.botonFinFaseDePreparacion = new BotonBotonera("Fin Fase De Preparacion");
        this.botonFinFaseAtaque = new BotonBotonera("Fin Fase de Ataque");
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

        botonAtaque.setDisable(true);
        botonFinFaseAtaque.setDisable(true);
        botonCambioTurno.setDisable(true);
        botonCambioTurno.setDisable(true);
        botonFinFaseDePreparacion.setDisable(true);

        botonFinFaseDePreparacion.setOnAction(new FinFasePreparacionHandler(botonFinFaseDePreparacion,botonFinFaseAtaque,
                controlador.obtenerContenedorBase(), controlador.obtenerVistaMano(), controlador));
        botonFinFaseAtaque.setOnAction(new BotonFinFaseAtaqueHandler(controlador.obtenerContenedorBase(), controlador));
        botonCambioTurno.setOnAction(new CambiarTurnoHandler(controlador));

        this.getChildren().addAll(botonAtaque, botonFinFaseDePreparacion, botonFinFaseAtaque,
                botonCambioTurno);
    }

    public void desactivarCambiarTurno() {
        botonCambioTurno.setDisable(true);
    }

    public BotonBotonera obtenerBotonPreparacion() {
        return botonFinFaseDePreparacion;
    }

    public void activarBotonAtacar(BotonAtacarHandler botonAtacarHandler) {
        botonAtaque.setDisable(false);
        botonAtaque.setOnAction(botonAtacarHandler);
    }

    public void desactivarAtaque() {
        botonAtaque.setDisable(true);
    }

    public void activarFinDeTrampas(BotonFinFaseAtaqueHandler handler) {
        botonFinFaseAtaque.setDisable(false);
        botonFinFaseAtaque.setOnAction(handler);
    }

    public void activarFinDeTurno() {
        botonFinFaseAtaque.setDisable(true);
        botonAtaque.setDisable(true);
        botonCambioTurno.setDisable(false);
    }
}
