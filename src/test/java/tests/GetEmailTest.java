package tests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetEmailTest {

    String email = "michael.lawson@reqres.in";
    @BeforeMethod
    public void setUp() {
         baseURI = "https://reqres.in";
    }
    @Test
    void validateEmail() {
        given().
            get(baseURI + "/api/users?page=2").
        then().
            statusCode(200).
            body("data.email", hasItem(email));
    }
}
