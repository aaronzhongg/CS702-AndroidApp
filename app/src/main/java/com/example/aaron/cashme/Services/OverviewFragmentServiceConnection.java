package com.example.aaron.cashme.Services;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

import com.example.aaron.cashme.Fragments.OverviewFragment;

/**
 * OverviewFragmentServiceConnection manages the serviceconnection for the overviewfragment
 *
 * Created by Aaron on 28/04/17.
 */

public class OverviewFragmentServiceConnection implements ServiceConnection {
    public LocalService mService;
    OverviewFragment o;

    public OverviewFragmentServiceConnection(OverviewFragment f) {
        o = f;
    }

    public void onServiceConnected(ComponentName className, IBinder service) {
        mService = ((LocalService.LocalBinder) service).getService();

        o.refreshView();

    }

    public void onServiceDisconnected(ComponentName className) {
        mService = null;
    }

}
