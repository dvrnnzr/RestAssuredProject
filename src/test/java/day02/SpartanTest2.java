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

public class SpartanTest2 {

    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI ="http://52.91.178.101:8000";
        RestAssured.basePath ="/api";
    }


    @DisplayName("Get one Spartan")
    @Test
    public void testSingleSpartan(){

    given().
            log().all().
         // log().uri().


    when()
            .get("/spartans/77")
            .//prettyPeek().
    then()
            .log().all()
            .statusCode(is(200))

            ;



    }



    @DisplayName("Hello test point")
    @Test
    public void testHello(){
        given()
                .accept(ContentType.TEXT).
        when()
               .get("/hello").
        then()
                .statusCode(is(200))
                .contentType(ContentType.TEXT)
                .body(equalTo("Hello from Sparta"));




    }


    @DisplayName("Get All Spartan")
    @Test
    public void testAllSpartans(){
       // String spartanURL="http://52.91.178.101:8000/api/spartans";

      given()
            .header("Accept", "Application/json").
    when().
            get("/spartans").
            //    get(spartanURL).
            prettyPeek().
    then()
            .statusCode(is(200));
    }
    @DisplayName("Get All Spartan")
    @Test
    public void testAllSpartans2() {

        given().
         //       .baseUri("http://52.91.178.101:8000")
         //       .basePath("/api")
         //       .accept("Application/json").
        when()
                .get("/spartans").
                prettyPeek().
                then()
                .statusCode(is(200))
                //.contentType(is("application/json;charset=UTF-8"));
                .contentType(ContentType.JSON);

    }
}
