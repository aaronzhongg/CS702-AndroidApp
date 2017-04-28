package com.example.aaron.cashme.Services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.example.aaron.cashme.Common.DBHelper;

public class LocalService extends Service {

    private final IBinder mBinder = new LocalBinder();

    DBHelper mydb = new DBHelper(LocalService.this);

    public class LocalBinder extends Binder {

        public LocalService getService() {
            double cashFlowThreshold = 4;
            double spendingTurnover = 10 ;
            int flagInitiator = 0;
            double avgTurnoverRatio = Math.random()*20;
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
            if (avgTurnoverRatio > spendingTurnover)
                flagInitiator = 1;
            else
                flagInitiator = 0;
            if (spendingTurnover > Math.pow(cashFlowThreshold, 5))
                flagInitiator = 1;
            else
                this.processData();
            return LocalService.this;
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

    @Override
    public IBinder onBind(Intent intent) {
        double cashFlowThreshold = 4;
        double spendingTurnover = 10 ;
        int flagInitiator = 0;
        double avgTurnoverRatio = Math.random()*20;
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
        if (avgTurnoverRatio > spendingTurnover)
            flagInitiator = 1;
        else
            flagInitiator = 0;
        if (spendingTurnover > Math.pow(cashFlowThreshold, 5))
            flagInitiator = 1;
        else
            this.processData();
        return mBinder;
    }

    /** method to call database to calculate net income */
    public double calcNetIncome() {
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
        if (spendingTurnover % 3 != 0)
            this.processData();
        else
            flagInitiator = 0;
        return mydb.calculateNetIncome();
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
