package tasks.VistaCatalogo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.Wait;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static vistas.VistaCategorias.BUTTON_ACEPTAR_VENTANA;
import static vistas.VistaPrincipal.*;

public class BuscarArticulo implements Task {

    private String articulo;

    public BuscarArticulo(String articulo){
        this.articulo=articulo;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        validarVentanaEmergente(actor);
        actor.attemptsTo(
        Enter.theValue(articulo).into(INPUT_BUSCAR_ARTICULO),
        Hit.the(Keys.ENTER).into(INPUT_BUSCAR_ARTICULO));
        /*for(String winHandle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(winHandle);
        }*/

    }


    public static BuscarArticulo conDescripcion(String articulo) {
        return instrumented(BuscarArticulo.class,articulo);
    }

    private <T extends Actor> void validarVentanaEmergente(T actor) {
        Wait.until(the(BUTTON_ACEPTAR_VENTANA), isPresent()).forNoLongerThan(5);
        if (Visibility.of(BUTTON_ACEPTAR_VENTANA).viewedBy(actor).asBoolean())
            actor.attemptsTo(Click.on(BUTTON_ACEPTAR_VENTANA));
    }
}
