package com.example.aaron.cashme;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

/**
 * This is a popup to add new expenses
 *
 * Created by Aaron on 21/04/17.
 */

public class ExpensesPopUp extends Activity {

    //declare variables
    DBHelper mydb;
    Button closeBtn;
    Button saveBtn;
    RadioGroup radioGroup;
    EditText expenseName;
    EditText amount;

    public ExpensesPopUp() {
        // Required empty public constructor
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.expenses_pop_window);
        mydb = new DBHelper(this);

        closeBtn = (Button) findViewById(R.id.expensesCancelButton);
        saveBtn = (Button) findViewById(R.id.expensesSaveButton);
        radioGroup = (RadioGroup) findViewById(R.id.expensesRadioGroup);
        expenseName = (EditText) findViewById(R.id.expensesName);
        amount = (EditText) findViewById(R.id.expenseAmount);

        closeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                finish();
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                //TODO: Store data. Add new income to income file
                int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();

                if (checkedRadioButtonId == -1) {

                } else {
                    if (checkedRadioButtonId == R.id.expensesPerWeekRadioBtn) {
                        mydb.insertExpense(expenseName.getText().toString(), Double.parseDouble(amount.getText().toString()), 0);
                    } else if (checkedRadioButtonId == R.id.expensesPerMonthRadioBtn) {
                        mydb.insertExpense(expenseName.getText().toString(), Double.parseDouble(amount.getText().toString()), 1);
                    } else if (checkedRadioButtonId == R.id.expensesPerYearRadioBtn) {
                        mydb.insertExpense(expenseName.getText().toString(), Double.parseDouble(amount.getText().toString()), 2);
                    }

                    finish();


                }


            }
        });
    }
}
