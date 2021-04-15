package br.com.evangelista.dominio.api;

import br.com.evangelista.dominio.entidades.Pet;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PetApi {

    private static final String FIND_PETS_BY_STATUS_ENDPOINT = "/v3/pet/findByStatus?status={status}";
    private static final String FIND_PETS_ENDPOINT = "/v3/pet/{petId}";
    private static final String CREATE_PET_ENDPOINT = "/v3/pet";

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

    public Pet createPet(Pet pet) {
        return given()
                .body(pet)
            .when()
                .post(CREATE_PET_ENDPOINT)
            .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body().as(Pet.class);
    }

    public void deleteExtraPets(String status) {
        List<Integer> petsId = given()
            .pathParam("status", status)
        .when()
            .get(FIND_PETS_BY_STATUS_ENDPOINT)
        .thenReturn()
            .path("id");

        List<Integer> petsTokeep = Arrays.asList(1, 2, 3, 7, 8, 9, 10);

        for (int petId : petsId) {
            if (!petsTokeep.contains(petId)) {
                given()
                    .pathParam("petId", petId)
                    .delete(FIND_PETS_ENDPOINT)
                .then()
                    .statusCode(HttpStatus.SC_OK);
            }
        }
    }
}
