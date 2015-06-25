Feature: Navigation on ssp-web
  As an user
  I want to navigate on accounts pages

  Scenario: Navigate to all accounts
    Given the email "admin" and password "admin"
    When I click on login
    Then I will be on welcome page
    Given I click on accounts menu
    When I click on all accounts link
    Then I will be on all accounts page

  Scenario: Navigate to new account
    Given the email "admin" and password "admin"
    When I click on login
    Then I will be on welcome page
    Given I click on accounts menu
    When I click on new account link
    Then I will be on new account page