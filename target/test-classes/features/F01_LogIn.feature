Feature: Login Functionality

  Scenario Outline: Login with invalid username and password
    Given Fill in the "<username>" and "<password>" in the Login with invalid credentials
    And Click on the Login button.
    Then Verify each error message

    Examples:
      | username      | password     |
      | wrong_user    | secret_sauce |
      | standard_user | wrong_pass   |
      | invalid_user  | invalid_pass |
      | locked_out    | wrong_pass   |
