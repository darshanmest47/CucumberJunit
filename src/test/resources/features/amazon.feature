Feature: Amazon login feature

  Scenario Outline: Opening amazon and entering login credentials
    Given I have already opened amazon
    When I enter username "<sheetName>"
    And I click on continue button
    And  I enter password "<sheetName>"
    And I click on submit button
    And I click on cart icon
    Then I should be navigated to cart page "<sheetName>"

    Examples:
      | sheetName |
      | Sheet1    |