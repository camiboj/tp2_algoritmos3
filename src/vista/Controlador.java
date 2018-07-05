package vista;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import modelo.Fase.FasePreparacion;
import modelo.cartas.cartasMonstruo.CartaMonstruo;
import modelo.excepciones.CartaAtacanteInexistenteException;
import modelo.excepciones.CartaDefensoraInexistenteException;
import modelo.excepciones.NoHayTrampasExcepcion;
import modelo.jugador.Jugador;
import modelo.jugador.YuGiOh;
import modelo.tablero.Tablero;
import vista.botones.*;
import vista.handler.BotonAtacarHandler;
import vista.handler.BotonFinFaseAtaqueHandler;
import vista.handler.MazoHandler;
import vista.handler.OpcionesAtacarHandler;
import vista.vistaZonas.VistaMano;

import java.util.ArrayList;
import java.util.List;

public class Controlador {
    private Stage stage;
    private Botonera botonera;
    private Jugador jugadorContrincante;
    private Jugador jugadorTurno;
    private ArrayList<Jugador> jugadores;
    private YuGiOh juego;
    private ContenedorBase contenedorBase;
    private VistaJugador vistaActual;
    private VistaJugador vistaContrincante;
    private FasePreparacion fasePreparacion;
    private ArrayList<CheckBoxCarta> checks;
    private List<BotonCarta> cartasTrampaMagicaActivadas;

    public Controlador(Stage stage, YuGiOh juego, Tablero tablero) {
        ContenedorBase contenedorBase = new ContenedorBase(stage, juego, tablero);
        this.cartasTrampaMagicaActivadas = new ArrayList <>();
        this.jugadorTurno = juego.obtenerJugador1();
        this.jugadorContrincante = juego.obtenerJugador2();
        this.vistaActual = new VistaJugador(contenedorBase, jugadorTurno,
                tablero);
        this.vistaContrincante = new VistaJugador(contenedorBase, jugadorContrincante,
                tablero);
        this.contenedorBase = contenedorBase;
        this.botonera = new Botonera(this);
        this.jugadores = juego.obtenerJugadores();
        this.juego = juego;
        this.stage = stage;
        contenedorBase.escribirEnConsola("Es el turno de " + jugadorTurno.obtenerNombre() + "\n Inicio Fase Inicial: Haz click en el Mazo para obtener una carta");
        this.botonera();

        this.fasePreparacion = new FasePreparacion();
        vistaActual.activar(true, fasePreparacion);
        vistaContrincante.activar(false, fasePreparacion);
        this.setMazo();
    }

    public void setMazo() {
        BotonCartaBocaAbajo boton = new BotonCartaBocaAbajo(3, 8);
        contenedorBase.ubicarObjeto(boton, 3, 8);
        boton.setOnAction(new MazoHandler(juego, this.vistaActual.getVistaMano(), jugadorTurno, boton,
                botonera.obtenerBotonPreparacion(), fasePreparacion, contenedorBase));
    }

    public void botonera() {
        contenedorBase.setBotonera(botonera);
    }

    public void cambiarTurno() {
        botonera.desactivarCambiarTurno();
        vistaActual.resetNombre();
        vistaContrincante.resetNombre();
        this.fasePreparacion = new FasePreparacion();

        Jugador jugadorAux = jugadorTurno;
        jugadorTurno = jugadorContrincante;
        jugadorContrincante = jugadorAux;

        VistaJugador vistaAux = vistaActual;
        vistaActual = vistaContrincante;
        vistaContrincante = vistaAux;

        contenedorBase.escribirEnConsola("Es el turno de " + jugadorTurno.obtenerNombre() + "\n" +
                "Inicio Fase Inicial: Haz click en el Mazo para obtener una carta"
        );
        this.setMazo();
        vistaActual.activar(true, fasePreparacion);
        vistaContrincante.activar(false, fasePreparacion);
    }

    public void mostrar(Stage stage) {
        Scene escenaJuego = new Scene(contenedorBase, 640, 480);
        stage.setScene(escenaJuego);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
    }

    public ContenedorBase obtenerContenedorBase() {
        return contenedorBase;
    }

    public VistaMano obtenerVistaMano() {
        return vistaActual.getVistaMano();
    }

    public VistaJugador obtenerVistaJugador() {
        return vistaActual;
    }

    public void setOpcionAtacar() {

        ContextMenuAtacante contextMenu = new ContextMenuAtacante();
        MenuItem opcionAtacar = new MenuItem("Atacar");

        opcionAtacar.setOnAction(new OpcionesAtacarHandler(this, contextMenu));

        contextMenu.getItems().addAll(opcionAtacar);
        vistaActual.setOpcionAtacar(contextMenu);
    }

    public void generarOpcionesAtaque(ContextMenuAtacante contextMenuAtacante) {
        List<CheckBoxCarta> opciones = vistaContrincante.generarOpcionesAtaque();
        this.checks = new ArrayList<>();
        int columna = 3;
        for (CheckBoxCarta carta : opciones) {
            if (carta != null) {
                this.checks.add(carta);
            }
            contenedorBase.ubicarObjeto(carta, 1, columna);
            columna++;
        }
        botonera.activarBotonAtacar(new BotonAtacarHandler(checks, contenedorBase, this, contextMenuAtacante));
    }

    public void atacarMonstruos(BotonCartaZonaMonstruo botonMonstruoAtacante, BotonCarta botonCartaAtacada) throws CartaAtacanteInexistenteException, CartaDefensoraInexistenteException {

        Tablero tablero = juego.mostrarTablero();
        CartaMonstruo cartaAtacante = (CartaMonstruo) botonMonstruoAtacante.obtenerCarta();
        CartaMonstruo cartaDefensora = (CartaMonstruo) botonCartaAtacada.obtenerCarta();


        List<CartaMonstruo> cartasMuertas = tablero.atacarDosMonstruos(cartaAtacante, jugadorTurno,
                cartaDefensora, jugadorContrincante);

        for (CartaMonstruo cartaMuerta : cartasMuertas) {
            if (vistaActual.obtenerBoton(cartaMuerta) != null) {
                BotonCarta botonCarta = vistaActual.obtenerBoton(cartaMuerta);
                vistaActual.eliminarElemento(botonCarta);
                contenedorBase.getChildren().remove(botonCarta);
                continue;
            }

            BotonCarta botonCarta = vistaContrincante.obtenerBoton(cartaMuerta);
            vistaContrincante.eliminarElemento(botonCarta);
            contenedorBase.getChildren().remove(botonCarta);
        }
    }

    public void iniciarFaseTrampa() {
        botonera.activarFinDeTrampas(new BotonFinFaseAtaqueHandler(contenedorBase, this));
        contenedorBase.escribirEnConsola("Has podido atacar correctamente. Se activó la fase trampa " +
                "automáticamente como resultado de la misma. \n" +
                " Para pasar a la fase final haz click en 'Fin Fase de Ataque' y para volver a atacar haz click " +
                "en 'Atacar'");
        try {
            vistaContrincante.voltearPrimeraTrampa(this);
        } catch (NoHayTrampasExcepcion noHayTrampasExcepcion) {
            contenedorBase.escribirEnConsola("Has podido atacar correctamente y no se activaron trampas. " +
                    "Para pasar a la fase final haz click en 'Fin Fase de Ataque' y para volver a atacar haz click " +
                    "en 'Atacar'");
        }

    }

    public void activarFaseFinal() {
        vistaActual.activarCartasMagicas(this);
    }

    public void eliminarMagicasActivadas() {
        for (BotonCarta botonCarta : cartasTrampaMagicaActivadas) {
            contenedorBase.getChildren().remove(botonCarta);
            vistaActual.eliminarElemento(botonCarta);
        }
    }

    public void agregarCartaTrampaMagicaABorrar(BotonCarta botonCarta) {
        cartasTrampaMagicaActivadas.add(botonCarta);
    }


    public void activarFinTurno() {
        botonera.activarFinDeTurno();
    }

    public void actualizarZonaMonstruo() {
        Tablero tablero = juego.mostrarTablero();
        List<CartaMonstruo> monstruosPropios = tablero.mostrarZonaMonstruo(jugadorTurno).obtenerMonstruos();
        List<CartaMonstruo> monstruosAjenos = tablero.mostrarZonaMonstruo(jugadorContrincante).obtenerMonstruos();

        vistaActual.actualizarMonstruos(monstruosPropios);
        vistaContrincante.actualizarMonstruos(monstruosAjenos);
    }

    public void actualizarMano() {
        vistaActual.actualizarMano();
    }
}
