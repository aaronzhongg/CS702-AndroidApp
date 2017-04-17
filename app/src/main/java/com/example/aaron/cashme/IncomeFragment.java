package com.example.aaron.cashme;


import android.app.ActivityManager;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class IncomeFragment extends Fragment {

    ListView listView;
    ListAdapter adapter;
    DBHelper mydb;

    public IncomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_income, container, false);
        mydb = new DBHelper(getActivity());

        final Button optionWindow;
        final TextView amount;
        final EditText enteredAmount;

        amount = (TextView)root.findViewById(R.id.value);
        listView = (ListView) root.findViewById(R.id.listView);

        adapter = new ListAdapter(getActivity(), new String[] { "data1", "data2"});
        listView.setAdapter(adapter);

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
