Feature: Loin page scenarios

Scenario Outline: Admin addes new employee
Given User on login page
When User enters valid username and password
Then User navigates to dashboard page
Then Admin adds a new empoyee with "<firstname>" and "<lastname>"


Examples: 
| firstname | lastname |
| emp1 | emp1 |
| emp2 | emp2 |

Scenario: Login with valid credentials
Given User on login page
When User enters valid username and password
Then User navigates to dashboard page

Scenario: Add and delete admin user
Given User on login page
When User enters valid username and password
Then User navigates to dashboard page
When User add new Admin
Then User gets added to the list
And User deletes the new Admin
Then user gets deleted from list




