Feature: Homepage 
  As a user
  I want to visit the homepage
  So that I can access the various features on offer
 
  Scenario: Visit Homepage
    Given I am on the homepage
    Then muss es eine Überschrift geben benannt: "Bücherregal - Liste aller Bücher"
    And I should see a "login" link
    Then I should not see a "register" link