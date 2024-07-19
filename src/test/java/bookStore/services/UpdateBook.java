package bookStore.services;

import bookStore.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;

public class UpdateBook extends Globals {

    public void updateBook(){

        String requestBody="{\n" +
                "  \"userId\": \""+userID+"\",\n" +
                "  \"isbn\": \""+isbnNumbers.get(1)+"\"\n" +
                "}";

response= RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON)
        .header("Authorization","Bearer "+token)
        .body(requestBody)
        .when()
        .put("/BookStore/v1/Books/"+isbnNumbers.get(0))
        .prettyPeek();
    }

    public void validations(){
        Assert.assertEquals(200,response.statusCode());

        Assert.assertEquals(userID,response.path("userId"));
        Assert.assertEquals(username,response.path("username"));
        Assert.assertEquals(isbnNumbers.get(1),response.path("books.isbn[0]"));
    }
}
