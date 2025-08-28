package com.nttdata.glue;

import com.nttdata.steps.ConsultarOrder;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ConsultarOrderStepDef {

    @Steps
    ConsultarOrder consultaorden;

    @Given("que existe o no , la orden con ID {int}")
    public void queExisteONoLaOrdenConIDIdOrder(int idOrder) {
        // Write code here that turns the phrase above into concrete actions
       consultaorden.prepararIdOrden(idOrder);
    }

    @When("consulto la orden por su ID")
    public void consultoLaOrdenPorSuID() {
        // Write code here that turns the phrase above into concrete actions
       consultaorden.consultarOrder();
    }

    @Then("el código de respuesta debe ser {int}")
    public void elCódigoDeRespuestaDebeSerStatusCode(int statusCode) {
        // Write code here that turns the phrase above into concrete actions
        consultaorden.validarConsulta(statusCode);

    }

    @And("si existe, el response debe mostrar el mismo orderId {int}")
    public void siExisteElResponseDebeMostrarElMismoOrderIdIdOrder(int idOrder) {
        // Write code here that turns the phrase above into concrete actions
       consultaorden.validarIdOrden(idOrder);
    }


}
