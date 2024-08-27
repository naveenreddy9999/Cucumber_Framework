@HomePage
Feature: End to End Banking Home page scenarios

  @LogIn
  Scenario Outline: Verify and Validate Username and Password fields

    Given User logon the application
    When User click on the "Home" button
#    And User navigating to practice page
#    Then validate each and every heading
##    Then Validate radio buttons
#    And User enter text on text box
#      | Text   |
#      | naveen |
#      | reddy  |
#      | <Text> |
#    Then User handleTab
#    And User validated total countries of the table
#    And User validate total amount
    Examples:
      | Text   |
      | naveen |

