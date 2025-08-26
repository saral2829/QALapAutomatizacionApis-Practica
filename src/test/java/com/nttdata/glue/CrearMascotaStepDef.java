package com.nttdata.glue;

import com.nttdata.steps.CrearMascota;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CrearMascotaStepDef {
    @Steps
    CrearMascota crearmascota;

    @Given("que preparo la información de la mascota con categoría {string} y nombre {string}")
    public void quePreparoLaInformaciónDeLaMascotaConCategoríaYNombre(String categoria, String nombre) {
        // Write code here that turns the phrase above into concrete actions
        crearmascota.prepararMascota(categoria,nombre);
    }

    @When("envío la solicitud para crear la mascota")
    public void envíoLaSolicitudParaCrearLaMascota() {
        // Write code here that turns the phrase above into concrete actions
        crearmascota.enviarSolicitud();

    }

    @Then("la mascota creada de {string} con {int}")
    public void laMascotaCreadaDeCon(String nombre, int statusCode) {
        // Write code here that turns the phrase above into concrete actions
        crearmascota.validarRespuesta(nombre,statusCode);
    }

}
