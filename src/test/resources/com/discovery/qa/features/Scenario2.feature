Feature:  Scroll down to Popular Shows, go to last video, click Explore the shows, click show twice and write shows title with duration in a file

Scenario: Verify Shows titles and duration of popular Shows 
	Given I am on Discovery Home Page 
	And verify Popular Shows 
	And go to last video and click explore the show 
	Then click on Show More twice and verify title with durations 

 