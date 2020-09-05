package day03;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class ExtractingDataOutOfResponseBody {


    @DisplayName("Getting Movie info")
    @Test
    public void test1(){
        Response response =
        given()
                .log().all()
                .baseUri("http://www.omdbapi.com")
                .queryParam("apikey","26aa5b74")
                .queryParam("t","Boss Baby").
        when()
                .get();
    response.prettyPrint();
        System.out.println(response.statusCode());

        String title=response.path("Title");
        System.out.println("title = "+title );

        String year = response.path("Year") ;
        System.out.println("year = " + year);
        String director = response.path("Director") ;
        System.out.println("director = " + director);
        String actors = response.path("Actors");
        System.out.println("actors = " + actors);

        String firstRatingScr=response.path("Ratings[0].Source");
        System.out.println("firstRatingScr = " + firstRatingScr);

    }



}
