@todayTix
Feature: Service check for Home task

  Scenario Outline: Consuming ticket service to validate correct behaviours
    Given I make a request to availability service with <quantity> <fromDate> <toDate> <headerValue>
    When I validate if the status code is 200 <statusExpected>
    Then I make sure that minPrice is not null

    Examples:
      | quantity | fromDate | toDate   | statusExpected | headerValue     |
      | 1        | 20220428 | 20220528 | 200            | londontheatredd |
      | 10       | 20220528 | 20220628 | 200            | londontheatredd |
      | 5        | 20220722 | 20220822 | 200            | londontheatredd |

  Scenario Outline: Consuming ticket service to validate dates errors
    Given I make a request to availability service with <quantity> <fromDate> <toDate> <headerValue>
    When I validate if the status code is 200 <statusExpected>
    And I also validate if the response error message is the expected <expectedErrorMessage>
    Then I make sure that minPrice is not null

    Examples:
      | quantity | fromDate | toDate   | statusExpected | headerValue     | expectedErrorMessage                 |
      | 1        | 20220411 | 20220511 | 400            | londontheatredd | start date should not be in the past |
      | 5        | 20220111 | 20220611 | 400            | londontheatredd | start date should not be in the past |

  Scenario Outline: Consuming ticket service to validate empty header error handle
    Given I make a request to availability service with <quantity> <fromDate> <toDate> <headerValue>
    When I validate if the status code is 200 <statusExpected>
    And I also validate if the response error message is the expected <expectedErrorMessage>
    Then I make sure that minPrice is not null

    Examples:
      | quantity | fromDate | toDate   | statusExpected | headerValue | expectedErrorMessage |
      | 5        | 20220420 | 20220520 | 404            | aaa         | Product not found    |
      | 10       | 20220528 | 20220628 | 404            | ""          | Product not found    |
