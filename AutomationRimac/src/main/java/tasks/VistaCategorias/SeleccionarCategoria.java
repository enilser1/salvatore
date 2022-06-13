package tasks.VistaCategorias;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.Wait;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static vistas.VistaCategorias.BUTTON_ACEPTAR_VENTANA;
import static vistas.VistaCategorias.LINK_CATEGORIA;

public class SeleccionarCategoria implements Task {


    private String categoria;
    public SeleccionarCategoria(String categoria ){
        this.categoria=categoria;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        validarVentanaEmergente(actor);
        actor.attemptsTo(Click.on(LINK_CATEGORIA.of(categoria)));
    }
    public static SeleccionarCategoria conTitulo(String categoria) {
        return instrumented(SeleccionarCategoria.class,categoria);
    }

    private <T extends Actor> void validarVentanaEmergente(T actor) {
        Wait.until(the(BUTTON_ACEPTAR_VENTANA), isPresent()).forNoLongerThan(5);
        if (Visibility.of(BUTTON_ACEPTAR_VENTANA).viewedBy(actor).asBoolean())
            actor.attemptsTo(Click.on(BUTTON_ACEPTAR_VENTANA));
    }
}
