package bookStore.step_defs;

import bookStore.services.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Bookstore_stepDefs {

    GetAllBooks getAllBooks = new GetAllBooks();
    CreateUser createUser = new CreateUser();

    GenerateToken generateToken = new GenerateToken();

    Authorized authorized = new Authorized();
    AddNewBook addNewBook = new AddNewBook();

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

    @When("Generate token")
    public void generate_token() {
        generateToken.generateToken();
    }

    @Then("Validate that token is created")
    public void validate_that_token_is_created() {
        generateToken.validateThatTokenIsCreated();
    }


    @When("Authorized User")
    public void authorized_user() {
        authorized.authorizeUser();
    }

    @Then("Validate that user is authorized")
    public void validate_that_user_is_authorized() {
        authorized.validateThatUserIsAuthorized();
    }

    @When("Add new book to user")
    public void add_new_book_to_user() {
        addNewBook.addBook();
    }

    @Then("Validate that new book is added")
    public void validate_that_new_book_is_added() {
        addNewBook.validateThatBookIsAdded();
    }
}
