package com.example.aaron.cashme.Fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aaron.cashme.Services.LocalService;
import com.example.aaron.cashme.R;
import com.example.aaron.cashme.Services.OverviewFragmentServiceConnection;


/**
 * A simple {@link Fragment} subclass.
 */
public class OverviewFragment extends Fragment {

    TextView netIncomeTextView;
    private OverviewFragmentServiceConnection mConnection = new OverviewFragmentServiceConnection(this);
//    LocalService mService;

    public OverviewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_overview, container, false);

        // Bind to service
        bindService();

        // Link all ui elements
        netIncomeTextView = (TextView) root.findViewById(R.id.netIncomeTextView);

        // Inflate the layout for this fragment
        return root;
    }

    // stops service running
    @Override
    public void onDestroy() {
        super.onDestroy();

        // Unbind service
        getActivity().unbindService(mConnection);
    }



    void bindService() {
        getActivity().bindService(new Intent(getActivity(),
                LocalService.class), mConnection, Context.BIND_AUTO_CREATE);
    }

    public void refreshView() {
        netIncomeTextView.setText("$" + mConnection.mService.calcNetIncome());
    }
}
