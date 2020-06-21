Feature: Get issue from the jira 

Scenario: Get all The issue from the Jira

Given base uri for jira
And send userAuth 
And get all the request issue type from jira
Then verify the status code is 200



Scenario: Create New Issue in jira

Given base uri for jira
And send userAuth 
When create a new issue in jira using jsonFile
And get the id number
Then verify the status code is 201


Scenario: Get specfic issue from the Jira

Given base uri for jira
And send userAuth 
And get specific issue with issueNo
Then verify the status code is 200


  

