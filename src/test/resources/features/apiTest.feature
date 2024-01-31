Feature: Checking api test

  #Scenario: Test the get request
   # Given I hit the rest public api
   # Then I received the status code 200

  Scenario: Test the post request
    Given I hit the post rest public api with 5671256,"test123", "test123@gmail.com", "male", "active"
    Then I received the status code 201