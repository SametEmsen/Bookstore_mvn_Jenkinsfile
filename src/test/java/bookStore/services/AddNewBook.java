package bookStore.services;

import bookStore.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;

public class AddNewBook extends Globals {

    public void addBook(){
        String jsonBody="{\n" +
                "  \"userId\": \""+userID+"\",\n" +
                "  \"collectionOfIsbns\": [\n" +
                "    {\n" +
                "      \"isbn\": \""+isbnNumbers.get(0)+"\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        response= RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .body(jsonBody).log().all()
                .when()
                .post("/BookStore/v1/Books")
                .prettyPeek();
    }

    public void validateThatBookIsAdded(){
        Assert.assertEquals(201,response.statusCode());
        Assert.assertEquals(isbnNumbers.get(0),response.path("books.isbn[0]"));
    }
}
