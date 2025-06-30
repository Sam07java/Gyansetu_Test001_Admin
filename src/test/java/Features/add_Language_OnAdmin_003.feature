Feature: Add Language and Hobby on Admin panel

  Background:
    Given Login to the Admin Panel.
    When Validate DashBoard is displayed Successfully.
    Then Click on Master Management in sidebar.

  Scenario: Add Language.
    Given Click on Language Button.
 #   When Enter Language on textfield "<Language>".
    When Enter language on textfield.
      | French        |
      | Arabic Second |
      | Tulu          |
      | Sanskrit      |
      | Malayalam     |
      | Punjabi       |
      | Telugu        |
      | English       |
      | Tamil         |
      | Marathi       |
      | Hindi         |
      | Urudhu        |
   # Then Verify the toaster message is displayed.
    Then LogOut Admin Page

#    Examples:
#      | Language      |
#      | FrenFirst     |
#      | Arabic Second |
#      | Tulu          |
#      | Sanskrit     |

  Scenario: Add Hobby
    Given Click on Hobby Button.
    And Click on ADD HOBBIES Button.
    When Enter hobbys on text field.
      | Carom     |
      | Chess      |
      | Cricket    |
      | Drawing    |
      | Dancing    |
      | Reading    |
      | Travelling |
      | Singing    |
      | Running    |
      | Swimming   |
      | cooking    |
    And Click on Save button on Hobbies.
    Then LogOut Admin Page