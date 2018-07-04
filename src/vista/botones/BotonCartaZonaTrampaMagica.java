package vista.botones;

import modelo.cartas.Carta;

public class BotonCartaZonaTrampaMagica extends BotonCarta {

    public BotonCartaZonaTrampaMagica(Carta carta, int fila, int columna){
        super(carta, fila, columna);
        this.settearTooltip("Efecto: " + carta.obtenerEfecto());
    }
}
