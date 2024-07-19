package bookStore.services;

import bookStore.utilities.Globals;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class CreateUser extends Globals {

    public void createUser(){

        username=new Faker().name().username();
        password="1234.Asdf*";

        Map<String ,Object> map=new HashMap<>();
        map.put("userName",username);
        map.put("password",password);

        response= RestAssured.given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(map)
                .log().all()
                .post("/Account/v1/User")
                .prettyPeek();
    }


    public void validateThatUserIsCreated(){
        Assert.assertEquals(201,response.statusCode());

        //validate usernameü
        Assert.assertEquals(username,response.path("username"));

        userID=response.path("userID");
    }
}
