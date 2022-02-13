Feature: Hotel Testlab Registration

  Scenario: Register new user
    Given unregistered user is on the Hotel Testlab website
    When user clicks Sign In button
    When user inputs email address in Create An Account section
    And clicks Create an account button
    When user fills First name, Last name, Password and user clicks Register button
    Then Your account has been created. message is displayed.