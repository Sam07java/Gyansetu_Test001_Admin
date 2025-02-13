Feature: Add Language and Hobby on Admin panel

  Background:
    Given Login to the Admin Panel.
    When Validate DashBoard is displayed Successfully.
    And Click on Master Management in sidebar.
   # Then Click on Language Button.

  Scenario: Add Language.
    Given Click on Language Button.
 #   When Enter Language on textfield "<Language>".
    When Enter language on textfield.
      | French        |
      | Arabic Second |
      | Tulu          |
      | Sanskrit      |
      | Malayalam     |
    Then Verify the toaster message is displayed.
    Then LogOut Admin Page

#    Examples:
#      | Language      |
#      | FrenFirst     |
#      | Arabic Second |
#      | Tulu          |
#      | Sanskrit     |