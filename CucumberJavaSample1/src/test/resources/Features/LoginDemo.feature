Feature: Test login functionality

  Scenario: Check login is successful with valid credentials
    Given browser is open
    And user is on login page
    When user enters "indhumathi" and "12345"
    And user clicks on login
    Then user is navigated to the home page

  Scenario Outline: testing with examples data driven
    Given browser is open
    And user is on login page
    When user enters "<username>" and "<password>"
    And user clicks on login
    Then user is navigated to the home page
    
    Examples:
    |username|password|
    |Rajappa|12345|
