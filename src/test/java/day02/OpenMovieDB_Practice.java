package day02;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class OpenMovieDB_Practice {
@BeforeAll
    public static void init(){
    RestAssured.baseURI = "http://www.omdbapi.com";

}
@DisplayName("test movie API")
    @Test
    public void testMovie(){

    given()
            .log().all()
            .queryParam("apikey","26aa5b74")
            .queryParam("t","Boss Baby")
            .queryParam("plot","full").
    when()
            .get().
    then()
            .log().all()
            .statusCode(200)
            .body("Title",containsString("Boss Baby"))
            .body("Ratings[0].Value",is("6.3/10"))
            .body("Ratings[2].Value",is("50/100"))
    ;
}



}
