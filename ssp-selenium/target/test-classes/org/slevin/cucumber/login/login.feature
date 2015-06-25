Feature: Login on ssp-web
  As an user
  I want to login

  Scenario: login page
    Given the email "admin" and password "admin"
    When I click on login
    Then I will be on welcome page