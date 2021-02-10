package br.com.evangelista.core;

import io.restassured.http.ContentType;

import static io.restassured.http.ContentType.JSON;

public interface Constantes {

    String APP_BASE_URL = "https://petstore.swagger.io";
    Integer APP_PORT = 443;
    String APP_BASE_PATH = "/v2";
    ContentType APP_CONTENT_TYPE = JSON;
    Long MAX_TIMEOUT = 10000L;
}
