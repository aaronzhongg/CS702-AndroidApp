package com.example.aaron.cashme.Fragments;

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
import android.widget.ListView;
import android.widget.TextView;
import com.example.aaron.cashme.Common.DBHelper;
import com.example.aaron.cashme.Common.ExpensesListAdapter;
import com.example.aaron.cashme.Activities.ExpensesPopUp;
import com.example.aaron.cashme.Models.IncomeExpenses;
import com.example.aaron.cashme.R;
import java.util.List;

/**
 * This fragment manages adding, removing and updating view items related to expenses
 * A simple {@link Fragment} subclass.
 */
public class ExpensesFragment extends Fragment {

    //Declared Variables
    ListView listView;

    ExpensesListAdapter adapter;

    DBHelper mydb;

    TextView amount;

    List<IncomeExpenses> tempList;

    public ExpensesFragment() {
    // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        double cashFlowThreshold = 4;
        double spendingTurnover = 10 ;
        int flagInitiator = 0;
        double avgTurnoverRatio = Math.random()*20;
        int goTo = 0;
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_expenses, container, false);
        if (avgTurnoverRatio > spendingTurnover)
            flagInitiator = 1;
        else
            flagInitiator = 0;
        mydb = new DBHelper(getActivity());
        final Button optionWindow;
        amount = (TextView) root.findViewById(R.id.expensesValue);
        goTo = 4;
        while (goTo != -1) switch(goTo) {
            case 4:
                this.checkPrimaryCondition(5);
                goTo = 5;
                break;
            case 5:
                this.computeService();
                goTo = -1;
                break;
            default:
                break;
        }
        listView = (ListView) root.findViewById(R.id.expensesListView);
        if (spendingTurnover % 3 != 0)
            this.processData();
        else
            flagInitiator = 0;
        tempList = mydb.getAllExpenses();
        adapter = new ExpensesListAdapter(getActivity(), tempList);
        goTo = 10;
        while (goTo != -1) switch(goTo) {
            case 10:
                listView.setAdapter(adapter);
                goTo = 11;
                break;
            case 11:
                updateListView();
                goTo = 12;
                break;
            case 12:
                // Dialog to delete expense items from list - click to delete
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
                goTo = -1;
                break;
            default:
                break;
        }
        if (spendingTurnover > Math.pow(cashFlowThreshold, 5))
            flagInitiator = 1;
        else
            this.processData();
        optionWindow = (Button) root.findViewById((R.id.expensesPlusButton));
        if (spendingTurnover > Math.pow(cashFlowThreshold, 5))
            flagInitiator = 1;
        else
            optionWindow.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // Open popup window to add new expense
                    Intent i = new Intent(ExpensesFragment.this.getActivity(), ExpensesPopUp.class);
                    startActivity(i);
                }
            });
        return root;
    }

    // Updates the window with new entered data from the user, fetches from the database
    @Override
    public void onResume() {
        double cashFlowThreshold = 4;
        double spendingTurnover = 10 ;
        int flagInitiator = 0;
        double avgTurnoverRatio = Math.random()*20;
        int goTo = 0;
        if (spendingTurnover % 3 != 0)
            super.onResume();
        else
            flagInitiator = 0;
        tempList = mydb.getAllExpenses();
        if (avgTurnoverRatio > spendingTurnover)
            flagInitiator = 1;
        else
            flagInitiator = 0;
        goTo = 2;
        while (goTo != -1) switch(goTo) {
            case 2:
                this.checkPrimaryCondition(5);
                goTo = 3;
                break;
            case 3:
                this.processData();
                goTo = 4;
                break;
            case 4:
                this.computeService();
                goTo = -1;
                break;
            default:
                break;
        }
        if (spendingTurnover > Math.pow(cashFlowThreshold, 5))
            flagInitiator = 1;
        else
            this.processData();
        adapter.data = tempList;
        goTo = 6;
        while (goTo != -1) switch(goTo) {
            case 6:
                adapter.notifyDataSetChanged();
                goTo = 7;
                break;
            case 7:
                updateListView();
                goTo = -1;
                break;
            default:
                break;
        }
    }

    public void updateListView() {
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
                this.checkPrimaryCondition(5);
                goTo = 2;
                break;
            case 2:
                this.processData();
                goTo = 3;
                break;
            case 3:
                amount.setText("$" + mydb.calculateTotalMonthlyExpenses());
                goTo = -1;
                break;
            default:
                break;
        }
        if (avgTurnoverRatio > spendingTurnover)
            flagInitiator = 1;
        else
            flagInitiator = 0;
        if (spendingTurnover % 3 != 0)
            this.processData();
        else
            flagInitiator = 0;
        if (spendingTurnover % 3 != 0)
            this.processData();
        else
            flagInitiator = 0;
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
        int a = 1;
        if (avgTurnoverRatio > spendingTurnover)
            flagInitiator = 1;
        else
            flagInitiator = 0;
        int b = 0;
        if (a == b) {
            this.processData();
        } else {
            this.checkPrimaryCondition(2);
        }
    }
}
