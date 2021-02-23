package br.com.evangelista.dominio.api;

import br.com.evangelista.dominio.entidades.Pet;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class PetApi {

    private static final String FIND_PETS_BY_STATUS_ENDPOINT = "/v3/pet/findByStatus?status={status}";

    public List<Pet> getPetsByStatus(String status) {
        return given()
            .pathParam("status", status)
        .when()
            .get(FIND_PETS_BY_STATUS_ENDPOINT)
        .then()
            .extract().body().jsonPath().getList("", Pet.class);
    }
}
