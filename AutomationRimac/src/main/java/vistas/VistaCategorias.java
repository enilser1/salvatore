package vistas;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class VistaCategorias extends PageObject {



    public static final Target BUTTON_ACEPTAR_VENTANA = Target.the("Aceptar ventana").located(By.id("gdpr-banner-accept"));
    public static final Target LINK_CATEGORIA = Target.the("Categoria del articulo").locatedBy("//div[contains(text(),'{0}')]");
    public static final Target LINK_MARCA = Target.the("Marca del articulo").locatedBy("//p[contains(text(),'{0}')]");
    public static final Target TEXT_PRECIO = Target.the("Precio del articulo").locatedBy("//div[@class='s-item__info clearfix'][.//h3[contains(text(),'{0}')]]//span[@class='s-item__price']");

}
