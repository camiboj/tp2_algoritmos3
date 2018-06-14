import org.junit.Assert;
import org.junit.Test;

public class CartaTest {

    @Test
    public void crearCartaMounstruoYColocarlaEnPosicionDeAtaque() {
        Monstruo cartaMonstruo = Carta.crearCarta('Huevo Monstruoso');
        cartaMonstruo.colocarEnPosicionDeAtaque();
        Assert.assertEquals(cartaMounstruo.estado() IsInstanceOf posicionDeAtaque);
        
    }
    @Test
    public void crearCartaMounstruoYColocarlaEnPosicionDeDefensa() {
        Monstruo cartaMonstruo = Carta.crearCarta('Huevo Monstruoso');
        cartaMonstruo.colocarEnPosicionDeDefensa();
        Assert.assertEquals(cartaMounstruo.estado() IsInstanceOf posicionDeDefensa);

    }
    @Test
    public void crearCartaMounstruoYColocarlaEnPosicionDeDefensa() {
        Monstruo cartaMonstruo = Carta.crearCarta('Huevo Monstruoso');
        cartaMonstruo.colocarEnPosicionDeDefensa();
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
        Monstruo cartaMonstruo = Carta.crearCarta('Huevo Monstruoso');
        cartaTrampa.enviarAlCementerio();
        cartaMagica.enviarAlCementerio();
        cartaMonstruo.enviarAlCementerio();
        Assert.assertEquals(cartaMagica.ubicacion() IsInstanceOf Cementerio);
        Assert.assertEquals(cartaTrampa.ubicacion() IsInstanceOf Cementerio);
        Assert.assertEquals(cartaMounstruo.ubicacion() IsInstanceOf Cementerio);

    }
    @Test
    public void crear2CartasMounstruoYColocarlaEnPosicionDeAtaqueYseAtaquenElEnemigoSiendoDestruido() {
        Monstruo cartaMonstruo = Carta.crearCarta('Aguja Asesina');
        cartaMonstruo.colocarEnPosicionDeAtaque();
        Monstruo cartaMonstruoEnemiga = Carta.crearCarta('Huevo Monstruoso');
        cartaMonstruoEnemiga.colocarEnPosicionDeAtaque();
        cartaMonstruo.atacar(cartaMonstruoEnemiga);
        Assert.assertEquals(cartaMonstruoEnemiga.ubicacion() IsInstanceOf Cementerio);

    }

    @Test
    public void crear2CartasMounstruoYColocarlaEnPosicionDeAtaqueYseAtaquenElAtacanteSiendoDestruido() {
        Monstruo cartaMonstruo = Carta.crearCarta('Huevo Monstruoso');
        cartaMonstruo.colocarEnPosicionDeAtaque();
        Monstruo cartaMonstruoEnemiga = Carta.crearCarta('Aguja Asesina');
        cartaMonstruoEnemiga.colocarEnPosicionDeAtaque();
        cartaMonstruo.atacar(cartaMonstruoEnemiga);
        Assert.assertEquals(cartaMonstruo.ubicacion() IsInstanceOf Cementerio);
    }

    @Test
    public void crear2CartasMounstruoYColocarlaEnPosicionDeAtaqueYseAtaquenAmbosSiendoDestruidos() {
        Monstruo cartaMonstruo = Carta.crearCarta('Huevo Monstruoso');
        cartaMonstruo.colocarEnPosicionDeAtaque();
        Monstruo cartaMonstruoEnemiga = Carta.crearCarta('Huevo Monstruoso');
        cartaMonstruoEnemiga.colocarEnPosicionDeAtaque();
        cartaMonstruo.atacar(cartaMonstruoEnemiga);
        Assert.assertEquals(cartaMonstruo.ubicacion() IsInstanceOf Cementerio && cartaMonstruoEnemiga.ubicacion() IsInstanceOf Cementerio);
    }

    @Test
    public void crear2CartasMounstruoYColocarUnaEnPosicionDeAtaqueYOtraEnPosicionDeDefensaYseAtaquenDestruyendoAlMounstruoAtacado() {
        //inicializar vida del jugador
        Monstruo cartaMounstruo = Carta.crearCarta('Huevo Monstruoso');
        cartaMounstruo.colocarEnPosicionDeAtaque();
        Monstruo cartaMonstruoEnemiga = Carta.crearCarta('Huevo Monstruoso');
        cartaMonstruoEnemiga.colocarEnPosicionDeDefensa();
        cartaMounstruo.atacar(cartaMonstruoEnemiga);
        Assert.assertEquals(cartaMonstruoEnemiga.ubicacion() IsInstanceOf Cementerio);
        //Assert.assertEquals();
        //agregar Assert para la vida del jugador
    }

    @Test
    public void crear2CartasMounstruoYColocarUnaEnPosicionDeAtaqueYOtraEnPosicionDeDefensaYseAtaquenNoDestruyendoseNingunoYReduciendoLaVidaDelAtacante() {
        //inicializar vida del jugador
        Monstruo cartaMonstruo = Carta.crearCarta('Huevo Monstruoso');
        cartaMonstruo.colocarEnPosicionDeAtaque();
        Mounstruo cartaMonstruoEnemiga = Carta.crearCarta('Huevo Monstruoso');
        cartaMonstruoEnemiga.colocarEnPosicionDeDefensa();
        cartaMonstruo.atacar(cartaMonstruoEnemiga);
        Assert.assertEquals(!(cartaMonstruoEnemiga.ubicacion() IsInstanceOf Cementerio));
        //Assert.assertEquals();
        //agregar Assert para la vida del jugador
    }

    @Test
    public void crear2CartasMounstruoYColocarlaEnAmbosLadosYSiendoDestruidosPorLaCartaMagicaAgujeroNegro() {
        Monstruo cartaMonstruo = Carta.crearCarta('Aguja Asesina');
        cartaMonstruo.colocarEnPosicionDeAtaque();
        Monstruo cartaMounstruoEnemiga = Carta.crearCarta('Huevo Monstruoso');
        cartaMounstruoEnemiga.colocarEnPosicionDeAtaque();
        Magica cartaMagica = Carta.crearCarta('Agujero Oscuro');
        cartaMagica.activar();
        Assert.assertEquals(cartaMonstruo.ubicacion() IsInstanceOf Cementerio && cartaMounstruoEnemiga.ubicacion() IsInstanceOf Cementerio);

    }

    @Test
    public void crear2CartasMounstruoUnaNecesitandoSacrificarUnMounstruoParaConvocarseSacrificandoElPrimeroParaEntrarAlCampo() {
        Monstruo cartaMonstruo = Carta.crearCarta('Aguja Asesina');
        cartaMonstruo.colocarEnPosicionDeAtaque();
        Monstruo cartaMonstruoDe5Estrellas = Carta.crearCarta('Aitsu');
        cartaMonstruoDe5Estrellas.convocarse(cartaMounstruo);
        cartaMonstruoDe5Estrellas.colocarEnPosicionDeAtaque();

        Assert.assertEquals(cartaMonstruo.ubicacion() IsInstanceOf Cementerio && cartaMonstruoEnemiga.ubicacion() IsInstanceOf ZonaCampo);

    }

    @Test
    public void crear3CartasMounstruoYColocarlaAmbasYLuegoSacrificarlosParaConvocarUnMounstruoDe7Estrellas() {
        Monstruo cartaMonstruo = Carta.crearCarta('Aguja Asesina');
        cartaMoustruo.colocarEnPosicionDeAtaque();
        Monstruo cartaMounstruoSecundaria = Carta.crearCarta('Aitsu');
        Monstruo cartaMounstruoDe7Estrellas = Carta.crearCarta('Dragon blanco de ojos azules');
        cartaMounstruoDe7Estrellas.convocarse(cartaMonstruo, cartaMounstruoSecundaria);
        cartaMounstruoDe7Estrellas.colocarEnPosicionDeAtaque();

        Assert.assertEquals(cartaMonstruo.ubicacion() IsInstanceOf Cementerio && cartaMounstruoSecundaria.ubicacion() IsInstanceOf Cementerio && cartaMonstruoEnemiga.ubicacion() IsInstanceOf ZonaCampo);

    }

}
