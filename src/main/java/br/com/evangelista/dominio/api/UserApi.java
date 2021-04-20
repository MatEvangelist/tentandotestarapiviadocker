package br.com.evangelista.dominio.api;

import br.com.evangelista.dominio.entidades.User;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UserApi {

    private static final String CREATE_USER_ENDPOINT = "/v3/user";
    private static final String USER_ENDPOINT = "/v3/user/{name}";

    public void createUser(User user) {
        given()
                .body(user)
                .contentType(ContentType.JSON)
                .when()
                .post(CREATE_USER_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    public String getNicknameUsuario(User user) {
        return given()
                .pathParam("name", user.getUsername())
                .when()
                .get(USER_ENDPOINT)
                .thenReturn()
                .path("username");
    }

    public void deleteAllUsers() {
        List<String> userList = Arrays.asList("matevangelista");

        for (String user : userList) {
            given()
                    .pathParam("name", user)
                    .when()
                    .delete(USER_ENDPOINT)
                    .then()
                    .statusCode(HttpStatus.SC_OK)
                    .contentType(ContentType.ANY);
        }

    }

    public void deleteUser(User user) {
        given()
                .pathParam("name", user.getUsername())
                .when()
                .delete(USER_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.ANY);
    }
}
