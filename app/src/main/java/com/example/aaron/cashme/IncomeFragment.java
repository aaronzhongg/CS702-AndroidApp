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
import java.util.List;


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

        List<IncomeExpenses> tempList = mydb.getAllIncome();
//        String[] incomeArray = new String[tempList.size()];
//        incomeArray = tempList.toArray(incomeArray);

        adapter = new ListAdapter(getActivity(), tempList);
        listView.setAdapter(adapter);

        optionWindow = (Button) root.findViewById((R.id.plusButton));


        optionWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(IncomeFragment.this.getActivity(), Pop.class);

                startActivity(i);


            }
        });

    return root;
    }

    @Override
    public void onResume(){
        super.onResume();

        adapter.data = mydb.getAllIncome();
        adapter.notifyDataSetChanged();
    }

}
