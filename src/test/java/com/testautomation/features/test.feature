Feature: google

  Scenario: google check
    Given go to wikipedia
    When click on source
    Then source header is displayed