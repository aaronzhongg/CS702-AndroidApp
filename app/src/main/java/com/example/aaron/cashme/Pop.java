package com.example.aaron.cashme;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

/**
 * Created by kartikpatel on 16/04/17.
 */

public class Pop extends Activity {

    Button closeBtn;
    Button saveBtn;

    public Pop() {
        // Required empty public constructor
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popwindow);
        closeBtn = (Button) findViewById(R.id.cancelButton);
        saveBtn = (Button) findViewById(R.id.saveButton);

        closeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                finish();
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                finish();

                //TODO: Store data. Add new income to income file
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
