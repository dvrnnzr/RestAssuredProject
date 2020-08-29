package day02;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.*;

public class SpartanTest {
    @DisplayName("Get All Spartan")
    @Test
    public void testAllSpartans(){
        String spartanURL="http://52.91.178.101:8000/api/spartans";

        RestAssured.baseURI ="http://52.91.178.101:8000";
        RestAssured.basePath ="/api";

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

        given()
                .baseUri("http://52.91.178.101:8000")
                .basePath("/api")
                .accept("Application/json").
                when()
                .get("/spartans").
                prettyPeek().
                then()
                .statusCode(is(200))
                //.contentType(is("application/json;charset=UTF-8"));
                .contentType(ContentType.JSON);

    }
}
