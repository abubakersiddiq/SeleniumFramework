Feature: Get issue from the jira 

Scenario: Get all The issue from the Jira

Given base uri for jira
And send userAuth 
And get all the request issue type from jira
Then verify the status code is 201 