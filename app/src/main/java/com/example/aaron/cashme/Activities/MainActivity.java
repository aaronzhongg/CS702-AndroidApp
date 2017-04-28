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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        fragmentManager = getSupportFragmentManager();

        setTitle("Overview");
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("@+/co")));
        final FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_content, new OverviewFragment()).commit();

    }

    //Opens up different fragments to change contents on display window

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
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

        final FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_content, fragment).commit();
        return true;
    }
}
