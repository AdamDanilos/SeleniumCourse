Feature: Bing search

  Scenario: user can search any keyword
    Given an open browser with bing.com
    When a keyword selenium is entered in input field and clicks search button
    Then the first result should contain selenium
    And close browser