package br.com.evangelista.core;

import io.cucumber.java.Before;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.lessThan;

public class Hooks implements Constantes{

    @Before
    public void setup() {
        baseURI = APP_BASE_URL;
        basePath = APP_BASE_PATH;

        requestSpecification = new RequestSpecBuilder()
                .setContentType(APP_CONTENT_TYPE)
                .addHeader("Authorization", getToken())
                .build();

        responseSpecification = new ResponseSpecBuilder()
                .expectContentType(APP_CONTENT_TYPE)
                .expectResponseTime(lessThan(MAX_TIMEOUT))
                .build();

        enableLoggingOfRequestAndResponseIfValidationFails();
    }

    private String getToken() {
        return "grant acess";
        // método de retornar token aqui...
    }
}
