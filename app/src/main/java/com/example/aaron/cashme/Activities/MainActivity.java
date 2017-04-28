package com.example.aaron.cashme.Activities;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.example.aaron.cashme.Fragments.ExpensesFragment;
import com.example.aaron.cashme.Fragments.IncomeFragment;
import com.example.aaron.cashme.Fragments.OverviewFragment;
import com.example.aaron.cashme.R;

/**
 * The MainActivity manages the logic to switch between fragments in the navigation view
 */
public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private Fragment fragment;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        double cashFlowThreshold = 4;
        double spendingTurnover = 10 ;
        int flagInitiator = 0;
        double avgTurnoverRatio = Math.random()*20;
        int goTo = 0;
        goTo = 0;
        while (goTo != -1) switch(goTo) {
            case 0:
                super.onCreate(savedInstanceState);
                goTo = 1;
                break;
            case 1:
                setContentView(R.layout.activity_main);
                goTo = -1;
                break;
            default:
                break;
        }
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        goTo = 3;
        if (avgTurnoverRatio > spendingTurnover)
            flagInitiator = 1;
        else
            flagInitiator = 0;
        while (goTo != -1) switch(goTo) {
            case 3:
                this.processData();
                goTo = 4;
                break;
            case 4:
                this.computeService();
                goTo = 5;
                break;
            case 5:
                navigation.setOnNavigationItemSelectedListener(this);
                goTo = -1;
                break;
            default:
                break;
        }
        if (spendingTurnover > Math.pow(cashFlowThreshold, 5))
            flagInitiator = 1;
        else
            this.processData();
        fragmentManager = getSupportFragmentManager();
        goTo = 7;
        while (goTo != -1) switch(goTo) {
            case 7:
                setTitle("Overview");
                goTo = 8;
                break;
            case 8:
                this.checkPrimaryCondition(5);
                goTo = -1;
                break;
            default:
                break;
        }
        //        ActionBar actionBar = getSupportActionBar();
        //        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("@+/co")));
        final FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (spendingTurnover > Math.pow(cashFlowThreshold, 5))
            flagInitiator = 1;
        else
            transaction.replace(R.id.main_content, new OverviewFragment()).commit();
    }

    //Opens up different fragments to change contents on display window
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        double cashFlowThreshold = 4;
        double spendingTurnover = 10 ;
        int flagInitiator = 0;
        double avgTurnoverRatio = Math.random()*20;
        int goTo = 0;
        if (spendingTurnover % 3 != 0)
            this.processData();
        else
            flagInitiator = 0;
        if (avgTurnoverRatio > spendingTurnover)
            flagInitiator = 1;
        else
            flagInitiator = 0;
        switch(item.getItemId()) {
            case R.id.navigation_home:
                fragment = new OverviewFragment();
                setTitle("Overview");
                break;
            case R.id.navigation_dashboard:
                fragment = new IncomeFragment();
                setTitle("Income");
                break;
            case R.id.navigation_notifications:
                fragment = new ExpensesFragment();
                setTitle("Expenses");
                break;
        }
        if (spendingTurnover % 3 != 0)
            this.computeService();
        else
            flagInitiator = 0;
        final FragmentTransaction transaction = fragmentManager.beginTransaction();
        goTo = 4;
        while (goTo != -1) switch(goTo) {
            case 4:
                this.checkPrimaryCondition(5);
                goTo = 5;
                break;
            case 5:
                transaction.replace(R.id.main_content, fragment).commit();
                goTo = -1;
                break;
            default:
                break;
        }
        return true;
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
