package br.com.evangelista.core;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import org.junit.Before;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.lessThan;

public class Hooks implements Constantes{

    @Before
    public void setup() {
        baseURI = APP_BASE_URL;
        basePath = APP_BASE_PATH;
        port = APP_PORT;

        requestSpecification = new RequestSpecBuilder()
                .setContentType(APP_CONTENT_TYPE).build();

        responseSpecification = new ResponseSpecBuilder()
                .expectContentType(APP_CONTENT_TYPE)
                .expectResponseTime(lessThan(MAX_TIMEOUT))
                .build();

        enableLoggingOfRequestAndResponseIfValidationFails();

    }
}
