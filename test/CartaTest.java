import org.junit.Assert;
import org.junit.Test;

public class CartaTest {

    @Test
    public void crearCartaMounstruoYColocarlaEnPosicionDeAtaque() {
        Mounstruo cartaMounstruo = Carta.crearCarta('Huevo Monstruoso');
        cartaMounstruo.colocarEnPosicionDeAtaque();
        Assert.assertEquals(cartaMounstruo.estado() IsInstanceOf posicionDeAtaque);
        
    }
    @Test
    public void crearCartaMounstruoYColocarlaEnPosicionDeDefensa() {
        Mounstruo cartaMounstruo = Carta.crearCarta('Huevo Monstruoso');
        cartaMounstruo.colocarEnPosicionDeDefensa();
        Assert.assertEquals(cartaMounstruo.estado() IsInstanceOf posicionDeDefensa);

    }
    @Test
    public void crearCartaMounstruoYColocarlaEnPosicionDeDefensa() {
        Mounstruo cartaMounstruo = Carta.crearCarta('Huevo Monstruoso');
        cartaMounstruo.colocarEnPosicionDeDefensa();
        Assert.assertEquals(cartaMounstruo.estado() IsInstanceOf posicionDeDefensa);

    }

    @Test
    public void crearCartaMagicaYColocarBocaAbajo() {
        Magica cartaMagica = Carta.crearCarta('Agujero Oscuro');
        cartaMagica.colocarEnElCampo();
        Assert.assertEquals(cartaMagica.estado() IsInstanceOf BocaAbajo);

    }

    @Test
    public void crearCartaTrampaYColocarBocaAbajo() {
        Trampa cartaTrampa = Carta.crearCarta('Cilindro Magico');
        cartaTrampa.colocarEnElCampo();
        Assert.assertEquals(cartaTrampa.estado() IsInstanceOf BocaAbajo);

    }

    @Test
    public void crearCartaEnviarlaAlCementerio() {
        Trampa cartaTrampa = Carta.crearCarta('Cilindro Magico');
        Magica cartaMagica = Carta.crearCarta('Agujero Oscuro');
        Mounstruo cartaMounstruo = Carta.crearCarta('Huevo Monstruoso');
        cartaTrampa.enviarAlCementerio();
        cartaMagica.enviarAlCementerio();
        cartaMounstruo.enviarAlCementerio();
        Assert.assertEquals(cartaMagica.ubicacion() IsInstanceOf Cementerio);
        Assert.assertEquals(cartaTrampa.ubicacion() IsInstanceOf Cementerio);
        Assert.assertEquals(cartaMounstruo.ubicacion() IsInstanceOf Cementerio);

    }
    @Test
    public void crear2CartasMounstruoYColocarlaEnPosicionDeAtaqueYseAtaquenElEnemigoSiendoDestruido() {
        Mounstruo cartaMounstruo = Carta.crearCarta('Aguja Asesina');
        cartaMounstruo.colocarEnPosicionDeAtaque();
        Mounstruo cartaMounstruoEnemiga = Carta.crearCarta('Huevo Monstruoso');
        cartaMounstruoEnemiga.colocarEnPosicionDeAtaque();
        cartaMounstruo.atacar(cartaMounstruoEnemiga);
        Assert.assertEquals(cartaMounstruoEnemiga.ubicacion() IsInstanceOf Cementerio);

    }

    @Test
    public void crear2CartasMounstruoYColocarlaEnPosicionDeAtaqueYseAtaquenElAtacanteSiendoDestruido() {
        Mounstruo cartaMounstruo = Carta.crearCarta('Huevo Monstruoso');
        cartaMounstruo.colocarEnPosicionDeAtaque();
        Mounstruo cartaMounstruoEnemiga = Carta.crearCarta('Aguja Asesina');
        cartaMounstruoEnemiga.colocarEnPosicionDeAtaque();
        cartaMounstruo.atacar(cartaMounstruoEnemiga);
        Assert.assertEquals(cartaMounstruo.ubicacion() IsInstanceOf Cementerio);
    }

    @Test
    public void crear2CartasMounstruoYColocarlaEnPosicionDeAtaqueYseAtaquenAmbosSiendoDestruidos() {
        Mounstruo cartaMounstruo = Carta.crearCarta('Huevo Monstruoso');
        cartaMounstruo.colocarEnPosicionDeAtaque();
        Mounstruo cartaMounstruoEnemiga = Carta.crearCarta('Huevo Monstruoso');
        cartaMounstruoEnemiga.colocarEnPosicionDeAtaque();
        cartaMounstruo.atacar(cartaMounstruoEnemiga);
        Assert.assertEquals(cartaMounstruo.ubicacion() IsInstanceOf Cementerio && cartaMounstruoEnemiga.ubicacion() IsInstanceOf Cementerio);
    }

    @Test
    public void crear2CartasMounstruoYColocarUnaEnPosicionDeAtaqueYOtraEnPosicionDeDefensaYseAtaquenDestruyendoAlMounstruoAtacado() {
        //inicializar vida del jugador
        Mounstruo cartaMounstruo = Carta.crearCarta('Huevo Monstruoso');
        cartaMounstruo.colocarEnPosicionDeAtaque();
        Mounstruo cartaMounstruoEnemiga = Carta.crearCarta('Huevo Monstruoso');
        cartaMounstruoEnemiga.colocarEnPosicionDeDefensa();
        cartaMounstruo.atacar(cartaMounstruoEnemiga);
        Assert.assertEquals(cartaMounstruoEnemiga.ubicacion() IsInstanceOf Cementerio);
        //Assert.assertEquals();
        //agregar Assert para la vida del jugador
    }

    @Test
    public void crear2CartasMounstruoYColocarUnaEnPosicionDeAtaqueYOtraEnPosicionDeDefensaYseAtaquenNoDestruyendoseNingunoYReduciendoLaVidaDelAtacante() {
        //inicializar vida del jugador
        Mounstruo cartaMounstruo = Carta.crearCarta('Huevo Monstruoso');
        cartaMounstruo.colocarEnPosicionDeAtaque();
        Mounstruo cartaMounstruoEnemiga = Carta.crearCarta('Huevo Monstruoso');
        cartaMounstruoEnemiga.colocarEnPosicionDeDefensa();
        cartaMounstruo.atacar(cartaMounstruoEnemiga);
        Assert.assertEquals(!(cartaMounstruoEnemiga.ubicacion() IsInstanceOf Cementerio));
        //Assert.assertEquals();
        //agregar Assert para la vida del jugador
    }

    @Test
    public void crear2CartasMounstruoYColocarlaEnAmbosLadosYSiendoDestruidosPorLaCartaMagicaAgujeroNegro() {
        Mounstruo cartaMounstruo = Carta.crearCarta('Aguja Asesina');
        cartaMounstruo.colocarEnPosicionDeAtaque();
        Mounstruo cartaMounstruoEnemiga = Carta.crearCarta('Huevo Monstruoso');
        cartaMounstruoEnemiga.colocarEnPosicionDeAtaque();
        Magica cartaMagica = Carta.crearCarta('Agujero Oscuro');
        cartaMagica.activar();
        Assert.assertEquals(cartaMounstruo.ubicacion() IsInstanceOf Cementerio && cartaMounstruoEnemiga.ubicacion() IsInstanceOf Cementerio);

    }

    @Test
    public void crear2CartasMounstruoUnaNecesitandoSacrificarUnMounstruoParaConvocarseSacrificandoElPrimeroParaEntrarAlCampo() {
        Mounstruo cartaMounstruo = Carta.crearCarta('Aguja Asesina');
        cartaMounstruo.colocarEnPosicionDeAtaque();
        Mounstruo cartaMounstruoDe5Estrellas = Carta.crearCarta('Aitsu');
        cartaMounstruoDe5Estrellas.convocarse(cartaMounstruo);
        cartaMounstruoDe5Estrellas.colocarEnPosicionDeAtaque();

        Assert.assertEquals(cartaMounstruo.ubicacion() IsInstanceOf Cementerio && cartaMounstruoEnemiga.ubicacion() IsInstanceOf ZonaCampo);

    }

    @Test
    public void crear3CartasMounstruoYColocarlaAmbasYLuegoSacrificarlosParaConvocarUnMounstruoDe7Estrellas() {
        Mounstruo cartaMounstruo = Carta.crearCarta('Aguja Asesina');
        cartaMounstruo.colocarEnPosicionDeAtaque();
        Mounstruo cartaMounstruoSecundaria = Carta.crearCarta('Aitsu');
        Mounstruo cartaMounstruoDe7Estrellas = Carta.crearCarta('Dragon blanco de ojos azules');
        cartaMounstruoDe7Estrellas.convocarse(cartaMounstruo, cartaMounstruoSecundaria);
        cartaMounstruoDe7Estrellas.colocarEnPosicionDeAtaque();

        Assert.assertEquals(cartaMounstruo.ubicacion() IsInstanceOf Cementerio && cartaMounstruoSecundaria.ubicacion() IsInstanceOf Cementerio && cartaMounstruoEnemiga.ubicacion() IsInstanceOf ZonaCampo);

    }



}
