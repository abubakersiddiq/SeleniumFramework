Feature: create a create change request

Scenario: create a new indicent

Given the base URI 
And set basic authentication
And add body from change.json
When post the request
Then status code should be 201  