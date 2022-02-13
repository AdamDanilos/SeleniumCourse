Feature: Bing search

  Scenario Outline: user can search any keyword
    Given an open browser with bing.com
    When a keyword "<keyword>" is entered in input field and clicks search button
    Then the first result should contain "<argument2>"
    And close browser

    Examples:
    |keyword  |argument2  |
    |WebDriver|aaa        |
    |selenium |bb         |
    |Cypress  |ccc        |