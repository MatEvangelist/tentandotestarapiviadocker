package br.com.evangelista.testes;

import br.com.evangelista.core.Constantes;
import io.restassured.builder.RequestSpecBuilder;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;

public class BaseTest implements Constantes {

    @BeforeAll
    static void restAssuredSetup() {
        baseURI = APP_BASE_URL;
        basePath = APP_BASE_PATH;

        requestSpecification = new RequestSpecBuilder()
                .setContentType(APP_CONTENT_TYPE)
                .addHeader("Authorization", getToken())
                .build();

    }

//        responseSpecification = new ResponseSpecBuilder()
//                .expectContentType(APP_CONTENT_TYPE)
//                .expectResponseTime(lessThan(MAX_TIMEOUT))
//                .build();
//
//        enableLoggingOfRequestAndResponseIfValidationFails();

    private static String getToken() {
        return "grant acess";

    }
}
