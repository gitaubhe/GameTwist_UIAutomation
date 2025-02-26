Feature: User log in 
  I want to login to the application

  Scenario: User shall be able to login 
    Given I have launched the website 
   	 When I click on login button
   	 Then log in form shall be displayed
   	 When user enters username as "Ritika64" and password as "abcde_1234" and log in
     Then user shall be logged in successfully 


	 
