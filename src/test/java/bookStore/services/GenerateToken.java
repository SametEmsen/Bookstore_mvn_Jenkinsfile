package bookStore.services;

import bookStore.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;


import java.util.HashMap;
import java.util.Map;

public class GenerateToken extends Globals {

    public void generateToken(){
        Map<String, Object> map=new HashMap<>();
        map.put("userName",username);
        map.put("password",password);

        response= RestAssured.given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(map).log().all()
                .when()
                .post("/Account/v1/GenerateToken")
                .prettyPeek();
    }

    public void validateThatTokenIsCreated(){

        Assert.assertEquals(200,response.statusCode());

        token=response.path("token");

        //validate status is Success

        Assert.assertEquals("Success",response.path("status"));
    }
}
