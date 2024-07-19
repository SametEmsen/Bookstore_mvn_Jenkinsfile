package bookStore.services;

import bookStore.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;

public class DeleteBook extends Globals {

    public void deleteBook(){

        String requestBody="{\n" +
                "  \"isbn\": \""+isbnNumbers.get(1)+"\",\n" +
                "  \"userId\": \""+userID+"\"\n" +
                "}";

    response= RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON)
            .header("Authorization","Bearer "+token)
            .body(requestBody).log().all()
            .when()
            .delete("/BookStore/v1/Book")
            .prettyPeek();
    }

    public void validation(){
        Assert.assertEquals(204,response.statusCode());
    }
}
