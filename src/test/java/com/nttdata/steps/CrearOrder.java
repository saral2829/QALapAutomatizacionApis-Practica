package com.nttdata.steps;


import com.nttdata.model.ConfigStore;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;

public class CrearOrder {
    private Response response;
    private JSONObject body;

    public void prepararEscenario(int idOrder, int idPet){
        body = new JSONObject();
        body.put("id", idOrder);
        body.put("petId", idPet);
        body.put("quantity", 5);
        body.put("ShipDate","2025-08-17T22:00:00.000Z");
        body.put("status", "placed");
        body.put("complete",true);
    }
    public void ejecutarCreacionOrden(){
        response=RestAssured.given()
                .baseUri(ConfigStore.BASE_URL)
                .contentType("application/json")
                .body(body.toString())
                .when()
                .post("/store/order")
                .then()
                .log()
                .all()
                .extract()
                .response();

    }

    public void validarStatusCode(int statusCode){
        Assert.assertEquals("Status Code " , statusCode, response.statusCode());
    }

    public void validarIds(int idOrder,int idPet){

        Assert.assertEquals("El Id de la orden no coinciden " , idOrder, response.jsonPath().getInt("id"));
        Assert.assertEquals("El Id de la mascota no coinciden " , idPet, response.jsonPath().getInt("petId"));
    }

}
