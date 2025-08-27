package com.nttdata.glue;

import com.nttdata.steps.ConsultarMascota;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;


public class ConsultarMascotaStepDef {
   @Steps
    ConsultarMascota getmascota;


    @Given("que existe una mascota con ID {int}")
    public void queExisteUnaMascotaConID(int idMascota) {
        // Write code here that turns the phrase above into concrete actions
        getmascota.prepararIdMascota(idMascota);
    }

    @When("consulto la mascota por su ID")
    public void consultoLaMascotaPorSuID() {
        // Write code here that turns the phrase above into concrete actions
       getmascota.consultarMascota();
    }

    @Then("se mostrará la información de la mascota y se espera el codigo {int}")
    public void seMostraráLaInformaciónDeLaMascotaYSeEsperaElCodigoStatusCode(int statusCode) {
        // Write code here that turns the phrase above into concrete actions
        getmascota.validarConsulta(statusCode);
    }
}
