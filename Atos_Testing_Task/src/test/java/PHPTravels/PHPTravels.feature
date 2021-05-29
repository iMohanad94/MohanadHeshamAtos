Feature: PHP Travel Register and Login
  @Type=Functional
  @Severity=blocker
  @PHPTravelsRegister
  Scenario Outline: User Types data for registration
    Given User Types "<FirstName>" in First Name Section
    When User Types "<LastName>" in Last Name Section
    And User Types Phone Number
    And User Types Gmail in Email Section
    And User Types Password
    And User Types Confirmation Password
    And User Clicks Submit
    Then User Gets Confirmation Email
    Examples:
      |FirstName| | LastName|
      |Mohannad | | Hesham  |

    @PHPTravelsSignIn
    Scenario:User Signs in With Valid Credentials
    Given User Opens the Sign in Page
    When User Signs in with Valid Credentials
    And User Clicks Login
    Then User profile opens successfully

   @PHPTravelsSignInWrongPassword
  Scenario Outline:User Signs in With inValid Credentials
    Given User Opens the Sign in Page
    When User Signs in with InValid Credentials "<Email>" And "<Password>"
     And User Clicks Login
    Then User profile doesn't open
     Examples:
       |Email| | Password|
       |Mohannad | | Hesham  |

  @PHPTravelsSignInWithEmptyFields
  Scenario:User Signs in With Empty Fields
    Given User Opens the Sign in Page
    When User Clicks Login
    Then User Gets an Error Message



  @PHPTravelsRegisterWithSmallLetterNames
  Scenario Outline: User Types data for registration but with small letters for Names
    Given User Types "<FirstName>" in First Name Section
    When User Types "<LastName>" in Last Name Section
    And User Types Phone Number
    And User Types another Gmail in Email Section
    And User Types Password
    And User Types Confirmation Password
    And User Clicks Submit
    Then User Gets an Error Message For Typing Small Letters
    Examples:
      |FirstName| | LastName|
      |mohannad | | hesham  |

  @PHPTravelsRegisterWithDifferentPasswordAndConfirmation
  Scenario Outline: User Types data for registration but with password different from Confirmation
    Given User Types "<FirstName>" in First Name Section
    When User Types "<LastName>" in Last Name Section
    And User Types Phone Number
    And User Types Gmail in Email Section
    And User Types Password
    And User Types Different Confirmation Password
    And User Clicks Submit
    Then User Gets an Error Message For Typing different Passwords
    Examples:
      |FirstName| | LastName|
      |Mohannad | | Hesham  |

  @PHPTravelsRegisterWithPhoneNumberEmpty
  Scenario Outline: User Doesn't Type  Phone Number data for registration
    Given User Types "<FirstName>" in First Name Section
    When User Types "<LastName>" in Last Name Section
    And User Types Gmail in Email Section
    And User Types Password
    And User Types Confirmation Password
    And User Clicks Submit
    Then User Doesn't Get an Error Message for Not Having PhoneNumber
    Examples:
      |FirstName| | LastName|
      |Ahmed | | Mahmoud  |