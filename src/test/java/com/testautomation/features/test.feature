Feature: wikipedia search feature

  Scenario: search for existing term in wikipage
    Given user is on main wiki page
    When user search for Selen
    Then Selen result page is displayed