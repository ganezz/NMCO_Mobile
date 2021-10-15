@firstScreen
Feature: Validating buttons in Home screen of APZ_Retail_ONB

  Background: User should able to open App
    Given user opens the App batch1

  Scenario Outline:  Validate Register button
    And user in Home screen <testcase>
    When clicks Register Button
    Then user will landed on Legal Entity User Details
    Examples:
      | testcase     |
      | TestCase_000 |

  Scenario Outline:  Validate English language button
    And user in Home screen <testcase>
    When clicks English Button
    Then app language change to English
    Examples:
      | testcase |
      | TestCase_000 |

  Scenario Outline:  Validate Arabic button
    And user in Home screen <testcase>
    When clicks Arabic Button
    Then app language change to Arabic
    Examples:
      | testcase     |
      | TestCase_000 |