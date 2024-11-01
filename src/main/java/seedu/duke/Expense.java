package seedu.duke;

import java.text.DecimalFormat;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Represents an expense with a name, amount, and category.
 */
public class Expense {


    private String name;
    private double amount;
    private Category category;

    /**
     * Constructs an Expense object with the specified name, amount, and category.
     *
     * @param name The name of the expense item.
     * @param name The amount of the expense.
     * @param category The category associated with the expense.
     */
    public Expense(String name, double amount, Category category) {
        this.name = name;
        this.amount = amount;
        this.category = category;
    }

    /**
     * Returns the name of the expense.
     *
     * @return The name of the expense.
     */
    public String getName() {
        return name;
    }


    /**
     * Returns the amount of the expense.
     *
     * @Return the amount of the expense.
     */
    public double getAmount() {
        return amount;
    }

    public Category getCategory() {
        return category != null ? category : null;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String formatAmount() {
        BigDecimal roundedAmount = BigDecimal.valueOf(amount).setScale(2, RoundingMode.HALF_UP);
        DecimalFormat wholeNumberFormat = new DecimalFormat("$#");
        DecimalFormat decimalFormat = new DecimalFormat("$#.00");
        if (roundedAmount.stripTrailingZeros().scale() <= 0) {
            return wholeNumberFormat.format(roundedAmount);
        } else {
            return decimalFormat.format(roundedAmount);
        }
    }


    /**
     * Returns a string representation of the expense, including name, formatted amount, and category.
     *
     * @return a string describing the expense.
     */
    @Override
    public String toString() {
        return " Item: " + name + ", Amount: " + formatAmount() + ", Category: " + getCategory();
    }
}
