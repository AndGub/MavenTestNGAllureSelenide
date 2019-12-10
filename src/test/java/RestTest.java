import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestTest {

    @BeforeTest
    void before() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @Test
    public void RestAssuredGet() {
        given().filter(new AllureRestAssured())
                .get("/api/users/2")
                .then().statusCode(200)
                    .body("data.id", equalTo(2))
                    .body("data.email", equalTo("janet.weaver@reqres.in"))
                    .body("data.first_name", equalTo("Janet"))
                    .body("data.last_name", equalTo("Weaver"))
                    .body("data.avatar", equalTo("https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg"));
    }

    @Test
    public void RestAssuredPost() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("email", "sydney@fife");
        given().filter(new AllureRestAssured())
                .given()
                .contentType("application/json")
                .body(map)
                .post("/api/register")
                .then().statusCode(400)
                .body("error", equalTo("Missing password"));
    }

    @Test
    public void RestAssuredPut() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "Anonymous");
        map.put("job", "Worker");

        given().filter(new AllureRestAssured())
                .given()
                .contentType("application/json")
                .body(map)
                .put("/api/users/2")
                .then().statusCode(200)
                .body("name", equalTo("Anonymous"))
                .body("job", equalTo("Worker"));
    }

    @Test
    public void RestAssuredDelete() {
        given().filter(new AllureRestAssured())
                .delete("/api/users/2")
                .then().statusCode(204);
    }

}
