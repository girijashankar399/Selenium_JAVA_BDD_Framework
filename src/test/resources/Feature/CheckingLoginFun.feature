Feature: Login Functionality

Scenario: Successful login with valid credentials
  Given the user is on the login page
  When the user enters "student" as the username
  And the user enters "Password123" as the password
  And the user clicks the submit button
  Then the user should be redirected to the homepage
  
@smoke    
Scenario: Login attempt with incorrect password
  Given the user is on the login page
  When the user enters "student" as the username
  And the user enters "WrongPassword" as the password
  And the user clicks the submit button
  Then an error message should be displayed saying "Your password is invalid!"
  
@smoke
Scenario: Login attempt with incorrect username
    Given the user is on the login page
    When the user enters "wrongUser" as the username
    And the user enters "Password123" as the password
    And the user clicks the submit button
    Then an error message should be displayed saying "Your username is invalid!"
    
    

 Scenario: Login attempt with empty username and password
    Given the user is on the login page
    When the user leaves the username field empty
    And the user leaves the password field empty
    And the user clicks the submit button
    Then an error message should be displayed saying "Your username is invalid!"
    