
Feature: Sort Product List Feature

  @appium
  Scenario: To verify non login user should be able to sort the product list
    Given Launch the application
    Then Verify Home Screen
    Then Verify Select Location button is displayed
    When Tap on Select Location button
    Then Verify Location text field is diplayed
    When Fill the location text field
    Then Verify location suggestions are displayed
    When Select one of location suggestions
    Then Verify Confirmation overlay is diplayed
    When Select Yes button
    Then Verify the location is selected
    And Verify Nearby Supermarket List is displayed
