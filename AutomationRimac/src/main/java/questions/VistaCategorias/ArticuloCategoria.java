package questions.VistaCategorias;

import net.serenitybdd.screenplay.Question;

import static vistas.VistaCategorias.TEXT_PRECIO;

public class ArticuloCategoria {

    public static Question<String> de(String articulo) {
        return actor -> TEXT_PRECIO.of(articulo).resolveFor(actor).getText();
    }
}
