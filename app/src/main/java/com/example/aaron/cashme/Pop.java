package com.example.aaron.cashme;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

/**
 * Created by kartikpatel on 16/04/17.
 */

public class Pop extends Activity {

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

                    finish();
                }



            }
        });



//        final PopupWindow popUpWindow = new PopupWindow(this);
//
//        DisplayMetrics dm = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(dm);
//
//        int width = dm.widthPixels;
//        int height = dm.heightPixels;
//
//        getWindow().setLayout((int)(width*0.8),(int)(height*0.7));


//        final Button close = (Button)findViewById((R.id.saveButton));
//        close.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                popUpWindow.dismiss();
//            }
//        });

    }


}
