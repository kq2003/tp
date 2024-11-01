# User Guide

## Introduction

SpendSwift is a simple budgeting tool designed for budget-conscious users. With intuitive text commands, you can effortlessly track expenses and manage your finances without the complexity of traditional tools.

## Quick Start

{Give steps to get started quickly}

1. Ensure that you have Java 17 or above installed.
1. Down the latest version of `Duke` from [here](http://link.to/duke).

## Features
### Command Format Notes
1. Commands are case-insensitive: Command words can be typed in any combination of upper or lower case.

   Example: `add-expense` and `ADD-EXPENSE` are both valid.
2. Words in UPPER_CASE are parameters to be supplied by the user.

   Example: In `add n/NAME`, `NAME` is a parameter, which can be used as `add n/Udon`.

3. All parameters are required unless specified: Every parameter must be supplied unless marked optional (e.g., square brackets [ ]).

   Example: `add-expense n/Coffee a/5.50` is valid because `c/CATEGORY` is optional, while `add-expense` with no parameters will fail.

4. Order of parameters: Parameters can be provided in any order, unless otherwise specified.

   Example: `add-expense n/Coffee a/5.50 c/Food` is equivalent to `add-expense a/5.50 n/Coffee c/Food`.

5. `INDEX`: Refers to the number corresponding to an expense in the list of expenses displayed. Always an integer.

   Example: `delete-expense 2` deletes the second expense listed in the expense list.

### Add an Expense: add-expense
This command allows you to record a new expense.

Format:
`add-expense n/NAME a/AMOUNT [c/CATEGORY]`

- `NAME`

  - The name of the expense.
  - This parameter is required.

- `AMOUNT`

  - The monetary value of the expense.
  - This input must be an integer or a double.
  - This parameter is required.

- `CATEGORY`

  - The category under which the expense will be recorded.
  - This parameter is optional. If not provided, the category will be set to `null`.

Example:
- `add-expense n/Coffee a/5.50 c/Food`
- `add-expense n/Book a/12.00`

### Delete an Expense: delete-expense
This command removes an existing expense from the record.

Format:
`delete-expense e/INDEX`

- `INDEX`
  - The index number of the expense, as shown in the expense list.
  - The index refers to the index number shown in the displayed person list.
  - The index must be a positive integer 1, 2, 3, ...
  - This parameter is required.

Example:
- `delete-expense e/3`

### Add a Category: add-category
Create a new category under which expenses can be categorised.

Format:
`add-category c/CATEGORY`

- `CATEGORY`
  - The name of the new category.
  - This parameter is required.

Example:
- `add-category c/Transport`

### Tag an Expense to a Category: tag-expense
Assign or change the category of an existing expense.

Format:
`tag-expense e/INDEX c/CATEGORY`

- `INDEX`
  - The index number of the expense, as shown in the expense list.
  - The index refers to the index number shown in the displayed person list.
  - The index must be a positive integer 1, 2, 3, ...
  - This parameter is required.

- `CATEGORY`
  - The name of the category to assign the expense to.
  - This must be an existing category.
  - This parameter is required.

Example:
- `tag-expense e/2 c/Transport`

### Add Budget Limit to a Category: set-budget
Set a maximum spending limit for a category for the current month.

Format:
`set-budget c/CATEGORY a/AMOUNT`

- `CATEGORY`
  - The name of the category to set the budget for.
  - This must be an existing category.
  - This parameter is required.

- `AMOUNT`
  - The maximum spending limit for this category in the current month.
  - This input must be an integer or a double.
  - This parameter is required.

Example:
- `set-budget c/Food a/300`

### View All Expenses: view-expenses
Displays all expenses recorded, in the order they were input.

Format:
`view-expenses`

- No parameters are required.
- Displays a list of all recorded expenses, showing the name, amount, and category.

Example output:
``` 
1. Coffee - $5.50 - Food
2. Book - $12.00 - null
3. Taxi - $15.00 - Transport
```

### View Budget for Each Category: view-budget
View the total expenses for each category in the current month and how much remains before the budget limit is reached.

Format:
`view-budget`

- No parameters are required.
- Displays a summary of spending and remaining budget for all categories with a budget limit.

Example output:
``` 
Food: $120 spent, $180 remaining  
Transport: $45 spent, $55 remaining  
Entertainment: No budget set
```

### Set Regular Monthly Reset of Budget: set-budget-reset
Automatically resets the budget for each category at the start of a new month.

Format:
`set-budget-reset ON/OFF`

- `ON/OFF`
  - This parameter is required.
  - on: Enables automatic monthly budget reset.
  - off: Disables automatic monthly budget reset.

Example:
- `set-budget-reset on`

## V2 Features (Coming soon)
### Menu
Format:
`menu`
- Displays a list of all available commands and short descriptions, such as:
  - tap-expense - Record a new expense
  - delete-expense - Remove an expense
  - tag-expense - Assign an expense to a category
  - add-category - Assign an expense to a category
  - set-budget - Set a budget limit for a category
  - view-expenses - View all recorded expenses
  - view-budget - Display current budget status for each category
  - set-budget-reset - Toggle monthly budget reset on or off

Example:
`menu`

### Exiting the program: bye
Exits the program.

Format:
`bye`


## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

{Give a 'cheat sheet' of commands here}

* Add todo `todo n/TODO_NAME d/DEADLINE`
