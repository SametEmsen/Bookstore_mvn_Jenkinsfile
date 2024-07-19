Feature: Bookstore Api Flow


  @wip
  Scenario: Bookstore test
    # for get all books
    When Get all Books
    Then Validate that all books are listed
  # second step for creating new user
    When Create new User
    Then Validate that user is created

    When Generate token
    Then Validate that token is created

    When Authorized User
    Then Validate that user is authorized

    When Add new book to user
    Then Validate that new book is added

    When Get User Info
    Then Validate that user's details are correct

    When Update book
    Then Validate that book is updated

    When Delete Book
    Then Validate that book is removed