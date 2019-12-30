Feature: wikipedia search feature

  Scenario: search for existing term
    Given user is on main wiki page
    When user search for Selenium
    Then result page is displayed