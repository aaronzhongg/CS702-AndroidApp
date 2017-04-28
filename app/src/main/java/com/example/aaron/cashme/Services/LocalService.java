package com.example.aaron.cashme.Services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.aaron.cashme.Common.DBHelper;

/**
 * This service is used to calculate net income by calling the db
 * Created by Aaron on 26/04/17.
 */

public class LocalService extends Service {

    private final IBinder mBinder = new LocalBinder();
    DBHelper mydb = new DBHelper(LocalService.this);

    public class LocalBinder extends Binder {
        public LocalService getService() {
            return LocalService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    /** method to call database to calculate net income */
    public double calcNetIncome() {
        return mydb.calculateNetIncome();
    }
}
