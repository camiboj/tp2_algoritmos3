package vista.vistaZonas;

import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import modelo.cartas.Carta;
import modelo.cartas.cartasMagicas.CartaMagica;
import modelo.cartas.cartasTrampa.CartaTrampa;
import modelo.excepciones.NoHayTrampasExcepcion;
import modelo.tablero.ZonaTrampaMagica;
import vista.ContenedorBase;
import vista.Controlador;
import vista.VistaJugador;
import vista.botones.BotonCarta;
import vista.botones.BotonCartaBocaAbajo;
import vista.botones.BotonCartaZonaTrampaMagica;
import vista.handler.ActivarMagicaBocaAbajoHandler;
import vista.handler.ActivarMagicaBocaArribaHandler;
import vista.handler.VoltearHandler;



public class VistaTrampaMagica extends VistaZonas {
    protected ZonaTrampaMagica zonaTrampaMagica;

    public VistaTrampaMagica(ZonaTrampaMagica zonaTrampaMagica, ContenedorBase contenedorBase) {
        super(contenedorBase);
        this.zonaTrampaMagica = zonaTrampaMagica;
    }

    public void colocarCarta(Carta carta, int columna) {

        BotonCartaZonaTrampaMagica botonCartaBocaArriba = new BotonCartaZonaTrampaMagica(carta, fila, columna);
        BotonCartaBocaAbajo botonCartaBocaAbajo = new BotonCartaBocaAbajo(fila, columna, botonCartaBocaArriba);
        VoltearHandler handle = new VoltearHandler(botonCartaBocaArriba, botonCartaBocaAbajo, this);
        botonCartaBocaAbajo.setOnAction(handle);
        botonCartaBocaAbajo.setRotate(90);
        elementos.add(botonCartaBocaAbajo);
        contenedorBase.ubicarObjeto(botonCartaBocaAbajo, fila, columna);
    }

    public void voltearPrimeraTrampa() throws NoHayTrampasExcepcion {
        for (BotonCarta botonCarta: elementos) {
            if(botonCarta instanceof BotonCartaBocaAbajo && botonCarta.obtenerCarta() instanceof CartaTrampa) {
                BotonCartaBocaAbajo botonCartaBocaAbajo = (BotonCartaBocaAbajo) botonCarta;
                elementos.remove(botonCartaBocaAbajo);
                contenedorBase.getChildren().remove(botonCartaBocaAbajo);
                BotonCartaZonaTrampaMagica botonCartaBocaArriba = botonCartaBocaAbajo.obtenerBotonBocaArriba();
                elementos.add(botonCartaBocaArriba);
                contenedorBase.ubicarObjeto(botonCartaBocaArriba, botonCartaBocaAbajo.obtenerFila(), botonCartaBocaAbajo.obtenerColumna());
                return;
            }
        }
        throw new NoHayTrampasExcepcion("No hay trampas");
    }

    public void activarCartasMagicas(VistaJugador vistaActual, Controlador controlador) {
        if(! zonaTrampaMagica.hayMagicas()) {
            contenedorBase.escribirEnConsola("No tenes cartas mágicas para activar. Haz click en 'Fin " +
                    "de turno' para que juegue tu oponente");
            controlador.activarFinTurno();
            return;
        }

        for (BotonCarta botonCarta: elementos) {
            if(botonCarta instanceof BotonCartaBocaAbajo && botonCarta.obtenerCarta() instanceof CartaMagica) {

                CartaMagica cartaMagica = (CartaMagica) botonCarta.obtenerCarta();
                ContextMenu contextMenu = new ContextMenu();
                MenuItem opcionActivar = new MenuItem("Activar carta");

                opcionActivar.setOnAction(new ActivarMagicaBocaAbajoHandler(controlador,vistaActual, (BotonCartaBocaAbajo) botonCarta,
                        new BotonCartaZonaTrampaMagica(cartaMagica, botonCarta.obtenerFila(), botonCarta.obtenerColumna()),
                        contenedorBase));//Voltear y luego activar efecto

                contextMenu.getItems().addAll(opcionActivar);
                botonCarta.setContextMenu(contextMenu);

            }
            else if (botonCarta.obtenerCarta() instanceof CartaMagica) {

                ContextMenu contextMenu = new ContextMenu();
                MenuItem opcionActivar = new MenuItem("Activar carta");

                opcionActivar.setOnAction(new ActivarMagicaBocaArribaHandler((BotonCartaZonaTrampaMagica) botonCarta, controlador)); //Activar efecto de la magica

                contextMenu.getItems().addAll(opcionActivar);
                botonCarta.setContextMenu(contextMenu);
            }
        }
    }
}
