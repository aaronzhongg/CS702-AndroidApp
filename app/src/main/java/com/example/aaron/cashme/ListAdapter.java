package com.example.aaron.cashme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * This is a list adapter to manage the income list
 *
 * Created by Aaron on 17/04/17.
 */

public class ListAdapter extends BaseAdapter {
    Context context;
    List<IncomeExpenses> data;
    private static LayoutInflater inflater = null;

    public ListAdapter(Context context, List<IncomeExpenses> data) {
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
            vi = inflater.inflate(R.layout.list_item, null);
        }

        TextView incomeAmount = (TextView) vi.findViewById(R.id.incomeAmount);
        TextView incomeName = (TextView) vi.findViewById(R.id.label);
        TextView term = (TextView) vi.findViewById(R.id.term);
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
