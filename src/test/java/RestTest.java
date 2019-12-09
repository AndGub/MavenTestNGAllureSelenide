import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestTest {


    @Test
    public void RestAssuredGet() {
        RestAssured.baseURI = "https://reqres.in";

        Response response = given().filter(new AllureRestAssured()).get("https://reqres.in");
        response.then().statusCode(200);


    }
}
