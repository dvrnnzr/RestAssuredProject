package day01;
import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class RestAssuredMethodChaining {

    @DisplayName("First Attempt for chaining")
    @Test
    public void chainingMethodsTest1(){
        //given()
            //some
        //when()
        //then()
        when().
                get("http://52.91.178.101:8000/api/hello").
                prettyPeek().
        then().
                statusCode(is(200)).
                header("Content-Length",equalTo("17")).
                header("Content-Type",is("text/plain;charset=UTF-8")).
                body(is("Hello from Sparta"));
    }
    @DisplayName("Using Hamcrest matcher for assertion")
    @Test
    public void testingWithMatcher(){
        when().
                get("http://52.91.178.101:8000/api/hello").
                prettyPeek().
                then().
                statusCode(is(200)).
                header("Content-Length", equalTo("17"));


    }
    @DisplayName("TESTING Get /api/Spartans endpoint")
    @Test
    public void testAllSpartans(){
        given().
                header("Accept","application/xml").
        when().
                get("http://52.91.178.101:8000/api/spartans").
                prettyPeek().
        then().
                statusCode(is(200));

    }



}