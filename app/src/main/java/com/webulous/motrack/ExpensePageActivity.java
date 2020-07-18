package com.webulous.motrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.webulous.motrack.db.MoTrackExpenseContract;
import com.webulous.motrack.db.MoTrackExpenseDbHelper;

import java.sql.Date;
import java.time.LocalDateTime;

public class ExpensePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_page);
        Intent expenseIntent = getIntent();
    }

    /**
     * saveExpense method adds the expense into the table.
     *
     * @param view
     */
    public void saveExpense(View view) {
        MoTrackExpenseDbHelper dbHelper = new MoTrackExpenseDbHelper(getApplicationContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(MoTrackExpenseContract.Expense.COLUMN_NAME_DESCRIPTION, getDescription());
        values.put(MoTrackExpenseContract.Expense.COLUMN_NAME_COST, getCost());
        values.put(MoTrackExpenseContract.Expense.COLUMN_NAME_NOTE, getNote());
        values.put(MoTrackExpenseContract.Expense.COLUMN_NAME_CREATE_DATE, getDate());
        values.put(MoTrackExpenseContract.Expense.COLUMN_NAME_MODIFIED_DATE, getDate());

        long newRowId = db.insert(MoTrackExpenseContract.Expense.TABLE_NAME, null, values);
        finish();
    }

    /**
     * getDate method returns string representation of the current date time
     *
     * @return currentDateTime
     */
    public String getDate() {
        String currentDateTime = String.valueOf(LocalDateTime.now());
        return currentDateTime;
    }

    public String getDescription() {
        EditText txtDescription = findViewById(R.id.txt_description);
        String description = txtDescription.getText().toString();
        return description;
    }

    public Double getCost() {
        EditText txtCost = findViewById(R.id.txt_cost);
        Double cost = Double.valueOf(txtCost.getText().toString());
        return cost;
    }

    public String getNote() {
        EditText txtNote = findViewById(R.id.txt_note);
        String note = txtNote.getText().toString();
        return note;
    }
}
