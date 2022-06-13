package vistas;

import net.serenitybdd.screenplay.targets.Target;

public class VistaCatalogo {

    public static final Target CHECKBOX_COLOR = Target.the("Color del articulo").locatedBy("//span[contains(text(),'{0}')]");
    public static final Target LINK_VER_MARCAS = Target.the("Link de para ver todas las marcas").locatedBy("//button[contains(text(),'ver todos') and contains(@aria-label,'Marca')]");
    public static final Target CHECKBOX_MARCA = Target.the("Checkbox de marca").locatedBy("//input[contains(@id,'{0}-0')]");
    public static final Target BUTTON_APLICAR = Target.the("Boton para aceptar marca").locatedBy("//button[@aria-label='Aplicar']");
    public static final Target TEXT_PRECIO_CATALOGO = Target.the("Precio del articulo").locatedBy("//li[@data-gr4='{0}']//div[@class='s-item__details clearfix']//span[@class='s-item__price']");


}
