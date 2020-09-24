Feature: Acceptance criteria of this challenge
  Using this story to demonstrate the usage of cucumber-java
  to test the acceptance criteria of this challenge.

  Scenario: User sends a message to a Message Server.
    Given A User sends an "hello" message
    When The message is converted by the Adapter
    Then The Message server should contain the "hello" message in the queue