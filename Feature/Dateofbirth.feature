
Feature: DOB selection
	
  Scenario: User navigating to GoHealth Urgent Care Automation test application
    Given User navigates to GoHealth Urgent Care Automation test application
   Then User should be able to view DOB and User input fields
    And Click on the dropdown for the month
    Then User should be able to see all the months in a year
    And Click on the dropdown for the date
    Then User should be able to see all the dates for the selected month
    And Click on the dropdown for the year
    Then User should be able to see all the years
    Then User closes the application
	
  
   Scenario Outline: User navigating to GoHealth Urgent Care Automation test application
    Given User navigates to GoHealth Urgent Care Automation test application
   Then User selects a "<month>","<date>" and "<year>" from dropdown and validates user input field
   Then User closes the application
   Examples:
   | month | date | year |
   | Jan   | 1    | 1975 |
   | Mar   | 21   | 1994 |
   | Feb   | 28   | 2018 |
   | Dec   | 35   | 1918 |
    