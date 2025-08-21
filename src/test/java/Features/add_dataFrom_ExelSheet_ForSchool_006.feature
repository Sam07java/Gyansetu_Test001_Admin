Feature: Add all necessary data from Excel

  Background: User is Logged in as Admin.
    Given Login to the Admin Panel.
    When Validate DashBoard is displayed Successfully.
    And Click on Master Management in sidebar.

  Scenario: Add classes from admin panel.
    Given Click on class button in sidebar.
    And Click on Add Class button.
    When Select class from dropdown.
      | class 01 |
      | class 02 |
      | class 03 |
      | class 04 |
      | class 05 |
      | class 06 |
      | class 07 |
      | class 08 |
      | class 09 |
      | class 10 |
      | class 11 |
      | class 12 |
    When Click on Save button in class page.
    And Verify the toaster message is displayed or not in Add class page.
    Then LogOut Admin Page

  Scenario Outline: Add School, fetch data from excel sheet.
        Given Click on Institution in sidebar.
        And Click on Institute in sidebar for add institute data.
        And Check whether list of Institute Page is displayed or not.
        And Click on ADD INSTITUTE Button.
        When Check add institute page is displayed or not.
        And Select Entity from dropdown for School.
        And Fetch data from excel sheet, Enter the dtails on text field "<SheetName>" and <RowNo>
       And Click on Save button institution.
        And Verify the toaster message is displayed or not.
        Then LogOut Admin Page
      Examples:
        | SheetName | RowNo |
        | School    | 0     |
#        | School    | 4     |
        | School    | 4     |

  Scenario Outline: Add Subject class wise.
      Given Click on Institution in sidebar.
      Then Click on Subject Button in sidebar.
      And Verify list of Subject page is shown.
#      And Click on School Button for add subject.
      When Click on School Button for add subject.
      And Click on ADD SUBJECT button
      And Fetch data from excel sheet for select class and enter the Subject "<SheetName>" <classNo>.
      And Click on Save Button in Subject Page.
      Then LogOut Admin Page
      Examples:
        | SheetName         | classNo |
##        | Subject for Class | 1       |
##        | Subject for Class | 2       |
###        | Subject for Class | 3       |
#        | Subject for Class | 4       |
        | Subject for Class | 5       |
        | Subject for Class | 6       |
        | Subject for Class | 7       |
        | Subject for Class | 8       |
        | Subject for Class | 9       |
        | Subject for Class | 10      |

  Scenario Outline: Add Teacher via Excel Sheet
    Given Click on Teacher button in sidebar
    When Verify teacher list page displayed or not
    And Click on Add Teacher button
    And Enter details on add teacher page by Excel Sheet "<SheetNAme>", <RowNumber>
    And Click on Save button in Add teacher page.
    And verify the teacher added successfull or not
    Then LogOut Admin Page
    Examples: 2
      | SheetNAme          | RowNumber |
      | Teacher for School | 0         |
      | Teacher for School | 1         |
      | Teacher for School | 2         |
      | Teacher for School | 3         |