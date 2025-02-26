Feature: new player registration
 
  Scenario: Register a new player
    Given I have launched the website 
     When I click on register 
     Then I shall be navigated to registration page
     When I enter new user details as below
    
   		 |Email				|Nickname	|Password		|DateOfBirth|
   		 |Ritika@gmail.com|Ritika			|abcd_12345	|2000-02-24	|
   		 
     And confirmed recpatcha and accepted terms and conditions 
     And click on begin adventure button
     Then I shall be registered successfully
     And "Confirm your e-mail address" message shall be displayed
     And "Your Welcome Bonus is waiting for you: 30,000 Twists & 15 Free Spins for Book of Ra™ deluxe!" message shall be displayed
     And email textbox and resend email button shall be displayed




