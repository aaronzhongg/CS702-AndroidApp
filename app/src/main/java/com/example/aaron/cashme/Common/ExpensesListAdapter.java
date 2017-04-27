package com.example.aaron.cashme.Common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.aaron.cashme.Models.IncomeExpenses;
import com.example.aaron.cashme.R;

import java.util.List;

/**
 * This is a list adapter to manage the expense list
 *
 * Created by Aaron on 22/04/17.
 */

public class ExpensesListAdapter extends BaseAdapter {
    Context context;
    public List<IncomeExpenses> data;
    private static LayoutInflater inflater = null;

    public ExpensesListAdapter(Context context, List<IncomeExpenses> data) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View vi = convertView;
        if (vi == null) {
            vi = inflater.inflate(R.layout.expenses_list_item, null);
        }

        TextView incomeAmount = (TextView) vi.findViewById(R.id.expenseListAmount);
        TextView incomeName = (TextView) vi.findViewById(R.id.expenseLabel);
        TextView term = (TextView) vi.findViewById(R.id.expenseTerm);
        IncomeExpenses i = (IncomeExpenses) getItem(position);

        incomeAmount.setText("$" + Double.toString(i.amount));
        incomeName.setText(i.incomeName);

        switch (i.period) {
            case 0:
                term.setText("Per Week");
                break;
            case 1:
                term.setText("Per Month");
                break;
            case 2:
                term.setText("Per Year");
                break;
            default:
                break;
        }

        return vi;
    }
}
