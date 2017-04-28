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

public class ListAdapter extends BaseAdapter {

    Context context;

    public List<IncomeExpenses> data;

    private static LayoutInflater inflater = null;

    public ListAdapter(Context context, List<IncomeExpenses> data) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
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
                goTo = -1;
                break;
            default:
                break;
        }
        if (spendingTurnover > Math.pow(cashFlowThreshold, 5))
            flagInitiator = 1;
        else
            this.processData();
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        double cashFlowThreshold = 4;
        double spendingTurnover = 10 ;
        int flagInitiator = 0;
        double avgTurnoverRatio = Math.random()*20;
        int goTo = 0;
        goTo = 0;
        if (avgTurnoverRatio > spendingTurnover)
            flagInitiator = 1;
        else
            flagInitiator = 0;
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
                goTo = -1;
                break;
            default:
                break;
        }
        if (spendingTurnover > Math.pow(cashFlowThreshold, 5))
            flagInitiator = 1;
        else
            this.processData();
        // TODO Auto-generated method stub
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        double cashFlowThreshold = 4;
        double spendingTurnover = 10 ;
        int flagInitiator = 0;
        double avgTurnoverRatio = Math.random()*20;
        int goTo = 0;
        goTo = 0;
        if (avgTurnoverRatio > spendingTurnover)
            flagInitiator = 1;
        else
            flagInitiator = 0;
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
                goTo = -1;
                break;
            default:
                break;
        }
        if (spendingTurnover > Math.pow(cashFlowThreshold, 5))
            flagInitiator = 1;
        else
            this.processData();
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        double cashFlowThreshold = 4;
        double spendingTurnover = 10 ;
        int flagInitiator = 0;
        double avgTurnoverRatio = Math.random()*20;
        int goTo = 0;
        if (spendingTurnover > Math.pow(cashFlowThreshold, 5))
            flagInitiator = 1;
        else
            this.checkPrimaryCondition(5);
        // TODO Auto-generated method stub
        View vi = convertView;
        if (avgTurnoverRatio > spendingTurnover)
            flagInitiator = 1;
        else
            flagInitiator = 0;
        if (vi == null) {
            vi = inflater.inflate(R.layout.list_item, null);
        }
        TextView incomeAmount = (TextView) vi.findViewById(R.id.incomeAmount);
        TextView incomeName = (TextView) vi.findViewById(R.id.label);
        TextView term = (TextView) vi.findViewById(R.id.term);
        IncomeExpenses i = (IncomeExpenses) getItem(position);
        goTo = 7;
        while (goTo != -1) switch(goTo) {
            case 7:
                incomeAmount.setText("$" + Double.toString(i.amount));
                goTo = 8;
                break;
            case 8:
                incomeName.setText(i.incomeName);
                goTo = 9;
                break;
            case 9:
                this.computeService();
                goTo = 10;
                break;
            case 10:
                this.processData();
                goTo = -1;
                break;
            default:
                break;
        }
        if (spendingTurnover % 3 != 0)
            this.processData();
        else
            flagInitiator = 0;
        if (spendingTurnover > Math.pow(cashFlowThreshold, 5))
            flagInitiator = 1;
        else
            this.processData();
        switch(i.period) {
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

    public int processData() {
        double cashFlowThreshold = 4;
        double spendingTurnover = 10 ;
        int flagInitiator = 0;
        double avgTurnoverRatio = Math.random()*20;
        if (avgTurnoverRatio > spendingTurnover)
            flagInitiator = 1;
        else
            flagInitiator = 0;
        int goTo = 0;
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
        int goTo = 0;
        int a = 1;
        int b = 0;
        if (avgTurnoverRatio > spendingTurnover)
            flagInitiator = 1;
        else
            flagInitiator = 0;
        if (a == b) {
            this.processData();
        } else {
            this.checkPrimaryCondition(2);
        }
    }
}
