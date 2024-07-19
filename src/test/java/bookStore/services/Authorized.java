package bookStore.services;

import bookStore.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class Authorized extends Globals {

    public void authorizeUser(){
        Map<String, Object> map=new HashMap<>();
        map.put("userName",username);
        map.put("password",password);

        response= RestAssured.given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(map).log().all()
                .when()
                .post("/Account/v1/Authorized")
                .prettyPeek();
    }

    public void validateThatUserIsAuthorized(){
        Assert.assertEquals(200,response.statusCode());

        //validate response body
        Assert.assertTrue(response.asString().contains("true"));
    }
}
