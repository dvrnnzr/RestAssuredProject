package day03;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SpartanSearchExtractData {
    @BeforeAll
    public static void init(){
        RestAssured.baseURI ="http://52.91.178.101";
        RestAssured.port=8000;
        RestAssured.basePath ="/api";
    }
    @DisplayName("simple test")
    @Test
    public void test1(){
       Response response =
    given()
                .queryParam("gender","Female").
                when()
                .get("/spartans/search");
    JsonPath jp=response.jsonPath();

    }

}
