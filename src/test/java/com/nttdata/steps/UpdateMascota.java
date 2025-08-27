package com.nttdata.steps;
import com.nttdata.model.ConfigPet;
//import com.nttdata.steps.CrearMascota;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;


public class UpdateMascota {
    private JSONObject body;
    private JSONObject updatebody;
    private Response response;
    private int mascotaId;

    public void prepararMascota(String nombre){
            body = new JSONObject();
            body.put("id",0);
            body.put("name",nombre);
            body.put("status","available");
    }

    public void enviarCreacion(){
        response = RestAssured.given()
        .baseUri(ConfigPet.BASE_URL)
                .contentType("application/json")
                .body(body.toString())
                .when()
                .post(ConfigPet.CREATE_PET);
        response.then()
                .log()
                .all();
        mascotaId = response.jsonPath().getInt("id");

    }

    public void actualizarMascota(String nombre, String status){
        updatebody = new JSONObject();
        updatebody.put("id", mascotaId);
        updatebody.put("name",nombre);
        updatebody.put("status",status);

        response = RestAssured.given()
                .baseUri(ConfigPet.BASE_URL)
                .contentType("application/json")
                .body(updatebody.toString())
                .when()
                .put(ConfigPet.CREATE_PET);
                response.then()
                .log()
                .all();
    }
     public void validarRespuesta(int statusCode, String updateNombre,String updateStatus){
         int actualStatusCode = response.getStatusCode();
         org.junit.Assert.assertEquals("El status code no coincide", statusCode, actualStatusCode);

         // Validar nombre de la mascota
         String nombre = response.jsonPath().getString("name");
         org.junit.Assert.assertEquals("El nombre no coincide", updateNombre, nombre);

         // Validar estado de la mascota
         String estado = response.jsonPath().getString("status");
         org.junit.Assert.assertEquals("El estado no coincide", updateStatus, estado);
     }



}
