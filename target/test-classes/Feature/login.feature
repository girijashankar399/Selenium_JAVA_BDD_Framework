Feature: login Page Automation
Scenario: Check login with Valid credentials
Given User is on Login Page
When User enter correct username and pwd
And click on login button
Then user is navigate to HomePage



