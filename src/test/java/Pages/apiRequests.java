package Pages;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class apiRequests extends commonMethods {

    public static Response getUnixTime(String unixTime){
        return given().accept(ContentType.JSON).and().queryParam("unixtimestamp", unixTime)
                .when().get("/");
    }

    public static String getBodyAsString(String unixTime){
        return given().accept(ContentType.JSON).and().queryParam("unixtimestamp", unixTime)
                .when().get().asString();
    }
}
