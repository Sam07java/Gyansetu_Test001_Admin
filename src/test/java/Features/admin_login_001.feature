Feature: Check whether admin login page is working.
  Scenario: Test the login page of Admin User.

    Given Navigate to Login Page
    When Enter the admin credential on Username field and password
    Then Validate Dashborad is displayed
