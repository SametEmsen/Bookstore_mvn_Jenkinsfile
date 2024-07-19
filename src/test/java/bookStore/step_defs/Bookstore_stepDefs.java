package bookStore.step_defs;

import bookStore.services.CreateUser;
import bookStore.services.GetAllBooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Bookstore_stepDefs {

    GetAllBooks getAllBooks = new GetAllBooks();
    CreateUser createUser = new CreateUser();

    @When("Get all Books")
    public void get_all_books() {
        getAllBooks.getAllBooks();
    }

    @Then("Validate that all books are listed")
    public void validate_that_all_books_are_listed() {
        getAllBooks.validateThatAllBooksAreListed();
    }

    @When("Create new User")
    public void create_new_user() {
        createUser.createUser();
    }

    @Then("Validate that user is created")
    public void validate_that_user_is_created() {
        createUser.validateThatUserIsCreated();
    }
}
