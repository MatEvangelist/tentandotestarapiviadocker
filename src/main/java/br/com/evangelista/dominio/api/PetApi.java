package br.com.evangelista.dominio.api;

import br.com.evangelista.dominio.entidades.Pet;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PetApi {

    private static final String FIND_PETS_BY_STATUS_ENDPOINT = "/v3/pet/findByStatus?status={status}";
    private static final String FIND_PETS_ENDPOINT = "/v3/pet/{petId}";

    public List<Pet> getPetsByStatus(String status) {
        return given()
            .pathParam("status", status)
        .when()
            .get(FIND_PETS_BY_STATUS_ENDPOINT)
        .then()
            .extract().body().jsonPath().getList("", Pet.class);
    }

    @SuppressWarnings("unused")
    public List<Pet> getPetsByStatus2 (String status) {
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.pathParam("status", status);
        Response response = httpRequest.get(FIND_PETS_BY_STATUS_ENDPOINT);
        JsonPath jsonPath = response.body().jsonPath();
        return jsonPath.getList("", Pet.class);
    }

    public Response getPetsResponseByStatus (String status) {
        return given()
            .pathParam("status", status)
        .when()
            .get(FIND_PETS_BY_STATUS_ENDPOINT);
    }

    @SuppressWarnings("unused")
    public Response getPetsResponseByStatus2 (String status) {
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.pathParam("status", status);
        return httpRequest.get(FIND_PETS_BY_STATUS_ENDPOINT);
    }

    public void deletePetsBySatus(String status) {
        List<Integer> petsId = given()
                .pathParam("satus", status)
            .when()
                .get(FIND_PETS_BY_STATUS_ENDPOINT)
            .thenReturn()
                .path("id");

        if (!petsId.isEmpty()) {
            for (Integer id : petsId) {
                given().pathParam("id", id).delete(FIND_PETS_ENDPOINT);
            }
        }
    }
}
