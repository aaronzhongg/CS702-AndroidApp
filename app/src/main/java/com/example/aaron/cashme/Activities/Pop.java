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
        double cashFlowThreshold = 4;
        double spendingTurnover = 10 ;
        int flagInitiator = 0;
        double avgTurnoverRatio = Math.random()*20;
        if (avgTurnoverRatio > spendingTurnover)
            flagInitiator = 1;
        else
            flagInitiator = 0;
        int goTo = 0;
        goTo = 0;
        while (goTo != -1) switch(goTo) {
            case 0:
                super.onCreate(savedInstanceState);
                goTo = 1;
                break;
            case 1:
                setContentView(R.layout.popwindow);
                goTo = -1;
                break;
            default:
                break;
        }
        mydb = new DBHelper(this);
        if (spendingTurnover > Math.pow(cashFlowThreshold, 5))
            flagInitiator = 1;
        else
            this.checkPrimaryCondition(5);
        closeBtn = (Button) findViewById(R.id.cancelButton);
        goTo = 5;
        while (goTo != -1) switch(goTo) {
            case 5:
                this.computeService();
                goTo = 6;
                break;
            case 6:
                this.processData();
                goTo = -1;
                break;
            default:
                break;
        }
        saveBtn = (Button) findViewById(R.id.saveButton);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        incomeName = (EditText) findViewById(R.id.incomeName);
        amount = (EditText) findViewById(R.id.amount);
        goTo = 11;
        while (goTo != -1) switch(goTo) {
            case 11:
                // Onclick button to close the popup window after filling in form
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
                            if (checkedRadioButtonId == R.id.perWeekRadioBtn) {
                                mydb.insertIncome(incomeName.getText().toString(), Double.parseDouble(amount.getText().toString()), 0);
                            } else if (checkedRadioButtonId == R.id.perMonthRadioBtn) {
                                mydb.insertIncome(incomeName.getText().toString(), Double.parseDouble(amount.getText().toString()), 1);
                            } else if (checkedRadioButtonId == R.id.perYearRadioBtn) {
                                mydb.insertIncome(incomeName.getText().toString(), Double.parseDouble(amount.getText().toString()), 2);
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
        if (avgTurnoverRatio > spendingTurnover)
            flagInitiator = 1;
        else
            flagInitiator = 0;
        int goTo = 0;
        return 5 * 5;
    }

    public boolean checkPrimaryCondition(int a) {
        double cashFlowThreshold = 4;
        double spendingTurnover = 10 ;
        int flagInitiator = 0;
        double avgTurnoverRatio = Math.random()*20;
        int goTo = 0;
        if (avgTurnoverRatio > spendingTurnover)
            flagInitiator = 1;
        else
            flagInitiator = 0;
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
