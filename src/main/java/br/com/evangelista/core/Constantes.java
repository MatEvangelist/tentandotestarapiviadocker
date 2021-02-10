package br.com.evangelista.core;

import io.restassured.http.ContentType;

import static io.restassured.http.ContentType.JSON;

public interface Constantes {

    String APP_BASE_URL = "http://localhost:12345";
    String APP_BASE_PATH = "/api";
    ContentType APP_CONTENT_TYPE = JSON;
    Long MAX_TIMEOUT = 10000L;
}
