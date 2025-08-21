Feature: Add necessary data for College User
  Background: User is Logged in as Admin.
    Given Login to the Admin Panel.
    When Validate DashBoard is displayed Successfully.
    And Click on Master Management in sidebar.

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
#      | University | 4         |
#      | University | 2         |
#      | University | 3         |

#Scenario Outline: Add institute under university by excel sheet
#  Given Click on Institution in sidebar.
#  And Click on Institute in sidebar for add institute data.
#  And Check whether list of Institute Page is displayed or not.
#  And Click on ADD INSTITUTE Button.
#  When Check add institute page is displayed or not.
#  And Fetch the data from excel sheet for add institute data "<Sheet NAme>" , <RowNO>
#  And Click on Save button institution.
#  And Verify the toaster message is displayed or not.
# Then LogOut Admin Page
#  Examples:
#    | Sheet NAme       | RowNO |
#    | InstituteCollage | 3     |
#
#  Scenario Outline: Add Course under institute by excel sheet
#   Given Click on Institution in sidebar.
#   And Click on Course button in sidebar.
#   And Verify the Course page list is displayed.
#   When Click on ADD COURSE button
#   And Verify the Add Course page is displayed.
#   And Fetch the data from excel sheet add course "<SheetName>" <RowNUmber>
#   And Click on Save Button in Add Course page.
#   And Validate the Course added successfully by toaster message.
#   Then LogOut Admin Page
#   Examples:
#     | SheetName | RowNUmber |
#     | Course    | 0         |
#     | Course    | 1         |
#     | Course    | 2         |
#     | Course    | 3         |

#  Scenario Outline: Add Subject under institute by excel sheet
#  Given Click on Institution in sidebar.
#  And Click on Subject Button in sidebar.
#  And Verify list of Subject page is shown.
#  When Click on ADD SUBJECT button
#  And Verify the add subject page is displayed.
#  And Fetch data from excel sheet add subject "<SheetName>" <RowNumber>
#  And Click on Save Button in Subject Page.
#  And Validate the Subject added successfully by toaster message.
#  Then LogOut Admin Page
#  Examples:
#    | SheetName           | RowNumber |
#    | Subject for College | 1         |
#    | Subject for College | 2         |
#    | Subject for College | 3         |
#    | Subject for College | 4         |
#    | Subject for College | 5         |
#    | Subject for College | 6         |
#    | Subject for College | 7         |
#    | Subject for College | 8         |
#    | Subject for College | 9         |
#    | Subject for College | 10        |
#    | Subject for College | 11        |
#    | Subject for College | 12        |
#    | Subject for College | 13        |
#    | Subject for College | 14         |
#    | Subject for College | 38         |
#    | Subject for College | 23        |




    Scenario Outline: Add Teacher under College institute
      Given Click on Teacher button in sidebar
      When Verify teacher list page displayed or not
      And Click on Add Teacher button
      And Enter the details on add teacher page by fetch data from Excel sheet "<SheetNem>" <RowNumbr>
      And Click on Save button in Add teacher page.
      And verify the teacher added successfull or not
      Then LogOut Admin Page
      Examples:
        | SheetNem            | RowNumbr |
#        | Teacher for College | 1        |
        | Teacher for College | 2        |


