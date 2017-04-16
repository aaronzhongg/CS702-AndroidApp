package com.example.aaron.cashme;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class IncomeFragment extends Fragment {

    public IncomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_income, container, false);

        final Button optionWindow;
        final TextView amount;
        final EditText enteredAmount;


        amount = (TextView)root.findViewById(R.id.value);

        optionWindow = (Button) root.findViewById((R.id.plusButton));
        optionWindow.setTag(1);

        optionWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IncomeFragment.this.getActivity(), Pop.class));

//          final int status =(Integer) v.getTag();
//                if(status == 1) {
//                    optionWindow.setText("-");
//                    v.setTag(0); //pause
//                } else {
//                    optionWindow.setText("+");
//                    v.setTag(1); //pause
//                }
            }
        });






    return root;
    }



}
