Feature:  Favorite shows functionality

Scenario: See All Shows in shows category on Home Page
Given I am on Discovery Home Page 
And Verify the Home Page title
And Verify the Home Page elements
And Navigate to shows category 
Then click on See All Shows option


Scenario: Verify Favorites functionality
Given click on Search icon 
And I enter show name in search text box
And select the first show from the list
And verify the favorite status
And change the favourites status
#And store favorites to the list
And navigate to my videos

 