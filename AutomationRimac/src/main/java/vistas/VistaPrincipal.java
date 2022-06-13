package vistas;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://www.ebay.es/")
public class VistaPrincipal extends PageObject {


    public static final Target INPUT_BUSCAR_ARTICULO = Target.the("Caja de texto de busqueda de articulo").locatedBy("//input[@type='text']");
    public static final Target LINK_TEMA = Target.the("link de tema que contiene muchas categorias").locatedBy("//li[@data-currenttabindex]//a[contains(text(),'{0}')]");


}
