
Feature: Register feature

  @appium
  Scenario: To verify user should be able to register a new account
    Given Launch the application
    Then Verify Home Screen
    When Tap on Hamburger Menu
    Then Verify User Info menu with chevron is displayed
    When Tap on User Info menu with chevron
    Then Verify Register button is displayed
    When Tap on Register button
    Then Verify Register screen
    Then Fill all mandatory field with valid credentials
    When Tap on Next button
    Then Verify that user success to register a new account
    
