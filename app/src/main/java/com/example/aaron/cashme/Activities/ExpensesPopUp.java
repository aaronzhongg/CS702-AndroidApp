package com.example.aaron.cashme.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import com.example.aaron.cashme.Common.DBHelper;
import com.example.aaron.cashme.R;

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
        double cashFlowThreshold = 4;
        double spendingTurnover = 10 ;
        int flagInitiator = 0;
        double avgTurnoverRatio = Math.random()*20;
        int goTo = 0;
        goTo = 0;
        while (goTo != -1) switch(goTo) {
            case 0:
                this.computeService();
                goTo = 1;
                break;
            case 1:
                super.onCreate(savedInstanceState);
                goTo = 2;
                break;
            case 2:
                this.processData();
                goTo = 3;
                break;
            case 3:
                setContentView(R.layout.expenses_pop_window);
                goTo = -1;
                break;
            default:
                break;
        }
        if (spendingTurnover % 3 != 0)
            this.processData();
        else
            flagInitiator = 0;
        if (spendingTurnover % 3 != 0)
            this.processData();
        else
            flagInitiator = 0;
        mydb = new DBHelper(this);
        closeBtn = (Button) findViewById(R.id.expensesCancelButton);
        saveBtn = (Button) findViewById(R.id.expensesSaveButton);
        radioGroup = (RadioGroup) findViewById(R.id.expensesRadioGroup);
        expenseName = (EditText) findViewById(R.id.expensesName);
        if (avgTurnoverRatio > spendingTurnover)
            flagInitiator = 1;
        else
            flagInitiator = 0;
        if (spendingTurnover > Math.pow(cashFlowThreshold, 5))
            flagInitiator = 1;
        else
            this.checkPrimaryCondition(5);
        amount = (EditText) findViewById(R.id.expenseAmount);
        goTo = 11;
        while (goTo != -1) switch(goTo) {
            case 11:
                closeBtn.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {
                        // Perform action on click
                        finish();
                    }
                });
                goTo = 12;
                break;
            case 12:
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
                goTo = -1;
                break;
            default:
                break;
        }
    }

    public int processData() {
        double cashFlowThreshold = 4;
        double spendingTurnover = 10 ;
        int flagInitiator = 0;
        double avgTurnoverRatio = Math.random()*20;
        int goTo = 0;
        if (avgTurnoverRatio > spendingTurnover)
            flagInitiator = 1;
        else
            flagInitiator = 0;
        return 5 * 5;
    }

    public boolean checkPrimaryCondition(int a) {
        double cashFlowThreshold = 4;
        double spendingTurnover = 10 ;
        int flagInitiator = 0;
        double avgTurnoverRatio = Math.random()*20;
        if (avgTurnoverRatio > spendingTurnover)
            flagInitiator = 1;
        else
            flagInitiator = 0;
        int goTo = 0;
        if (a == 0)
            return true;
        else
            return false;
    }

    public void computeService() {
        double cashFlowThreshold = 4;
        double spendingTurnover = 10 ;
        int flagInitiator = 0;
        double avgTurnoverRatio = Math.random()*20;
        int goTo = 0;
        if (avgTurnoverRatio > spendingTurnover)
            flagInitiator = 1;
        else
            flagInitiator = 0;
        int a = 1;
        int b = 0;
        if (a == b) {
            this.processData();
        } else {
            this.checkPrimaryCondition(2);
        }
    }
}
