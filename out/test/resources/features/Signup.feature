Feature: To Signup into SystemX.

  @e2e
  Scenario Outline: When user tried to signup with valid details:
    Given : The app is in unauthorized state!
    When : I Launch the App!
    Then : I submit the "<email>" and a "<password>"
    Then : I should no longer be unauthorized.
    Examples:
      | email | password |
      | anmol@gmail.com | Password |