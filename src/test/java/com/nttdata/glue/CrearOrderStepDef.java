package com.nttdata.glue;

import com.nttdata.steps.CrearOrder;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CrearOrderStepDef {

    @Steps

    CrearOrder crearoden;

    @Given("preparo una orden con orderId {int} y petId {int}")
    public void preparoUnaOrdenConOrderIdIdOrderYPetIdIdPet(int idOrder, int idPet) {
        // Write code here that turns the phrase above into concrete actions
     crearoden.prepararEscenario(idOrder,idPet);
    }

    @When("ejecuto la creación de la orden")
    public void ejecutoLaCreaciónDeLaOrden() {
        // Write code here that turns the phrase above into concrete actions
        crearoden.ejecutarCreacionOrden();
    }

    @Then("la respuesta debe tener el código de estado {int}")
    public void laRespuestaDebeTenerElCódigoDeEstadoStatusCode(int statusCode) {
        // Write code here that turns the phrase above into concrete actions
        crearoden.validarStatusCode(statusCode);
    }

    @And("el response debe mostrar el mismo orderId {int} y petId {int}")
    public void elResponseDebeMostrarElMismoOrderIdIdOrderYPetIdIdPet(int idOrder,int idPet) {
        // Write code here that turns the phrase above into concrete actions
       crearoden.validarIds(idOrder,idPet);
    }
}
