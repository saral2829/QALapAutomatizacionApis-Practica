package com.nttdata.steps;

import com.nttdata.model.ConfigPet;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import com.nttdata.model.ConfigPet;
import org.junit.Assert;

public class ConsultarMascota {

    private Response response;
    private int idMascota;

    public void prepararIdMascota(int idMascota){
        this.idMascota=idMascota;
    }

    public void consultarMascota(){
        response = RestAssured.given()
                .baseUri(ConfigPet.BASE_URL)
                .contentType("application/json")
                .when()
                .get(ConfigPet.CREATE_PET + "/" + idMascota) // GET /pet/{id}
                .then()
                .log().all()
                .extract().response();

    }
    public void validarConsulta(int statusCode){
        Assert.assertEquals("Status Code " , statusCode, response.statusCode());
    }
}
