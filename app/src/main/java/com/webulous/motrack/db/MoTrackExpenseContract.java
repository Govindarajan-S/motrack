package com.webulous.motrack.db;

import android.provider.BaseColumns;

public final class MoTrackExpenseContract {
    /** Private Constructor to prevent object creation */
    private MoTrackExpenseContract() {};

    /** Expense Table Definition */
    public static class Expense implements BaseColumns {
        public static final String _ID = "no";
        public static final String TABLE_NAME = "expense";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
        public static final String COLUMN_NAME_COST = "cost";
        public static final String COLUMN_NAME_NOTE = "note";
        public static final String COLUMN_NAME_CREATE_DATE = "create_date";
        public static final String COLUMN_NAME_MODIFIED_DATE = "modified_date";

        static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + Expense.TABLE_NAME + " (" +
                Expense._ID + " INTEGER PRIMARY KEY," +
                Expense.COLUMN_NAME_DESCRIPTION + " TEXT," +
                Expense.COLUMN_NAME_COST + " REAL," +
                Expense.COLUMN_NAME_NOTE + " TEXT," +
                Expense.COLUMN_NAME_CREATE_DATE + " TEXT," +
                Expense.COLUMN_NAME_MODIFIED_DATE + " TEXT)";

        static final String SQL_SELECT_ENTRIES =
                "SELECT " + Expense.COLUMN_NAME_DESCRIPTION + ", " +
                        Expense.COLUMN_NAME_COST + ", " +
                        Expense.COLUMN_NAME_NOTE + " FROM " +
                        Expense.TABLE_NAME;
    }
}
