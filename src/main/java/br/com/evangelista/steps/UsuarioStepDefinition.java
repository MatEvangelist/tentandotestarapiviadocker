package br.com.evangelista.steps;

 import gherkin.ast.DocString;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;

public class UsuarioStepDefinition {

    private Map<String, String> expectedUser = new HashMap<>();

    @Quando("faço um POST para {word} com os seguintes valores:")
    public void facoUmPOSTSeguintesValores(String endpoint, Map<String, String> user) {
        expectedUser = user;

        given()
            .body(user)
        .when()
            .post(endpoint)
        .then()
            .statusCode(HttpStatus.SC_OK);

    }

    @Então("quando faço um GET para {word}, o usuário criado é retornado")
    public void quandoFacoUmGETuusuarioCriadoERetornado(String endpoint) {
        when()
            .get(endpoint)
        .then()
            .statusCode(HttpStatus.SC_OK)
            .body("username", is(expectedUser.get("username")));
        // o primeiro username é do body da req e o segundo corresponde ao da tabela
    }

    @Quando("faço um POST para {word} com a seguinte docString:")
    public void facoUmPOSTParaSeguinteDocString(String endpoint, DocString docString) {
        expectedUser.put("username", "zawahiri");

        given()
            .body(docString.getContent())
        .when()
            .post(endpoint)
        .then()
            .statusCode(HttpStatus.SC_OK);
    }
}
