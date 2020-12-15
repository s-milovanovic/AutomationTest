Feature: Application Login

Scenario: User login to unibet.com site
Given User opens "https://www.unibet.com/" site
When User enters the following username and password
| john.doe.igame@gmail.com | igame123! |
And Clicks on login submit button
Then Verify user is successfully logged in "true" and "john doe" is visible

Scenario: User didn't login to unibet.com site
Given User opens "https://www.unibet.com/" site
When User enters the following username and password
| srdjan                   |pass       |
And Clicks on login submit button
Then Verify user is successfully logged in "false" and "You have entered an incorrect email or password" is visible

