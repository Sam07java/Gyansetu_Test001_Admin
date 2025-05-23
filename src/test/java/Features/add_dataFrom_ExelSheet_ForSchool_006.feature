Feature: Add all necessary data from Excel
#  Scenario Outline: Add University from Execl Sheet
#    Given Click on University in sidebar for add University data.
#    When Check whether list of University Page is displayed or not.
#    And Click on add University Button.
#    And Fetch data from excel sheet, Enter the university Name on the text field "<Shortname>" and <RowNumber>
#    And Click Save button
#    And Verify with toaster message whether University is added or not.
#    Then LogOut Admin Page
#    Examples:
#      | Shortname  | RowNumber |
#      | University | 1         |
#      | University | 2         |
#      | University | 3         |

  Background: User is Logged in as Admin.
    Given Login to the Admin Panel.
    When Validate DashBoard is displayed Successfully.
    And Click on Master Management in sidebar.


#  Scenario: Add classes from admin panel.
#    Given Click on class button in sidebar.
#    And Click on Add Class button.
#    When Select class from dropdown.
#      | class 01 |
#      | class 02 |
#      | class 03 |
#      | class 04 |
#      | class 05 |
#      | class 06 |
#      | class 07 |
#      | class 08 |
#      | class 09 |
#      | class 10 |
##    When Click on Save button in class page.
#    And Verify the toaster message is displayed or not in Add class page.
#    Then LogOut Admin Page


#     | class 11 |
#  | class 12 |
#  |          |


#  Scenario Outline: Add School, fetch data from excel sheet.
#        Given Click on Institution in sidebar.
#        And Click on Institute in sidebar for add institute data.
#        And Check whether list of Institute Page is displayed or not.
#        And Click on ADD INSTITUTE Button.
#        When Check add institute page is displayed or not.
#        And Select Entity from dropdown for School.
#        And Fetch data from excel sheet, Enter the dtails on text field "<SheetName>" and <RowNo>
#    #  And I enter institute details "<Institute>", "<Address>", "<Email>", "9786754330", "Tesla", "3 Streat", "976543", "balliol@gmail.com"
#        And Click on Save button institution.
#        And Verify the toaster message is displayed or not.
#        Then LogOut Admin Page
#      Examples:
#        | SheetName | RowNo |
#        | School    | 1     |
#        | School    | 2     |

    Scenario Outline: Add Subject class wise.
      Given Click on Institution in sidebar.
      Then Click on Subject Button in sidebar.
      And Verify list of Subject page is shown.
      And Click on School Button for add subject.
      When Click on School Button for add subject.
      And Click on ADD SUBJECT button
      And Fetch data from excel sheet for select class and enter the Subject "<SheetName>" <RowNumber>.
#      And Click on Class Dropdown select one of them by "<Class>"
#      And Enter the Subject Name "<Subject>".
      And Click on Save Button in Subject Page.
#      And Validate the Subject added successfully by toaster message.
      Then LogOut Admin Page

      Examples:
        | SheetName         | RowNumber |
        | Subject for Class | 1         |
       | Subject for Class | 2         |