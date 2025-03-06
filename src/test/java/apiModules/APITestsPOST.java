package apiModules;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class APITestsPOST {

    @Test
    public void validarCriacaoUsuarioSucesso(){
        JSONObject request = new JSONObject();
        request.put("name", "Yuri");
        request.put("job", "Q.A");

        baseURI = "https://reqres.in/api";

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("/users").
                then().
                statusCode(201).
                body("name", equalTo("Yuri")).
                body("job", equalTo("Q.A")).
                body("id", notNullValue()).
                body("createdAt", notNullValue()).
                log().all();
    }
}