package com.webulous.motrack.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class ExpenseContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<ExpenseItem> ITEMS = new ArrayList<ExpenseItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<Integer, ExpenseItem> ITEM_MAP = new HashMap<Integer, ExpenseItem>();

    private static final int COUNT = 10;

    private static int id = 0;

    static {
        // Add some sample items.
        String description = "Grocery";
        String cost = "500";
        String note = "Oil and Vegetables";
        for (int i = 1; i <= COUNT; i++) {
            addItem(createExpenseItem(description, cost, note));
        }
    }

    private static void addItem(ExpenseItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(id, item);
        id++;
    }

    private static ExpenseItem createExpenseItem(String description, String cost, String note) {
        return new ExpenseItem(description, cost, note);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class ExpenseItem {
        public final String description;
        public final String cost;
        public final String note;

        public ExpenseItem(String description, String cost, String note) {
            this.description = description;
            this.cost = cost;
            this.note = note;
        }

        @Override
        public String toString() {
            return "Description: " + description + "\n" +
                   "Cost: " + cost + "\n" +
                   "Note: " + note;
        }
    }
}
