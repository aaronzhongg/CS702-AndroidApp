package com.example.aaron.cashme;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

/**
 * This popup view is used to add new incomes
 *
 * Created by kartikpatel on 16/04/17.
 */

public class Pop extends Activity {


    // Declarations of variables
    DBHelper mydb;
    Button closeBtn;
    Button saveBtn;
    RadioGroup radioGroup;
    EditText incomeName;
    EditText amount;

    public Pop() {
        // Required empty public constructor
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popwindow);
        mydb = new DBHelper(this);

        closeBtn = (Button) findViewById(R.id.cancelButton);
        saveBtn = (Button) findViewById(R.id.saveButton);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        incomeName = (EditText) findViewById(R.id.incomeName) ;
        amount = (EditText) findViewById(R.id.amount);


        // Onclick button to close the popup window after filling in form
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

                }
                else {
                    if (checkedRadioButtonId == R.id.perWeekRadioBtn) {
                        mydb.insertIncome(incomeName.getText().toString(), Double.parseDouble(amount.getText().toString()), 0);
                    }
                    else if (checkedRadioButtonId == R.id.perMonthRadioBtn) {
                        mydb.insertIncome(incomeName.getText().toString(), Double.parseDouble(amount.getText().toString()), 1);
                    }
                    else if (checkedRadioButtonId == R.id.perYearRadioBtn) {
                        mydb.insertIncome(incomeName.getText().toString(), Double.parseDouble(amount.getText().toString()), 2);
                    }

                    finish();


                }



            }
        });


    }


}
