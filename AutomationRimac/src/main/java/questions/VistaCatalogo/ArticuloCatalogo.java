package questions.VistaCatalogo;

import net.serenitybdd.screenplay.Question;

import static vistas.VistaCatalogo.TEXT_PRECIO_CATALOGO;

public class ArticuloCatalogo {

    public static Question<String> porPosicion(String posicion) {
        return actor -> TEXT_PRECIO_CATALOGO.of(posicion).resolveFor(actor).getText();
    }
}
