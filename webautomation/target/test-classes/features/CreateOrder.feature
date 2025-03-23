Feature: Purchase the order from ecomerce

  Background: Buyer landed to website
    Given Buyer landed to website
  # Scenario: Success create order
  #   Given Buyer logged to website
  #   When Buyer add the product to cart
  #   And Buyer checkout the product
  #   And Buyer fill form data
  #   Then Buyer will see message is displayed on confirmation page

  Scenario Outline: Success create order
    Given Buyer logged to website email <email> and password <password>
    When Buyer add the product <product_name> to cart
    And Buyer checkout the product
    And Buyer fill form data first name <first_name>, last name <last_name>, and postal code <postcode>
    Then Buyer will see message is displayed on confirmation page Thank you for your order!

    Examples:
      | email         | password     | product_name        | first_name | last_name |
      | standard_user | secret_sauce | Sauce Labs Backpack | Rifky      | Pahlevy   |

  Scenario Outline: Failed login to website
    When Buyer logged to website email <email> and password <password>
    Then Buyer will see alert failed message Epic sadface: Username and password do not match any user in this service

    Examples:
      | email         |
      | standaran     |
      | standard_user |

  Scenario Outline: Success delete item
    Given Buyer logged to website email <email> and password <password>
    When Buyer add the product <product_name> to cart
    And Buyer can delete the product in cart
    Then Buyer will see count of product

    Examples:
      | email         | password     | product_name        | first_name | last_name |
      | standard_user | secret_sauce | Sauce Labs Backpack | Rifky      | Pahlevy   |
