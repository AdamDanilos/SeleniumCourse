Feature: Hotel Testlab Registration

  Scenario Outline: Register new user
    Given unregistered user is on the Hotel Testlab website
    When user clicks Sign In button
    When user inputs random email address in Create An Account section
    And clicks Create an account button
    When user fills "<firstName>", "<lastName>", "<password>" and user clicks Register button
    Then Your account has been created. message is displayed.

    Examples:
    |firstName  |lastName |password |
    |John       |Doe      |qwerty   |