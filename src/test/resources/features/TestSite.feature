Feature: tapQA HomePage Navigation Menu

  Scenario: Solutions Menu Check tapStrategy Link
    Given I am navigating to tapQA HomePage
    When I hover over the Solutions tab
    And I click on search
    Then I should see my site in the results

#  Scenario: Check another search
#    Given I am navigating to Google
#    When I enter my websites name
#    And I click on search
#    Then I should see my new sites listed