Feature: Bookstore Api Flow


  @wip
  Scenario: Bookstore test
    # for get all books
    When Get all Books
    Then Validate that all books are listed
  # second step for creating new user
    When Create new User
    Then Validate that user is created