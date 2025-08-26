package com.nttdata.steps;
import io.restassured.RestAssured;
import org.json.JSONObject;
import io.restassured.response.Response;
import org.junit.Assert;


public class CrearMascota {
    private JSONObject body;
    private Response response;

    // Construir el body de la mascota
    public void prepararMascota(String categoria, String nombre) {
        body = new JSONObject();
        body.put("id", 0);

        JSONObject category = new JSONObject();
        category.put("id", 1);
        category.put("name", categoria);

        body.put("category", category);
        body.put("name", nombre);
        body.put("photoUrls", new String[]{"https://foto.com/" + nombre + ".jpg"});

        JSONObject tag = new JSONObject();
        tag.put("id", 10);
        tag.put("name", "tag-" + categoria);

        body.put("tags", new JSONObject[]{tag});
        body.put("status", "available");
    }

    // Enviar la solicitud
    public void enviarSolicitud() {
        response = RestAssured.given()
                .baseUri("https://petstore.swagger.io/v2")
                .contentType("application/json")
                .body(body.toString())
                .when()
                .post("/pet");

        response.then().log().all();
    }

    // Validar respuesta con nombre y código esperado
    public void validarRespuesta(String nombreEsperado, int statusCodeEsperado) {
        Assert.assertEquals(statusCodeEsperado, response.getStatusCode());

        String nombreReal = response.jsonPath().getString("name");
        Assert.assertEquals(nombreEsperado, nombreReal);

        String estado = response.jsonPath().getString("status");
        Assert.assertEquals("available", estado);
    }
}
