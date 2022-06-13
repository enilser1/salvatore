package tasks.VistaCategorias;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static vistas.VistaCategorias.LINK_MARCA;

public class SeleccionarMarca implements Task {


    private String marca;
    public SeleccionarMarca(String marca ){
        this.marca=marca;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(LINK_MARCA.of(marca)));
    }
    public static SeleccionarMarca conTitulo(String marca) {
        return instrumented(SeleccionarMarca.class,marca);
    }
}
