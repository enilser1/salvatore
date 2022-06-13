package tasks.VistaCatalogo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.Wait;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static vistas.VistaCatalogo.*;
import static vistas.VistaCategorias.BUTTON_ACEPTAR_VENTANA;

public class SeleccionarMarcas implements Task {


    private String marca;
    public SeleccionarMarcas(String marca ){
        this.marca=marca;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        validarVentanaEmergente(actor);
        actor.attemptsTo
                (Click.on(LINK_VER_MARCAS),
                 Click.on(CHECKBOX_MARCA.of(marca)),
                 Click.on(BUTTON_APLICAR)
        );
    }
    public static SeleccionarMarcas conDescripcion(String color) {
        return instrumented(SeleccionarMarcas.class,color);
    }

    private <T extends Actor> void validarVentanaEmergente(T actor) {
        Wait.until(the(BUTTON_ACEPTAR_VENTANA), isPresent()).forNoLongerThan(5);
        if (Visibility.of(BUTTON_ACEPTAR_VENTANA).viewedBy(actor).asBoolean())
            actor.attemptsTo(Click.on(BUTTON_ACEPTAR_VENTANA));
    }
}
