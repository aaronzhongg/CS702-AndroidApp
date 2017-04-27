package com.example.aaron.cashme;


import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class OverviewFragment extends Fragment {

    TextView netIncomeTextView;
    LocalService mService;


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

    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {
            mService = ((LocalService.LocalBinder) service).getService();
            netIncomeTextView.setText("$" + mService.calcNetIncome());
        }

        public void onServiceDisconnected(ComponentName className) {
            mService = null;
        }
    };

    void bindService() {
        getActivity().bindService(new Intent(getActivity(),
                LocalService.class), mConnection, Context.BIND_AUTO_CREATE);
    }

}
