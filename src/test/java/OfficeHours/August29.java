package OfficeHours;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

import static java.lang.String.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;


public class August29 {
    public static void main(String[] args) {
        String URL="http://api.zippopotam.us/us/90210";
       Scanner scanner=new Scanner(System.in);
        System.out.println("Enter your country code:" );
        String country=scanner.next();
        System.out.println("Enter your postal code:" );
        int postalCode=scanner.nextInt();



        baseURI="http://api.zippopotam.us";
        given()
                .pathParam("country",country)
                .pathParam("zip",postalCode).
        when()
                .get("/{country}/{zip}").prettyPeek();

        System.out.println("here is what i found: ");
        System.out.println("Country: ");


    }

}
