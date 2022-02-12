#Author: symun.moyeen@gmail.com
@HomePageTest
Feature: EBFS Homepage

  @SmokeTest
  Scenario: EBFS homepage title verification
    Given user goes to the EBFS website
    Then verify the homepage title

  @SmokeTest
  Scenario: EBFS homepage Logo verification
    Given user goes to the EBFS website
    And verify the Logo
