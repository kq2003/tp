package seedu.duke;

import java.io.IOException;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String filePath = "spendswift.txt";
        Storage storage = new Storage(filePath);
        TrackerData trackerData = new TrackerData();

        try {
            storage.loadData(trackerData);
            System.out.println("Data loaded successfully");
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }

        CategoryManager categoryManager = new CategoryManager();
        BudgetManager budgetManager = new BudgetManager();
        ExpenseManager expenseManager = new ExpenseManager();

        Scanner in = new Scanner(System.in);
        System.out.println("Hiya! How can I assist?");
        while (true) {
            if (in.hasNextLine()) {
                String input = in.nextLine().trim();
                if (input.startsWith("add-expense")) {
                    expenseManager.addExpenseRequest(input, expenseManager, trackerData);
                } else if (input.startsWith("add-category")) {
                    categoryManager.addCategory(trackerData, input);
                } else if (input.startsWith("delete-expense")) {
                    expenseManager.deleteExpenseRequest(input, expenseManager, trackerData);
                } else if (input.startsWith("tag-expense")) {
                    expenseManager.tagExpense(trackerData, input);
                } else if (input.equalsIgnoreCase("bye")) {
                    System.out.println("Goodbye! :> Hope to see you again soon!");
                    break;
                } else if (input.equalsIgnoreCase("view-budget")) {
                    budgetManager.viewBudget(trackerData);
                } else if (input.startsWith("set-budget")) {
                    budgetManager.setBudgetLimitRequest(input, budgetManager, trackerData);
                } else if (input.startsWith("view-expenses")) {
                    expenseManager.viewExpensesByCategory(trackerData);
                } else if (input.equalsIgnoreCase("toggle-reset")) {
                    budgetManager.toggleAutoReset();
                } else {
                    System.out.println("Invalid input! Try again."); // Provide feedback for invalid input
                }
            } else {
                System.out.println("No input received.");
                break;
            }
        }
        try {
            storage.saveData(trackerData);
            System.out.println("Data has been saved!");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
}
