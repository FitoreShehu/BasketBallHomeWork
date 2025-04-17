Feature: Create an account on the basketball page.

  Scenario: Verify that account is created successful
    Given User is using "Edge" as a web-browser.
    Given User is on the register-page "https://membership.basketballengland.co.uk/NewSupporterAccount"
    When User writes the date of birth "20/09/1999"
    And User writes the name "Linna "
    And User writes the lastname "Persson"
    * User writes the email "Linnaaa.perssonn@test.com"
    * User writes the confirm email  "Linnaaa.perssonn@test.com"
    * User write the password "Testpassword123."
    And User write the retype password "Testpassword123."
    Then User choose the role Fan in basketball
    And User is on the account confirmation and accepts the Terms and Conditions
    And User accepts that they are an adult
    Then User is on the communication preferences and accepts the first checkbox
    And User accepts the checkbox for agreeing to the Basketball England Code of Ethics and Conduct
    And User clicks the red button to submit
    Then Account creation is confirmed successfully

  Scenario: Verify all errors during account registration
    Given User is using "Chrome" as a web-browser.
    Given User is on the register-page "https://membership.basketballengland.co.uk/NewSupporterAccount"
    When User writes the date of birth "20/09/1999"
    And User writes the name "Test"
    And User forget to write the lastname
    * User writes the email "testtest123@test.com"
    * User does not enter the confirm email
    * User write the password "Testtest456"
    And  User does not write the retype password
    Then User choose the role Fan in basketball
    And User is on the account confirmation and declines the Terms and Conditions
    And User does not accepts that they are an adult
    Then User is on the communication preferences and accepts the first checkbox
    And User does not accepts the checkbox for agreeing to the Basketball England Code of Ethics and Conduct
    When User clicks the red button to submit
    Then User get all the error message displayed
      | Last Name is required                                                        |
      | Confirm Email Address does not match                                         |
      | Confirm Password is required                                                 |
      | You must confirm that you have read and accepted our Terms and Conditions    |
      | You must confirm that you are over 18 or a person with parental responsibility |
      | You must confirm that you have read, understood and agree to the Code of Ethics and Conduct |


  Scenario Outline: Verify errors during account registration
    Given User is using "<browser>" as a web-browser.
    Given User is on the register-page "https://membership.basketballengland.co.uk/NewSupporterAccount"
    When User writes the date of birth "<date of birth>"
    And User writes the name "<name>"
    And User writes the lastname "<lastname>"
    * User writes the email "<email>"
    * User writes the confirm email  "<confirm email address>"
    * User write the password "<password>"
    And User write the retype password "<retype password>"
    Then User choose the role Fan in basketball
    And User is on the account confirmation and <terms> the Terms and Conditions
    And User accepts that they are an adult
    Then User is on the communication preferences and accepts the first checkbox
    And User accepts the checkbox for agreeing to the Basketball England Code of Ethics and Conduct
    When User clicks the red button to submit
    Then User get the error message "<error message>"

    Examples:
      | browser | date of birth | name    | lastname | email                 | confirm email address | password   | retype password | terms    | error message                                                             |
      | Chrome  | 20/09/1999    | Per     |          | Nicklas.test@test.com | Nicklas.test@test.com | Blabla123! | Blabla123!      | accepts  | Last Name is required                                                     |
      | Edge    | 20/09/1999    | Staffan | Persson  | Staffan.test@test.com | Different@test.com    | Blabla123! | Blabla123!      | accepts  | Confirm Email Address does not match                                      |
      | Chrome  | 20/09/1999    | Olof    | Persson  | Olof.test@test.com    | Olof.test@test.com    | Blabla123! | WrongPassword!  | accepts  | Password did not match                                                    |
      | Edge    | 20/09/1999    | Thor    | Persson  | Thor.test@test.com    | Thor.test@test.com    | Blabla123! | Blabla123!      | declines | You must confirm that you have read and accepted our Terms and Conditions |










