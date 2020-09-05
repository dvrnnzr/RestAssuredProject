package day02;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

// you may also add display name at class level like you did at test level
@DisplayName("Testing Zip Code API")
public class ZipCodeTest {

    @BeforeAll
    public static void init(){
        RestAssured.baseURI="http://api.zippopotam.us";
        RestAssured.basePath="/us";

    }
    @Test
    @DisplayName("Zip to City Test")
    public void testZipToCity(){

        given()
                .pathParam("zip", 11235)
                .log().all().
        when()
                .get("/{zip}").
        then()
                .log().all()
                .statusCode(is(200))
                .contentType(ContentType.JSON)
                .body("country",is("United States"))
                .body("places[0].state",is("New York"))
                .body("'post code'", is("11235"))
                .body("places[0].'place name'",is("Brooklyn"))
                .body("places[0].'state abbreviation'",is("NY"))

        ;
    }
    @Test
    @DisplayName("City to Zip Test")
    public void testCityToZip(){
        given()
                .pathParam("state", "NY")
                .pathParam("city","Brooklyn")
                .log().all().
        when ()
                .get("{state}/{city}").
        then()
                .log().all()
                .statusCode(is(200))
                .body("'country abbreviation'", is("US"))
                .body("places[0].latitude",is("40.694"))
                .body("places[-1].'post code'",is("11255"))


        ;
    }
}
