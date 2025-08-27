package com.nttdata.glue;
//import com.nttdata.steps.CrearMascota;
import com.nttdata.steps.UpdateMascota;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class UpdateMascotaStepDef {

    @Steps
    UpdateMascota updatemascota;
    private String updateNombre;
    private String updateStatus;

    @Given("que preparo una mascota con el nombre {string}")
    public void quePreparoUnaMascotaConElNombre(String nombre) {
        // Write code here that turns the phrase above into concrete actions
        updatemascota.prepararMascota(nombre);
    }

    @And("envío la creación de la mascota obteniendo el ID")
    public void envíoLaCreaciónDeLaMascotaObteniendoElID() {
        // Write code here that turns the phrase above into concrete actions
        updatemascota.enviarCreacion();
    }

    @When("actualizo la mascota con el nombre {string} y el estado {string}")
    public void actualizoLaMascotaConElNombreYElEstado(String nombre, String status) {
        // Write code here that turns the phrase above into concrete actions
        updateNombre=nombre;
        updateStatus=status;
        updatemascota.actualizarMascota(nombre,status);
    }


    @Then("se mostrará la mascota con su nombre, estado actualizada y código {int}")
    public void seMostraráLaMascotaConSuNombreEstadoActualizadaYCódigoStatusCode(int statusCode) {
        // Write code here that turns the phrase above into concrete actions
        updatemascota.validarRespuesta(statusCode,updateNombre,updateStatus);
    }
}
