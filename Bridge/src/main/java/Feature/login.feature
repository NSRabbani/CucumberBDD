Feature: Login page

Scenario: Login with valid credentials

Given User launches OHRM URL
When User provide valid credentials
Then Application navigates to home page successfully

Scenario: Login with Invalid password

Given User launches OHRM URL
When User provide invalid credentials
Then Application displays error message
