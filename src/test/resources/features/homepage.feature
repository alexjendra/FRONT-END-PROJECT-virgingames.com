Feature: Top menu headers
  As a user I want to check Virgin Games website features


  @author_khushbu_raval
  Scenario Outline: I am on homepage
    When  I click on accept cookies
    Then I should see Virgin Games logo on homepage
    And  I mouse hoover on Login button
    Then  I click on all "<tabs>"
    Examples:
      | tabs         |
      | Online Slots |
      | Live Casino  |
      | Casino       |
      | Slingo       |
      | Online Bingo |
      | Free Games   |
      | Poker        |
      | All Games    |
      | Blog         |
