package bookStore.services;

import bookStore.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;

public class GetUserInfo extends Globals {

    public void getUserInfo(){

        response= RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .header("Authorization","Bearer "+token).log().all()
                .when()
                .get("/Account/v1/User/"+userID)
                .prettyPeek();
    }

    public void vvalidations(){
        Assert.assertEquals(200,response.statusCode());

        Assert.assertEquals(userID,response.path("userId"));
        Assert.assertEquals(username,response.path("username"));
        Assert.assertEquals(isbnNumbers.get(0),response.path("books.isbn[0]"));
    }
}
