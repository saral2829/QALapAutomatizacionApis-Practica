package com.nttdata.steps;

import com.nttdata.model.ConfigPet;
import com.nttdata.model.ConfigStore;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class ConsultarOrder {

    private Response response;
    private int idOrder;


    public void prepararIdOrden(int idOrder)
    {
        this.idOrder=idOrder;

    }

    public void consultarOrder(){
        response = RestAssured.given()
                .baseUri(ConfigStore.BASE_URL)
                .contentType("application/json")
                .when()
                .get("/store/order/"+ idOrder) // GET /pet/{id}
                .then()
                .log().all()
                .extract().response();

    }
    public void validarConsulta(int statusCode){
        Assert.assertEquals("Status Code " , statusCode, response.statusCode());
    }

    public void validarIdOrden(int idOrder){
        Assert.assertEquals("El idOrder no coincide", idOrder,response.jsonPath().getInt("id"));
    }

}
