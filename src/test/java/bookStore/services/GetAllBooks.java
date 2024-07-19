package bookStore.services;

import bookStore.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

public class GetAllBooks extends Globals {

    public void getAllBooks(){
         response = RestAssured.given().accept(ContentType.JSON)
                .log().all()
                .when()
                .get("/BookStore/v1/Books")
                .prettyPeek();
    }

    public void validateThatAllBooksAreListed(){

        //validate status code
        Assert.assertEquals(200,response.statusCode());

        // get all isbn numbers
       isbnNumbers= response.path("books.isbn");

       // validate that list in not null

//        for (String isbnNumber : isbnNumbers) {
//            Assert.assertNotNull(isbnNumber);
//        }

        isbnNumbers.forEach(n-> Assert.assertNotNull(n));
    }
}
