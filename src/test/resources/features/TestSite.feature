Feature: Searching for a site on Google

  Scenario: Successful Search
    Given I am navigating to Google
    When I enter my websites name
    And I click on search
    Then I should see my site in the results

  Scenario: Check another search
    Given I am navigating to Google
    When I enter my websites name
    And I click on search
    Then I should see my new sites listed