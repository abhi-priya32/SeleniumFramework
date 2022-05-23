Feature: UI Validation Part

  Scenario Outline: Validate whether the all labels are getting populated in UI
    Given Login Page of UI Loads Sucessfully
    Then User is login with valid "<UserId>" and "<Pass>" to the application
    Then Enter the value of "<StoreNum>" to Store Number input field
    Then Click on search icon link
    Then Validate for "Period" grid following lebels are getting populated
      | Address Code Ean: |
      | Valid From:       |
      | Valid Until:      |
    Then Validate for "Visiting Address" grid following lebels are getting populated  
      | Street:              |
      | House Number:        |
      | House Number Suffix: |
      | Postal Code:         |
      | City:                |
      | Country:             |
    Then Validate for "Delivery Address" grid following lebels are getting populated
      | Street:              |
      | House Number:        |
      | House Number Suffix: |
      | Postal Code:         |
      | City:                |
      | Country:             |
    Then Validate for "PO Box Address" grid following lebels are getting populated
      | Po Box Number: |
      | Postal Code:   |
      | City:          |
      | Country:       |
    Then Click on "Temporary Closures" tab header
    Then Validate for grid following lebels are getting populated for Temp Closr
      | Closed From:  |
      | Closed Until: |
      | Reason:       |
      | Description:  |
    Then Click on "Opening Hours" tab header
    Then Validate for grid following lebels are getting populated for Opening Hrs
      | Name:         |
      | Description:  |
      | Opening Time: |
      | Closing Time: |
    Then Click on "Group Memberships" tab header
    Then Validate for grid following lebels are getting populated for Group membership
      | Grouping Name: |
      | Group Name:    |
      | Valid From:    |
      | Valid Until:   |
    Then Click on "Org Memberships" tab header
    Then Validate for grid following lebels are getting populated for Org membership
      | Cluster Id:   |
      | Cluster Name: |
      | Region Id:    |
      | Region Name:  |
      | Franchise:    |
      | Valid From:   |
      | Valid Until:  |
    Then Click on "Parameters" tab header
    Then Validate for grid following lebels are getting populated for Parameters
      | Name:                 |
      | Value:                |
      | New Value:            |
      | New Value Valid From: |

    Examples: 
      | Envr | code | StoreNum | UserId    | Pass     |
      | Test |  200 |     1001 | XXXXXXXXX | XXXXXXXX |
