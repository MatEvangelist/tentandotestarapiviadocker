package br.com.evangelista.steps;

import gherkin.ast.DocString;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class DocstringETabelaSteps {

    private Map<String, String> expectedUserTabela = new HashMap<>();


    @Quando("faço um POST para {word} com os seguintes valores:")
    public void facoUmPOSTParaVUserComOsSeguintesValores(String endpoint, Map<String, String> userTabela) {
        expectedUserTabela = userTabela;

        given()
            .body(userTabela)
        .when()
            .post(endpoint)
        .then()
            .statusCode(HttpStatus.SC_OK);
    }

    @Então("quando faço um GET para {word}, o usuário criado é retornado")
    public void quandoFacoUmGETParaVUserMatevangelistaOUsuarioCriadoERetornado(String endpoint) {
        when()
            .get(endpoint)
        .then()
            .statusCode(HttpStatus.SC_OK)
            .body("username", Matchers.is(expectedUserTabela.get("username")));

    }

    @Quando("faço um POST para {word} com a seguinte docString:")
    public void facoUmPOSTParaVUserComASeguinteDocString(String endpoint, DocString docString) {
        expectedUserTabela.put("username", "zawahiri");

        given()
            .body(docString.getContent())
        .when()
            .post(endpoint)
        .then()
            .statusCode(HttpStatus.SC_OK);
    }
}
