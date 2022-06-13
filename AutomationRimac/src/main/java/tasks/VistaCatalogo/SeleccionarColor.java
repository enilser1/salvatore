package tasks.VistaCatalogo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.Wait;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static vistas.VistaCatalogo.CHECKBOX_COLOR;
import static vistas.VistaCategorias.*;

public class SeleccionarColor implements Task {


    private String color;
    public SeleccionarColor(String color ){
        this.color=color;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        validarVentanaEmergente(actor);
        actor.attemptsTo(Click.on(CHECKBOX_COLOR.of(color)));
    }
    public static SeleccionarColor conDescripcion(String color) {
        return instrumented(SeleccionarColor.class,color);
    }

    private <T extends Actor> void validarVentanaEmergente(T actor) {
        Wait.until(the(BUTTON_ACEPTAR_VENTANA), isPresent()).forNoLongerThan(5);
        if (Visibility.of(BUTTON_ACEPTAR_VENTANA).viewedBy(actor).asBoolean())
            actor.attemptsTo(Click.on(BUTTON_ACEPTAR_VENTANA));
    }
}
