Feature: Add new item to TODO list

Scenario: Add buying milk to the list
  Given Rama is looking at his TODO list
  When he adds "Buy some milk" to the list
  Then he sees "Buy some milk" as an item in the TODO list

Scenario:
  Given API test Given system print
  When API test When system print
  Then API test Then system print
