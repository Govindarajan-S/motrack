package com.webulous.motrack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.view.View;
import android.widget.EditText;

import com.webulous.motrack.db.MoTrackExpenseContract;
import com.webulous.motrack.db.MoTrackExpenseDbHelper;
import com.webulous.motrack.dummy.ExpenseContent;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView expenseRecyclerView;
    private RecyclerView.Adapter expenseAdapter;
    private RecyclerView.LayoutManager expenseLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expenseRecyclerView = findViewById(R.id.expense_recycler_view);

        expenseRecyclerView.setHasFixedSize(true);

        expenseLayoutManager = new LinearLayoutManager(this);
        expenseRecyclerView.setLayoutManager(expenseLayoutManager);

//        expenseAdapter = new ExpenseRecyclerViewAdapter(ExpenseContent.ITEMS);
        expenseAdapter = new ExpenseRecyclerViewAdapter(getExpenseEntries());
        expenseRecyclerView.setAdapter(expenseAdapter);
    }

    /**
     * openExpensePage methods opens the Expense Page Activity when floating button is clicked
     *
     * @param view
     */
    public void openExpensePage(View view) {
        Intent expenseIntent = new Intent(this, ExpensePageActivity.class);
        startActivity(expenseIntent);
    }

    public List<ExpenseContent.ExpenseItem> getExpenseEntries() {
        MoTrackExpenseDbHelper dbHelper = new MoTrackExpenseDbHelper(getApplicationContext());
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] projection = {
                MoTrackExpenseContract.Expense._ID,
                MoTrackExpenseContract.Expense.COLUMN_NAME_DESCRIPTION,
                MoTrackExpenseContract.Expense.COLUMN_NAME_COST,
                MoTrackExpenseContract.Expense.COLUMN_NAME_NOTE
        };
        String sortOrder = MoTrackExpenseContract.Expense.COLUMN_NAME_CREATE_DATE + " DESC";

        Cursor cursor = db.query(MoTrackExpenseContract.Expense.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder);
        List<ExpenseContent.ExpenseItem> expenseItemList = new ArrayList<ExpenseContent.ExpenseItem>();
        String description, cost, note;
        while (cursor.moveToNext()) {
            description = cursor.getString(cursor.getColumnIndexOrThrow(projection[1]));
            cost = String.valueOf(cursor.getDouble(cursor.getColumnIndexOrThrow(projection[2])));
            note = cursor.getString(cursor.getColumnIndexOrThrow(projection[3]));
            expenseItemList.add(new ExpenseContent.ExpenseItem(description, cost, note));
        }
        cursor.close();
        return expenseItemList;
    }
}
