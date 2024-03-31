Feature: Practice page automation

  Background: User in on main page
    Given User navigate to Home Page


  Scenario:User navigate to HomePage
    And user validate title

  @title
  Scenario Outline: Title validation
    When User click "<Link>" validate "<Title>"
    Examples:
      | Link                | Title               |
      | A/B Testing         | No A/B Test         |
      | Add/Remove Elements | Add/Remove Elements |

  @moveToLink
  Scenario: move to link
    When User move to link at the bottom
    And user validate link text "CYDEO"

  Scenario: Add remove elements
    When user move to Add Remove Page
    And User click Add Element Button
    Then User able to see Delete button
    When User click delete button button is remove

  Scenario: Basic Auth field validation
    When user click Basic Auth link
    And user successfully sign
    Then User see successfully signed message

  Scenario:Broken Images
    When User click Broken Images Page
    And user able to find brokenImages

  Scenario: Check Box testing
    When user click checkBox link
    And user validate  second CheckBox is selected by default


  Scenario Outline: Check Box testing
    When user click checkBox link
    And user validate  "<box>" is "<selection>"
    Examples:
      | box        | selection  |
      | CheckBox_1 | selected   |
      | CheckBox_2 | deselected |

  Scenario: Frame automation
    When user click frame
    And user click iFrame
    Then User switch to iframe
    And user able to add text inside the frame

  Scenario Outline: Dropdown menu selection
    When user click Dropdown Menu
    Then user click simple dropDown
    And  user select "<dropdown>"
    Examples:
      | dropdown |
      | Option1  |
      | Option2  |

  @wip
  Scenario Outline: Dropdown year selection
    When user click Dropdown Menu
    And  user select "<year>" yearDropdown
    And user select  "<month>" monthDropdown
    Then user select "<day>" dayDropdown
    Examples:
      | year | month  | day |
      | 2023 | August | 19  |
      | 2013 | May    | 12  |




