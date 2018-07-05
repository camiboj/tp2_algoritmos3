package vista.vistaZonas;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import modelo.cartas.Carta;
import modelo.cartas.cartasMonstruo.CartaMonstruo;
import modelo.excepciones.InvocacionExcepcion;
import modelo.excepciones.ZonaMonstruoLlenaException;
import modelo.tablero.Casillero;
import modelo.tablero.ZonaMonstruo;
import vista.CheckBoxCarta;
import vista.ContenedorBase;
import vista.ContextMenuAtacante;
import vista.botones.BotonCarta;
import vista.botones.BotonCartaBocaAbajo;
import vista.botones.BotonCartaZonaMonstruo;
import vista.handler.VoltearHandler;

import java.util.ArrayList;
import java.util.List;

public class VistaZonaMonstruo extends VistaZonas {
    protected ZonaMonstruo zonaMonstruo;

    public VistaZonaMonstruo(ZonaMonstruo zonaMonstruo, ContenedorBase contenedorBase) {
        super(contenedorBase);
        this.zonaMonstruo = zonaMonstruo;
        this.contenedorBase = contenedorBase;
    }

    public void colocarCartaModoDefensa(CartaMonstruo carta, int columna) {
        BotonCartaZonaMonstruo botonCartaBocaArriba = new BotonCartaZonaMonstruo(carta, fila, columna);
        botonCartaBocaArriba.setRotate(90);
        BotonCartaBocaAbajo botonCartaBocaAbajo = new BotonCartaBocaAbajo(fila, columna);
        VoltearHandler handle = new VoltearHandler(botonCartaBocaArriba, botonCartaBocaAbajo, this);
        botonCartaBocaAbajo.setOnAction(handle);
        botonCartaBocaAbajo.setRotate(90);
        this.elementos.add(botonCartaBocaAbajo);
        contenedorBase.ubicarObjeto(botonCartaBocaAbajo, fila, columna);
    }

    public void colocarCartaModoAtaque(CartaMonstruo carta, int columna) {
        BotonCartaZonaMonstruo botonCartaBocaArriba = new BotonCartaZonaMonstruo(carta, fila, columna);
        BotonCartaBocaAbajo botonCartaBocaAbajo = new BotonCartaBocaAbajo(fila, columna);
        VoltearHandler handle = new VoltearHandler(botonCartaBocaArriba, botonCartaBocaAbajo, this);
        botonCartaBocaAbajo.setOnAction(handle);
        this.elementos.add(botonCartaBocaAbajo);
        contenedorBase.ubicarObjeto(botonCartaBocaAbajo, fila, columna);
    }

    public void setOpcionAtacar(ContextMenuAtacante contextMenu) {
        for (BotonCarta botonCarta : this.elementos) {
            if (botonCarta instanceof BotonCartaZonaMonstruo) {
                BotonCartaZonaMonstruo boton = (BotonCartaZonaMonstruo) botonCarta;
                if (boton.obtenerCarta().enModoDefensa()) {
                    boton.setDisable(true);
                } else {
                    contextMenu.agregarCarta((BotonCartaZonaMonstruo) botonCarta);
                    boton.setContextMenu(contextMenu);
                }
            } else {
                BotonCartaBocaAbajo boton = (BotonCartaBocaAbajo) botonCarta;
                boton.setDisable(true);
            }
        }
    }

    public BotonCarta obtenerBoton(CartaMonstruo carta) {

        for (BotonCarta boton : this.elementos) {
            if (boton.obtenerCarta() == carta) {
                return boton;
            }
        }
        return null;
    }

    public List <CartaMonstruo> generarSacrificios(int cantidad) throws InvocacionExcepcion {
        List <CartaMonstruo> sacrificios = new ArrayList <>();
        if (zonaMonstruo.obtenerMonstruos().size() < cantidad) {
            throw new InvocacionExcepcion("No contás con las cartas necesarias para realizar el sacrificio correspondiente");
        }
        for (int i = 0; i < cantidad; i++) {
            CartaMonstruo carta = zonaMonstruo.obtenerMonstruoDebil();
            zonaMonstruo.eliminarCarta(carta);
            this.elementos.remove(this.obtenerBoton(carta));
            sacrificios.add(carta);
        }
        for (CartaMonstruo carta : sacrificios) {
            try {
                zonaMonstruo.colocarCarta(carta);
            } catch (ZonaMonstruoLlenaException ignored) {
            }
        }
        this.actualizar();
        return sacrificios;
    }

    public List <CheckBoxCarta> generarOpcionesAtaque() {
        List <CheckBoxCarta> resultado = new ArrayList <>();
        List <Casillero> casilleros = zonaMonstruo.obtenerCasilleros();
        for (Casillero casillero : casilleros) {
            if (casillero.estaVacio()) {
                continue;
            }
            CheckBoxCarta check = new CheckBoxCarta(this.obtenerBoton((CartaMonstruo) casillero.mostrarCarta()));
            resultado.add(check);
        }
        return resultado;
    }

    public void eliminar(List <CartaMonstruo> sacrificios) {
        for (CartaMonstruo carta : sacrificios) {
            BotonCarta boton = this.obtenerBoton(carta);
            contenedorBase.getChildren().remove(boton);
        }
    }


    public void eliminarBoton(BotonCarta botonCarta) {
        this.elementos.remove(botonCarta);
    }


    public void actualizar() {
        for (BotonCarta boton : elementos) {
            boton.setDisable(false);
            boton.cambiarFila(fila);
            contenedorBase.getChildren().remove(boton);
            contenedorBase.ubicarObjeto(boton, fila, boton.obtenerColumna());
        }
    }

    public void actualizarMonstruos(List <CartaMonstruo> monstruos) {
        List<BotonCarta> botones = this.elementos;

        if (elementos.size() == 0) { return; }
        for (BotonCarta botonCarta : botones) {
            CartaMonstruo carta = (CartaMonstruo) botonCarta.obtenerCarta();
            if (monstruos.contains(carta)) {
                continue;
            }
            contenedorBase.getChildren().remove(botonCarta);
            eliminarBoton(botonCarta);
        }
    }

}
