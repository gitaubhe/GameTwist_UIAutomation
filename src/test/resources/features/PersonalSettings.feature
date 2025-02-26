Feature: Personal settings
  I want to change personal settings 

  Scenario: Player shall be able to change personal settings
    Given I have launched the website 
     When I click on login button
      And logged in with username as "Ritika64" and password as "abcde_1234"
     When I click on player name on top right corner
     Then menu shall be displayed
     When I click on  personal data button 
     Then personal data section shall be displayed
     When I click on change security button
     Then change security questions form shall be displayed
     When change the security question "What was your first pet's name?" and save the changes
     Then security question changes saved successfully message shall be displayed 
     When move to the document table and click on change button in newsletter row 
      And change newsletter settings form shall be displayed
      And change to get latest news and click on confirm button
      And open the change newsletter settings form
     Then changed option shall be displayed as selected
     When I click on player name on top right corner 
      And click on logout button
     Then user shall be successfully logged out
    