Feature: tapQA HomePage Navigation Menu

  Scenario: Solutions Menu Check tapStrategy Link
    Given I am navigating to tapQA HomePage
    When I hover over the Solutions tab
    Then I verify that the "tap|STRATEGY" menu is displayed

  Scenario Outline: Solutions Menu Verify all Sub Menu's appear properly
    Given I am navigating to tapQA HomePage
    When I hover over the Solutions tab
    Then I verify that <SubMenu> menu is displayed at <id> webElement

    Examples:
    | SubMenu           | id            |
    | "tap\|STRATEGY"   | "STRATEGY"    |
    | "tap\|AUTOMATION" | "AUTOMATION"  |
    | "tap\|CONSULTING" | "CONSULTING"  |
    | "tap\|LAKESHORE"  | "LAKESHORE"   |