package day02;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class SpartanTest_Parameters {
    @BeforeAll
    public static void setUp(){

        RestAssured.baseURI ="http://52.91.178.101:8000";
        RestAssured.basePath = "/api" ;
    }

    @DisplayName("Testing / spartans / {id}")
    @Test
    public void testSingleSpartan(){
    given()
            .log().all()
            .pathParam("id",77).
    when()
            .get("/spartans/{id}").
    then()
            .statusCode(is(200))
            .log().body();




        ;
    }

    @DisplayName("Testing / spartans / {id} Body")
    @Test
    public void testSingleSpartanBody(){
        given()
                .log().all()
                .pathParam("id",77).
                when()
                .get("/spartans/{id}").
                then()
                .statusCode(is(200))
                .body("id", is(77)).
                body("name",is("Stevana")).
                body("gender", is ("Female")).
                body("phone", is(1459126818))


                .log().body();
    }
    @DisplayName("Testing2 / spartans / {id} Body")
    @Test
    public void testSingleSpartanBody2(){
        given()
                .log().all().
                when()
                .get("/spartans/{id}",77).
                then()
                .statusCode(is(200))
                .log().body();
    }
}
