@unixTime
Feature:a test suit for this API assuming this is mission critical production service that is exposed publicly over the internet

  @Positive
  Scenario Outline: successful get request with "<unixTime>"
    Given user send valid unixTime "<unixTime>" request
    Then verify that the response is success for "<unixTime>"
    Examples:
      | unixTime   |
      | 154989280  |
      | 1549892280 |
      | -15498928  |
      | 1111111111 |
      | 999999999  |
      | 1          |


  @Negative
  Scenario Outline: invalid request with "<unixTime>"
    Given user send invalid unixTime "<unixTime>" request
    Then verify that the response contains error message "<message>" for "<unixTime>"
    Examples:
      | unixTime      | message                                               |                                            |
      | 1549892280A   | Input string was not in a correct format.             | # unix time doesn't except the letter      |
      | 1549892&280   | Input string was not in a correct format.             | # unix time doesn't except characters      |
      | 1549892280555 | Value was either too large or too small for an Int32. | # unix time must contain maximum 10 digits |
      |               | Value cannot be null.                                 | # unix time cannot be null                 |


  @currentTime
  Scenario: current unix Time validation
    Given user send the current unixTime
    Then verify that the response is success with current time


  @SecretDayInfo
  Scenario Outline: critical mission information
    Given user send unixTime "<unixTime>" of mission-critical production service request
    Then verify that the mission-critical date, hour, minute, and second is showed for "<unixTime>"
    Examples:
      | unixTime  |
      | 154982280 |





