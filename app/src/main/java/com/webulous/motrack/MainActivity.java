package com.webulous.motrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.webulous.motrack.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}
