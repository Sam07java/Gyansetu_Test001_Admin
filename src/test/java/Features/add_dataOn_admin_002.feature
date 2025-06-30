Feature: Add necessary data on admin panel-->>University, Institute, Course, Semester, Classes

  Background: User is Logged in as Admin.
    Given Login to the Admin Panel.
    When Validate DashBoard is displayed Successfully.
    And Click on Master Management in sidebar.
    Then Click on Institution in sidebar.

  Scenario Outline: Add data -->> University
    Given Click on University in sidebar for add University data.
    When Check whether list of University Page is displayed or not.
    And Click on add University Button.
  #  And Enter the University Name "<University>" on the text field.
    And Enter the University Name on text field and Click Save Button.
      | Indian Institutes of Technology (IITs) |
      | University of Delhi (DU)               |
      | Jawaharlal Nehru University (JNU)      |
  #  And Click on Save button.
    And Verify the toaster message with added successfully or not
    Then LogOut Admin Page
    Examples:
      | University                             |
      | Indian Institutes of Technology (IITs) |
      | University of Delhi (DU)               |
      | Jawaharlal Nehru University (JNU)      |

  Scenario Outline: Add University from Execl Sheet
    Given Click on University in sidebar for add University data.
    When Check whether list of University Page is displayed or not.
    And Click on add University Button.
    And Fetch data from excel sheet, Enter the university Name on the text field "<Shortname>" and <RowNumber>
    And Click Save button
    And Verify with toaster message whether University is added or not.
    Then LogOut Admin Page
    Examples:
      | Shortname  | RowNumber |
      | University | 1         |
      | University | 2         |
      | University | 3         |

    Scenario Outline: Add data-->>Institute
        Given Click on Institute in sidebar for add institute data.
        And Check whether list of Institute Page is displayed or not.
        And Click on ADD INSTITUTE Button.
        When Check add institute page is displayed or not.
        And Select Entity from dropdown.
        And Select University from dropdown "<University>".
        And Select Country from dropdown "India".
        And Select State from dropdown "Kerala".
        And Enter name on Institute text field "<Institute>".
        And Enter the address on text field "<Address>".
        And Enter the Email id on text field "<Email>".
        And Enter the mobile number on text field "<Phone>".
        And Enter the City Name on the text field "Tesla".
        And Enter the District Name on the text field "3 Streat".
        And Enter the Pincode Number on the text field "976543".
        And Enter the Website on the text field "balliol@gmail.com".
    #  And I enter institute details "<Institute>", "<Address>", "<Email>", "9786754330", "Tesla", "3 Streat", "976543", "balliol@gmail.com"
        And Click on Save button institution.
        And Verify the toaster message is displayed or not.
        Then LogOut Admin Page
        Examples:
          | University                             | Institute       | Address | Email              | Phone      |
          | Indian Institutes of Technology (IITs) | IIT Goliath     | Bombay  | iitkol10@gmail.com | 9887866630 |
          | Indian Institutes of Technology (IITs) | Faculty of Arts | Delhi   | exeter10@gmail.com | 9887866603 |
        #  | University of Delhi (DU)               | Faculty of Arts       | Delhi     | du1211@gmail.com   | 9887866613 |
         # | University of Delhi (DU)               | St. Stephen's College | Ahmedabad | stephen1@gmail.com | 9887866614 |

  Scenario Outline: Add Course data on Admin panel
    Given Click on Course button in sidebar.
    And Verify the Course page list is displayed.
    When Click on ADD COURSE button
    And Verify the Add Course page is displayed.
    And Click on the Institute DropDown and Select one of them by "<Institute>"
    And Enter Course Name on the text field "<Course>".
    And Select Duration from DropDown "<Duration>".
    And Click on Save Button in Add Course page.
    And Validate the Course added successfully by toaster message.
    Then LogOut Admin Page
    Examples:0
      | Institute       | Course       | Duration |
      | Faculty of Arts | Physics      | 3        |
      | Faculty of Arts | Mechatronics | 3        |
      | IIT Goliath     | ECE          | 4        |
#      | IIT Bombay      | EEE                   | 4        |
#      | IIT Delhi       | ECE                   | 4        |
#      | IIT Delhi       | EEE                   | 4        |
#      | Faculty of Arts | Department of English | 3        |
#      | Faculty of Arts | Department of History | 3        |
#      | Faculty of Arts | Department of Geology | 3        |
#
#
  Scenario Outline: Add Subject on Admin panel-->>College User.
  Given Click on Subject Button in sidebar.
  And Verify list of Subject page is shown.
  When Click on ADD SUBJECT button
  And Verify the add subject page is displayed.
  And Click on institute dropdown and select one of them by "<Institute>".
  And Click on course dropdown and select one of them by "<Course>".
  And Select the Semester from dropdown "<Semester>".
  And Enter the Subject Name "<Subject>".
  And Click on Save Button in Subject Page.
  And Validate the Subject added successfully by toaster message.
  Then LogOut Admin Page
  Examples:
    | Institute       | Course       | Semester   | Subject           |
    | Faculty of Arts | Physics      | Semester 1 | Basic Electronics |
    | Faculty of Arts | Mechatronics | Semester 1 | Mathematics First |
    | IIT Goliath     | ECE          | Semester 1 | Physics           |
 #   | IIT Bombay      | EEE          | Semester 1 | Basic Electronics |
#    | IIT Bombay | EEE    | Semester 1 | Mathematics First |
#    | IIT Bombay | EEE    | Semester 1 | Physics           |
#    | IIT Bombay | EEE    | Semester 1 | Basic Electrical  |
#    | IIT Bombay | ECE    | Semester 2 | DSP               |
#    | IIT Bombay | ECE    | Semester 2 | Communication     |
#    | IIT Bombay | ECE    | Semester 2 | Digital Signal    |
##
    Scenario Outline: Add Subject for School User.
#      Given Login to the Admin Panel.
#      When Validate DashBoard is displayed Successfully.
#      And Click on Master Management in sidebar.
#      And Click on Institution in sidebar.
      Given Click on Subject Button in sidebar.
      And Verify list of Subject page is shown.
      When Click on School Button for add subject.
      And Click on ADD SUBJECT button
      And Click on Class Dropdown select one of them by "<Class>"
      And Enter the Subject Name "<Subject>".
      And Click on Save Button in Subject Page.
      And Validate the Subject added successfully by toaster message.
      Then LogOut Admin Page
      Examples:
        | Class    | Subject   |
        | class 03 | Malayalam |
        | class 04 | Hindi     |



