@todayTixFront
Feature: Task validation across front end
Scenario: Validating elements in the page across purchase flow

Given I open today tix home page
When  I select location and search one show
And   I try to get tickets for desired date
Then  I fill out the information and click the credit card method
