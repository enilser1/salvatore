package com.rimac.stepdefinitions;

import cucumber.api.java.es.*;
import net.serenitybdd.screenplay.actions.Open;
import questions.VistaCatalogo.ArticuloCatalogo;
import questions.VistaCategorias.ArticuloCategoria;
import tasks.VistaCatalogo.BuscarArticulo;
import tasks.VistaCatalogo.SeleccionarMarcas;
import tasks.VistaCatalogo.SeleccionarColor;
import tasks.VistaCategorias.SeleccionarCategoria;
import tasks.VistaCategorias.SeleccionarMarca;
import tasks.VistaPrincipal.SeleccionarTema;
import vistas.VistaPrincipal;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.hamcrest.CoreMatchers.equalTo;

public class CasosSteps {

    private VistaPrincipal homePage= new VistaPrincipal();

    //////////////////////

    @Dado("^Un cliente ingresa a la pagina de ebay$")
    public void unClienteIngresaALaPaginaDeEbay() {
        theActorCalled("Global").wasAbleTo(Open.browserOn(homePage));
        getDriver().manage().window().maximize();
    }

    /////////////////////////

    @Cuando("^realiza una búsqueda de (.*),$")
    public void realizaUnaBúsquedaDeZapatillaDeportiva(String articulo) {
        theActorInTheSpotlight().wasAbleTo(
                BuscarArticulo.conDescripcion(articulo)

        );
    }

    @Cuando("^realiza un filtro por dos colores de una marca específica$")
    public void realizaUnFiltroPorDosColoresDeUnaMarcaEspecífica(List<String> data) {
        theActorInTheSpotlight().wasAbleTo(
                SeleccionarColor.conDescripcion(data.get(0)),
                SeleccionarColor.conDescripcion(data.get(1)),
                SeleccionarMarcas.conDescripcion(data.get(2))
        );
    }

    @Entonces("^obtiene el precio de la marca en su (.*) posición y su precio mas caro$")
    public void obtieneElPrecioDeLaTerceraZapatillaYLaMásCara(String posicion) {
        System.out.println(ArticuloCatalogo.porPosicion(posicion).answeredBy(theActorInTheSpotlight()));
    }

    ///////////////////////





    @Cuando("^va al menu (.*) , selecciona (.*) luego (.*),$")
    public void vaAlMenuCasaYJardinYSeleccionaMaterialesDeBricolaje(String tema, String primeraCategoria, String segundaCategoria) {

            theActorInTheSpotlight().wasAbleTo(
                    SeleccionarTema.conTitulo(tema),
                    SeleccionarCategoria.conTitulo(primeraCategoria),
                    SeleccionarCategoria.conTitulo(segundaCategoria)
            );
    }

    @Y("^selecciona la opcion (.*), selecciona la marca (.*),$")
    public void seleccionaLaOpcionPuertasDeGarage(String terceraCategoria,String marca) {
        System.out.println("aaaa");
        theActorInTheSpotlight().wasAbleTo(
                SeleccionarCategoria.conTitulo(terceraCategoria),
                SeleccionarMarca.conTitulo(marca)
        );
    }

    @Entonces("^el precio de (.*) es de (.*) en total$")
    public void elPrecioDeEntrematicDITECZENEsDeEuros(String articulo,String precio) {
        theActorInTheSpotlight().should(seeThat("Comparando el precio", ArticuloCategoria.de(articulo), equalTo(precio)));
    }


}
