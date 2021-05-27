Feature: To Signup into SystemX.

  @e2e
  Scenario Outline: When user tried to signup with valid details:
    Given : The app is in unauthorized state!
    Then : I submit the "<email>" and a "<password>"
    Then : I should no longer be unauthorized.
    Examples:
      | email                  | password         |
      | anmol@gmail.com        | Password123@     |
      | anmol.verma4@gmail.com | Passwordless123@ |

  @e2e
  Scenario Outline: When user tried to signup with invalid details:
    Given : The app is in unauthorized state!
    Then : I submit invalid "<email>" and a "<password>"
    Then : I should be unauthorized.
    Examples:
      | email              | password        |
      | anmolgmail.com     | assword123@     |
      | anmolermagmail.com | asswordless123@ |