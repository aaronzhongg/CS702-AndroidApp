package com.example.aaron.cashme;


import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * This fragment manages adding, removing and updating view items related to income
 *
 * A simple {@link Fragment} subclass.
 */
public class IncomeFragment extends Fragment {

    //Declared variables
    ListView listView;
    ListAdapter adapter;
    DBHelper mydb;
    TextView amount;
    List<IncomeExpenses> tempList;

    public IncomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_income, container, false);

        //Gets database data
        mydb = new DBHelper(getActivity());

        final Button optionWindow;
        final EditText enteredAmount;

        amount = (TextView)root.findViewById(R.id.value);
        listView = (ListView) root.findViewById(R.id.listView);

        tempList = mydb.getAllIncome();


        adapter = new ListAdapter(getActivity(), tempList);
        listView.setAdapter(adapter);
        updateListView();

        // Dialog to delete icome items from list - click to delete
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
                alertDialog.setCancelable(false);
                alertDialog.setMessage("Delete item?");
                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        int id;

                        id = tempList.get(position).id;

                        mydb.deleteIncome(id);

                        //Update your ArrayList
                        tempList = mydb.getAllIncome();
                        adapter.data = tempList;

                        //Notify your ListView adapter
                        adapter.notifyDataSetChanged();
                        updateListView();
                    }
                });
                alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alertDialog.show();

            }

        });

        optionWindow = (Button) root.findViewById((R.id.plusButton));

        optionWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open popup window to add new expense
                Intent i = new Intent(IncomeFragment.this.getActivity(), Pop.class);

                startActivity(i);


            }
        });

    return root;
    }

    // Updates the window with new entered data from the user, fetches from the database
    @Override
    public void onResume(){
        super.onResume();

        tempList = mydb.getAllIncome();
        adapter.data = tempList;
        adapter.notifyDataSetChanged();
        updateListView();
    }

    //Updates total text and performs a monthly conversion calculation
    public void updateListView() {
        amount.setText("$" + mydb.calculateTotalMonthlyIncome());
    }

}
