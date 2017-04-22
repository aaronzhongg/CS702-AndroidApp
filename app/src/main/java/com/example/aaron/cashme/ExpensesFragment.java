package com.example.aaron.cashme;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ExpensesFragment extends Fragment {

    ListView listView;
    ExpensesListAdapter adapter;
    DBHelper mydb;
    TextView amount;
    List<IncomeExpenses> tempList;

    public ExpensesFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_expenses, container, false);
        mydb = new DBHelper(getActivity());

        final Button optionWindow;

        amount = (TextView)root.findViewById(R.id.expensesValue);
        listView = (ListView) root.findViewById(R.id.expensesListView);

        tempList = mydb.getAllExpenses();

        adapter = new ExpensesListAdapter(getActivity(), tempList);
        listView.setAdapter(adapter);
        updateListView();

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

                        mydb.deleteExpense(id);

                        //Update your ArrayList
                        tempList = mydb.getAllExpenses();
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

        optionWindow = (Button) root.findViewById((R.id.expensesPlusButton));

        optionWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ExpensesFragment.this.getActivity(), ExpensesPopUp.class);

                startActivity(i);


            }
        });

        return root;
    }

    @Override
    public void onResume(){
        super.onResume();

        tempList = mydb.getAllExpenses();
        adapter.data = tempList;
        adapter.notifyDataSetChanged();
        updateListView();
    }

    public void updateListView() {
        amount.setText("$" + mydb.calculateTotalMonthlyExpenses());
    }

}
