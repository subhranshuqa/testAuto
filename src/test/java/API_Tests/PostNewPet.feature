Feature: Post pet

  Background:
    * url 'https://petstore.swagger.io/v2'
    * header Accept = 'application/json'

  Scenario Outline: Add a new pet to the store
    Given path '/pet'
    And request {"id": <id>,"category": {"id": 0,"name": "string"},"name": <name>,"photoUrls": ["string"],"tags": [{"id": 0,"name": "string"}],"status": "available"}
    When method POST
    Then status 200
    And print response
    And assert responseTime < 3000

    Examples:
      | id     | name |
      | '1'    | 'puppy' |
      | '2' | 'tommy' |

