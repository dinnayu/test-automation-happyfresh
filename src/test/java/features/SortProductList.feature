
Feature: Sort Product List Feature

  @appium
  Scenario: To verify non login user should be able to sort the product list
    Given Launch the application
    Then Verify Home Screen
    Then Verify Select Location button is displayed
    When Tap on Select Location button and allow permission
    Then Verify Location text field is diplayed
    When Fill the location text field
    Then Verify location suggestions are displayed
    Then Verify Confirmation overlay is diplayed
    When Select Yes button
    Then Verify the location is selected
    And Verify Nearby Supermarket List is displayed
    When Select one of Supermarket List
    Then Dismiss poster
    And Verify Category list
    When Select one of Category List
    Then Verify Product List is displayed
    When Select Sort button
    Then Verify Sort options is displayed
    When Select one of sort option eg. the lowest price
    Then Verify product list is sorted by selected sort option
    
    
    @appium
    Scenario: To verify login user should be able to sort the product list
    Given Launch the application
    Then Verify Home Screen
    Then Verify User Info menu with chevron is displayed
    When Tap on User Info menu with chevron
    Then Verify Login button is disyplayed
    When Tap on Login button
    Then Verify Login screen
    Then Fill all mandatory field in Login screen with valid credentials
    When Tap on Sign In button
    Then Verify that user success to login with registered account
    And Verify Select Location button is displayed
    When Tap on Select Location button and allow permission
    Then Verify Location text field is diplayed
    When Fill the location text field
    Then Verify location suggestions are displayed
    Then Verify Confirmation overlay is diplayed
    When Select Yes button
    Then Verify the location is selected
    And Verify Nearby Supermarket List is displayed
    When Select one of Supermarket List
    Then Dismiss poster
    And Verify Category list
    When Select one of Category List
    Then Verify Product List is displayed
    When Select Sort button
    Then Verify Sort options is displayed
    When Select one of sort option eg. the lowest price
    Then Verify product list is sorted by selected sort option
