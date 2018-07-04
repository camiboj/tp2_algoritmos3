package vista;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import modelo.cartas.cartasMonstruo.CartaMonstruo;
import modelo.excepciones.InvocacionExcepcion;
import modelo.excepciones.VictoriaException;
import modelo.excepciones.ZonaMonstruoLlenaException;
import modelo.tablero.Casillero;
import modelo.tablero.ZonaMonstruo;
import vista.botones.BotonCarta;
import vista.botones.BotonCartaBocaAbajo;
import vista.botones.BotonCartaZonaMonstruo;
import vista.handler.VoltearHandler;

import java.util.ArrayList;
import java.util.List;

public class VistaZonaMonstruo {
    protected ZonaMonstruo zonaMonstruo;
    protected ContenedorBase contenedorBase;
    protected int fila;
    protected List<BotonCarta> elementos;

    public VistaZonaMonstruo (ZonaMonstruo zonaMonstruo, ContenedorBase contenedorBase) {
        this.zonaMonstruo = zonaMonstruo;
        this.contenedorBase = contenedorBase;
        this.elementos = new ArrayList<>();
    }

    public void activar(int fila) {
        this.fila = fila;
        actualizar();
    }

    private void actualizar() {
        for(Node node : elementos) {
            BotonCarta boton = (BotonCarta) node;
            boton.cambiarFila(fila);
            contenedorBase.getChildren().remove(boton);
            contenedorBase.ubicarObjeto(boton, fila, boton.obtenerColumna());
        }
    }

    public void colocarCartaModoDefensa(CartaMonstruo carta, int columna) {
        BotonCartaZonaMonstruo botonCartaBocaArriba = new BotonCartaZonaMonstruo(carta, fila, columna);
        botonCartaBocaArriba.setRotate(90);
        BotonCartaBocaAbajo botonCartaBocaAbajo = new BotonCartaBocaAbajo(fila, columna);
        VoltearHandler handle = new VoltearHandler(botonCartaBocaArriba, botonCartaBocaAbajo, this);
        botonCartaBocaAbajo.setOnAction(handle);
        botonCartaBocaAbajo.setRotate(90);
        elementos.add(botonCartaBocaAbajo);
        contenedorBase.ubicarObjeto(botonCartaBocaAbajo, fila, columna);
    }

    public void colocarCartaModoAtaque(CartaMonstruo carta, int columna) {
        BotonCartaZonaMonstruo botonCartaBocaArriba = new BotonCartaZonaMonstruo(carta, fila, columna);
        BotonCartaBocaAbajo botonCartaBocaAbajo = new BotonCartaBocaAbajo(fila, columna);
        VoltearHandler handle = new VoltearHandler(botonCartaBocaArriba, botonCartaBocaAbajo, this);
        botonCartaBocaAbajo.setOnAction(handle);
        elementos.add(botonCartaBocaAbajo);
        contenedorBase.ubicarObjeto(botonCartaBocaAbajo, fila, columna);
    }

    public void voltear(BotonCartaBocaAbajo botonCartaBocaAbajo, BotonCarta botonCartaBocaArriba, int fila, int columna) {
        elementos.add(botonCartaBocaArriba);
        elementos.remove(botonCartaBocaAbajo);
        contenedorBase.getChildren().remove(botonCartaBocaAbajo);
        contenedorBase.ubicarObjeto(botonCartaBocaArriba, fila, columna);
        try {
            botonCartaBocaArriba.actualizarEstado();
        } catch (VictoriaException e) {
        }
    }

    public void setOpcionAtacar(ContextMenu contextMenu) {
        for (BotonCarta botonCarta : elementos) {
            if (botonCarta instanceof BotonCartaZonaMonstruo) {
                BotonCartaZonaMonstruo boton = (BotonCartaZonaMonstruo) botonCarta;
                boton.setContextMenu(contextMenu);
            }
            else {
                BotonCartaBocaAbajo boton = (BotonCartaBocaAbajo) botonCarta;
                boton.setDisable(true);
            }
        }
    }

    public BotonCarta obtenerBoton(CartaMonstruo carta) {

        for (BotonCarta boton : elementos) {
            if (boton.obtenerCarta() == carta) {
                return boton;
            }
        }
        return null;
    }

    public List<CartaMonstruo> generarSacrificios(int cantidad) throws InvocacionExcepcion {
        List<CartaMonstruo> sacrificios = new ArrayList<>();
        if (zonaMonstruo.obtenerMonstruos().size() < cantidad) {
            throw new InvocacionExcepcion("No contás con las cartas necesarias para realizar el sacrificio correspondiente");
        }
        for (int i = 0; i < cantidad; i++) {
            CartaMonstruo carta = zonaMonstruo.obtenerMonstruoDebil();
            zonaMonstruo.eliminarCarta(carta);
            this.elementos.remove(this.obtenerBoton(carta));
            sacrificios.add(carta);
        }
        for (CartaMonstruo carta: sacrificios)  {
            try {
                zonaMonstruo.colocarCarta(carta);
            } catch (ZonaMonstruoLlenaException ignored) {
            }
        }
        this.actualizar();
        return sacrificios;
    }

    public void sacrificar(List<CartaMonstruo> sacrificios) {
        for (CartaMonstruo carta: sacrificios) {
            zonaMonstruo.eliminarCarta(carta);
            elementos.remove(this.obtenerBoton(carta));
            this.actualizar();
        }
    }

    public List<CheckBoxCarta> generarOpcionesAtaque() {
        List<CheckBoxCarta> resultado = new ArrayList<>();
        List<Casillero> casilleros = zonaMonstruo.obtenerCasilleros();
        for (Casillero casillero : casilleros) {
            if (casillero.estaVacio()){continue;}
            CheckBoxCarta check = new CheckBoxCarta(this.obtenerBoton((CartaMonstruo) casillero.mostrarCarta()));
            resultado.add(check);
        }
        return resultado;
    }
}

/*
* zonaMonstruo.eliminarCarta(carta);
            elementos.remove(this.obtenerBoton(carta));
            this.actualizar();
*
* */
