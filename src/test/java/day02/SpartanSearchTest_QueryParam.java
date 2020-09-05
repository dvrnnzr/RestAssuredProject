package day02;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;

public class SpartanSearchTest_QueryParam {
    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI ="http://52.91.178.101:8000";
        RestAssured.basePath ="/api";
    }

    @DisplayName("Testing /spartans /search Endpoint")
    @Test
    public void testSearch(){
      given()
             .log().all()
             .queryParam("gender","Male")
             .queryParam("nameContains","ea").
      when()
            .get("spartans/search").
      then()
            .log().all()
            .statusCode(200)
            .body("numberOfElements",is(2));

    }






}
