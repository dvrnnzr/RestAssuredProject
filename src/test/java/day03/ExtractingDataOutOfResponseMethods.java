package day03;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class ExtractingDataOutOfResponseMethods {


    @DisplayName("Getting Movie info")
    @Test
    public void test1(){
        Response response =
        given()
                .log().all()
                //.baseUri("http://www.omdbapi.com")
                .queryParam("apikey","26aa5b74")
                .queryParam("t","Boss Baby").
        when()
                .get("http://www.omdbapi.com");
    JsonPath jp=response.jsonPath();
    String title=jp.getString("Title");
        System.out.println("title = " + title);
    int year=jp.getInt("Year");
        System.out.println("year = " + year);
    String director=jp.getString("Director");
        System.out.println("director = " + director);
    String firstRate=jp.getString("Ratings[0].Source");
        System.out.println("firstRate = " + firstRate);
    String firstRatingValue=jp.getString("Ratings[0].Value");
        System.out.println("firstRatingValue = " + firstRatingValue);

        Map<String,Object> responseMap=jp.getMap("");
        //System.out.println("responseMap = " + responseMap);
        //System.out.println("Awards are "+ responseMap.get("Awards"));
        Map<String,Object> firstRatingMap= jp.getMap("Ratings[0]");
        System.out.println("firstRatingMap = " + firstRatingMap);

        List<String> sourceList =jp.getList("Ratings.Source");
        System.out.println("sourceList = " + sourceList);
    }



}
