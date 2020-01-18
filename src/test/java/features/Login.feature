
Feature: Login feature

  @appium
  Scenario: To verify user should be able to login with registered account
    Given Launch the application
    Then Verify Home Screen
    When Tap on Hamburger Menu
    Then Verify User Info menu with chevron is displayed
    When Tap on User Info menu with chevron
    Then Verify Login button is disyplayed
    When Tap on Login button
    Then Verify Login screen
    Then Fill all mandatory field in Login screen with valid credentials
    When Tap on Sign In button
    Then Verify that user success to login with registered account
