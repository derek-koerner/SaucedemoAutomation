Feature: Login to user account and load home page in browser.

    Scenario: User logs in with correct username and password is directed to home page
        Given User is on the landing page
        When User enters a username "standard_user"
        And User enters the password "secret_sauce"
        And User selects the login button
        Then User is logged in and directed to the homepage

    Scenario: User logs in with correct username and no password is presented an error
        Given User is on the landing page
        When User enters a username "standard_user"
        And User selects the login button
        Then User is presented "password required" error message

    Scenario: User logs in with correct username and incorrect password is presented an error
        Given User is on the landing page
        When User enters a username "standard_user"
        And User enters the password "1234"
        And User selects the login button
        Then User is presented "no matching user" error message

    Scenario: User logs in with no username or password is presented an error
        Given User is on the landing page
        When User selects the login button
        Then User is presented "username required" error message