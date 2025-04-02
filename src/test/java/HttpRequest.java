import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HttpRequest {

    @Test(enabled = false)
    public void getUsers() {

        given().
                when().
                get("https://reqres.in/api/users?page=2").
                then()
                .statusCode(200).
                body("page", equalTo(2)).
                log().all();
    }
    @Test
    public void createUser(){

        HashMap data= new HashMap();
        data.put("name","naveen");
        data.put("job","IT");

        given().
                contentType("application/json").
                body(data).
                when().
                post("https://reqres.in/api/users").
                jsonPath().getInt("id");
//                then().
//                statusCode(201).
//                log().all();
    }
}
