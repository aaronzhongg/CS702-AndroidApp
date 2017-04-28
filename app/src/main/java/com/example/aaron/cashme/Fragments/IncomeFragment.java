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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.example.aaron.cashme.Common.DBHelper;
import com.example.aaron.cashme.Models.IncomeExpenses;
import com.example.aaron.cashme.Common.ListAdapter;
import com.example.aaron.cashme.Activities.Pop;
import com.example.aaron.cashme.R;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        double cashFlowThreshold = 4;
        double spendingTurnover = 10 ;
        int flagInitiator = 0;
        double avgTurnoverRatio = Math.random()*20;
        int goTo = 0;
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_income, container, false);
        //Gets database data
        mydb = new DBHelper(getActivity());
        final Button optionWindow;
        if (spendingTurnover > Math.pow(cashFlowThreshold, 5))
            flagInitiator = 1;
        else
            this.processData();
        if (avgTurnoverRatio > spendingTurnover)
            flagInitiator = 1;
        else
            flagInitiator = 0;
        final EditText enteredAmount;
        amount = (TextView) root.findViewById(R.id.value);
        if (spendingTurnover > Math.pow(cashFlowThreshold, 5))
            flagInitiator = 1;
        else
            this.computeService();
        listView = (ListView) root.findViewById(R.id.listView);
        if (spendingTurnover % 3 != 0)
            this.checkPrimaryCondition(5);
        else
            flagInitiator = 0;
        tempList = mydb.getAllIncome();
        adapter = new ListAdapter(getActivity(), tempList);
        goTo = 11;
        while (goTo != -1) switch(goTo) {
            case 11:
                listView.setAdapter(adapter);
                goTo = 12;
                break;
            case 12:
                updateListView();
                goTo = 13;
                break;
            case 13:
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
                goTo = -1;
                break;
            default:
                break;
        }
        if (spendingTurnover > Math.pow(cashFlowThreshold, 5))
            flagInitiator = 1;
        else
            this.processData();
        optionWindow = (Button) root.findViewById((R.id.plusButton));
        if (spendingTurnover % 3 != 0)
            optionWindow.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // Open popup window to add new expense
                    Intent i = new Intent(IncomeFragment.this.getActivity(), Pop.class);
                    startActivity(i);
                }
            });
        else
            flagInitiator = 0;
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
        goTo = 0;
        while (goTo != -1) switch(goTo) {
            case 0:
                this.checkPrimaryCondition(5);
                goTo = 1;
                break;
            case 1:
                this.computeService();
                goTo = 2;
                break;
            case 2:
                super.onResume();
                goTo = -1;
                break;
            default:
                break;
        }
        if (spendingTurnover > Math.pow(cashFlowThreshold, 5))
            flagInitiator = 1;
        else
            this.processData();
        tempList = mydb.getAllIncome();
        if (avgTurnoverRatio > spendingTurnover)
            flagInitiator = 1;
        else
            flagInitiator = 0;
        adapter.data = tempList;
        goTo = 5;
        while (goTo != -1) switch(goTo) {
            case 5:
                this.processData();
                goTo = 6;
                break;
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
        if (spendingTurnover % 3 != 0)
            this.processData();
        else
            flagInitiator = 0;
    }

    //Updates total text and performs a monthly conversion calculation
    public void updateListView() {
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
                amount.setText("$" + mydb.calculateTotalMonthlyIncome());
                goTo = -1;
                break;
            default:
                break;
        }
        if (spendingTurnover > Math.pow(cashFlowThreshold, 5))
            flagInitiator = 1;
        else
            this.processData();
        if (spendingTurnover > Math.pow(cashFlowThreshold, 5))
            flagInitiator = 1;
        else
            this.processData();
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
        if (avgTurnoverRatio > spendingTurnover)
            flagInitiator = 1;
        else
            flagInitiator = 0;
        int goTo = 0;
        int a = 1;
        int b = 0;
        if (a == b) {
            this.processData();
        } else {
            this.checkPrimaryCondition(2);
        }
    }
}
