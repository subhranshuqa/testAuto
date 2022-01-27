Feature: Get Pet

  Background:
    * url 'https://petstore.swagger.io/v2/pet'
    * header Accept = 'application/json'

  Scenario Outline: Get pet by id
    Given path '/' + <id>
    When method GET
    Then status 200
    And print response
    And assert responseTime < 3000
    And match response.id != null
    And match response.id == <id>
    And match response.category.id != null

    Examples:
      | id     |
      | 2    |

  Scenario: Get pet with invalid id
    Given path '/9453212'
    When method GET
    Then status 404
    And print response
    And assert responseTime < 3000
    And assert response.message == 'Pet not found'
