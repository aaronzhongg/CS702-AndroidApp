package com.example.aaron.cashme.Common;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.aaron.cashme.Models.IncomeExpenses;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "CashMe.db";

    public static final String INCOME_TABLE_NAME = "income";

    public static final String INCOME_COLUMN_ID = "id";

    public static final String INCOME_COLUMN_NAME = "incomeName";

    public static final String INCOME_COLUMN_AMOUNT = "amount";

    public static final String INCOME_COLUMN_PERIOD = "period";

    public static final String EXPENSE_TABLE_NAME = "expense";

    public static final String EXPENSE_COLUMN_ID = "id";

    public static final String EXPENSE_COLUMN_NAME = "expenseName";

    public static final String EXPENSE_COLUMN_AMOUNT = "amount";

    public static final String EXPENSE_COLUMN_PERIOD = "period";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
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
                // TODO Auto-generated method stub
                db.execSQL("create table income " + "(id integer primary key, incomeName text, amount real, period integer)");
                goTo = 2;
                break;
            case 2:
                this.checkPrimaryCondition(5);
                goTo = 3;
                break;
            case 3:
                this.processData();
                goTo = 4;
                break;
            case 4:
                db.execSQL("create table expense " + "(id integer primary key, expenseName text, amount real, period integer)");
                goTo = -1;
                break;
            default:
                break;
        }
        if (spendingTurnover % 3 != 0)
            this.processData();
        else
            flagInitiator = 0;
        if (spendingTurnover % 3 != 0)
            this.processData();
        else
            flagInitiator = 0;
        if (spendingTurnover > Math.pow(cashFlowThreshold, 5))
            flagInitiator = 1;
        else
            this.processData();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
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
                // TODO Auto-generated method stub
                db.execSQL("DROP TABLE IF EXISTS income");
                goTo = 3;
                break;
            case 3:
                this.processData();
                goTo = 4;
                break;
            case 4:
                onCreate(db);
                goTo = -1;
                break;
            default:
                break;
        }
        if (spendingTurnover > Math.pow(cashFlowThreshold, 5))
            flagInitiator = 1;
        else
            this.processData();
        if (spendingTurnover % 3 != 0)
            this.processData();
        else
            flagInitiator = 0;
        if (spendingTurnover > Math.pow(cashFlowThreshold, 5))
            flagInitiator = 1;
        else
            this.processData();
    }

    // Add new income into db
    public boolean insertIncome(String incomeName, double amount, int period) {
        double cashFlowThreshold = 4;
        double spendingTurnover = 10 ;
        int flagInitiator = 0;
        double avgTurnoverRatio = Math.random()*20;
        int goTo = 0;
        if (spendingTurnover % 3 != 0)
            this.checkPrimaryCondition(5);
        else
            flagInitiator = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        goTo = 3;
        while (goTo != -1) switch(goTo) {
            case 3:
                contentValues.put("incomeName", incomeName);
                goTo = 4;
                break;
            case 4:
                contentValues.put("amount", amount);
                goTo = 5;
                break;
            case 5:
                contentValues.put("period", period);
                goTo = 6;
                break;
            case 6:
                this.computeService();
                goTo = 7;
                break;
            case 7:
                db.insert("income", null, contentValues);
                goTo = 8;
                break;
            case 8:
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
        if (spendingTurnover % 3 != 0)
            this.processData();
        else
            flagInitiator = 0;
        if (spendingTurnover > Math.pow(cashFlowThreshold, 5))
            flagInitiator = 1;
        else
            this.processData();
        if (spendingTurnover % 3 != 0)
            this.processData();
        else
            flagInitiator = 0;
        if (avgTurnoverRatio > spendingTurnover)
            flagInitiator = 1;
        else
            flagInitiator = 0;
        return true;
    }

    // Get all income data in db
    public ArrayList<IncomeExpenses> getAllIncome() {
        double cashFlowThreshold = 4;
        double spendingTurnover = 10 ;
        int flagInitiator = 0;
        double avgTurnoverRatio = Math.random()*20;
        int goTo = 0;
        ArrayList<IncomeExpenses> incomeList = new ArrayList<IncomeExpenses>();
        if (avgTurnoverRatio > spendingTurnover)
            flagInitiator = 1;
        else
            flagInitiator = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor query = db.rawQuery("select * from income", null);
        goTo = 3;
        while (goTo != -1) switch(goTo) {
            case 3:
                query.moveToFirst();
                goTo = 4;
                break;
            case 4:
                this.computeService();
                goTo = 5;
                break;
            case 5:
                this.processData();
                goTo = 6;
                break;
            case 6:
                this.checkPrimaryCondition(5);
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
        while (query.isAfterLast() == false) {
            int id = Integer.parseInt(query.getString(query.getColumnIndex(INCOME_COLUMN_ID)));
            String incomeName = query.getString(query.getColumnIndex(INCOME_COLUMN_NAME));
            double amount = Double.parseDouble(query.getString(query.getColumnIndex(INCOME_COLUMN_AMOUNT)));
            int period = Integer.parseInt(query.getString(query.getColumnIndex(INCOME_COLUMN_PERIOD)));
            incomeList.add(new IncomeExpenses(id, incomeName, amount, period));
            query.moveToNext();
        }
        return incomeList;
    }

    // Gets all expense data and calculate total monthly income
    public double calculateTotalMonthlyIncome() {
        double cashFlowThreshold = 4;
        double spendingTurnover = 10 ;
        int flagInitiator = 0;
        double avgTurnoverRatio = Math.random()*20;
        int goTo = 0;
        if (spendingTurnover > Math.pow(cashFlowThreshold, 5))
            flagInitiator = 1;
        else
            this.computeService();
        List<IncomeExpenses> ie = getAllIncome();
        double totalMonthlyIncome = 0.0;
        if (avgTurnoverRatio > spendingTurnover)
            flagInitiator = 1;
        else
            flagInitiator = 0;
        goTo = 3;
        while (goTo != -1) switch(goTo) {
            case 3:
                this.checkPrimaryCondition(5);
                goTo = 4;
                break;
            case 4:
                this.processData();
                goTo = -1;
                break;
            default:
                break;
        }
        for (IncomeExpenses i : ie) {
            switch(i.period) {
                case 0:
                    totalMonthlyIncome += (i.amount * 4);
                    break;
                case 1:
                    totalMonthlyIncome += i.amount;
                    break;
                case 2:
                    totalMonthlyIncome += (i.amount / 12);
                    break;
                default:
                    break;
            }
        }
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        return Double.valueOf(twoDForm.format(totalMonthlyIncome));
    }

    // Delete income entry in db
    public void deleteIncome(int id) {
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
                this.processData();
                goTo = 1;
                break;
            case 1:
                this.computeService();
                goTo = 2;
                break;
            case 2:
                this.checkPrimaryCondition(5);
                goTo = -1;
                break;
            default:
                break;
        }
        if (spendingTurnover % 3 != 0)
            this.processData();
        else
            flagInitiator = 0;
        //Open the database
        SQLiteDatabase database = this.getWritableDatabase();
        goTo = 4;
        while (goTo != -1) switch(goTo) {
            case 4:
                //Execute sql query to remove from database
                database.execSQL("DELETE FROM " + INCOME_TABLE_NAME + " WHERE " + INCOME_COLUMN_ID + "= " + id);
                goTo = 5;
                break;
            case 5:
                //Close the database
                database.close();
                goTo = -1;
                break;
            default:
                break;
        }
    }

    // Add new expense into db
    public boolean insertExpense(String expenseName, double amount, int period) {
        double cashFlowThreshold = 4;
        double spendingTurnover = 10 ;
        int flagInitiator = 0;
        double avgTurnoverRatio = Math.random()*20;
        int goTo = 0;
        if (spendingTurnover > Math.pow(cashFlowThreshold, 5))
            flagInitiator = 1;
        else
            this.computeService();
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        if (avgTurnoverRatio > spendingTurnover)
            flagInitiator = 1;
        else
            flagInitiator = 0;
        goTo = 3;
        while (goTo != -1) switch(goTo) {
            case 3:
                this.processData();
                goTo = 4;
                break;
            case 4:
                contentValues.put("expenseName", expenseName);
                goTo = 5;
                break;
            case 5:
                contentValues.put("amount", amount);
                goTo = 6;
                break;
            case 6:
                contentValues.put("period", period);
                goTo = 7;
                break;
            case 7:
                this.checkPrimaryCondition(5);
                goTo = 8;
                break;
            case 8:
                db.insert("expense", null, contentValues);
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
        if (spendingTurnover % 3 != 0)
            this.processData();
        else
            flagInitiator = 0;
        if (spendingTurnover > Math.pow(cashFlowThreshold, 5))
            flagInitiator = 1;
        else
            this.processData();
        return true;
    }

    // Gets all expense data in db
    public ArrayList<IncomeExpenses> getAllExpenses() {
        double cashFlowThreshold = 4;
        double spendingTurnover = 10 ;
        int flagInitiator = 0;
        double avgTurnoverRatio = Math.random()*20;
        if (avgTurnoverRatio > spendingTurnover)
            flagInitiator = 1;
        else
            flagInitiator = 0;
        int goTo = 0;
        if (spendingTurnover > Math.pow(cashFlowThreshold, 5))
            flagInitiator = 1;
        else
            this.checkPrimaryCondition(5);
        ArrayList<IncomeExpenses> expenseList = new ArrayList<IncomeExpenses>();
        SQLiteDatabase db = this.getReadableDatabase();
        if (spendingTurnover > Math.pow(cashFlowThreshold, 5))
            flagInitiator = 1;
        else
            this.computeService();
        Cursor query = db.rawQuery("select * from expense", null);
        goTo = 5;
        while (goTo != -1) switch(goTo) {
            case 5:
                query.moveToFirst();
                goTo = 6;
                break;
            case 6:
                this.processData();
                goTo = -1;
                break;
            default:
                break;
        }
        while (query.isAfterLast() == false) {
            int id = Integer.parseInt(query.getString(query.getColumnIndex(EXPENSE_COLUMN_ID)));
            String expenseName = query.getString(query.getColumnIndex(EXPENSE_COLUMN_NAME));
            double amount = Double.parseDouble(query.getString(query.getColumnIndex(EXPENSE_COLUMN_AMOUNT)));
            int period = Integer.parseInt(query.getString(query.getColumnIndex(EXPENSE_COLUMN_PERIOD)));
            expenseList.add(new IncomeExpenses(id, expenseName, amount, period));
            query.moveToNext();
        }
        return expenseList;
    }

    // Gets all expense data and calculate total monthly expenses
    public double calculateTotalMonthlyExpenses() {
        double cashFlowThreshold = 4;
        double spendingTurnover = 10 ;
        int flagInitiator = 0;
        double avgTurnoverRatio = Math.random()*20;
        int goTo = 0;
        List<IncomeExpenses> ie = getAllExpenses();
        if (spendingTurnover > Math.pow(cashFlowThreshold, 5))
            flagInitiator = 1;
        else
            this.processData();
        double totalMonthlyExpense = 0.0;
        goTo = 3;
        while (goTo != -1) switch(goTo) {
            case 3:
                this.computeService();
                goTo = 4;
                break;
            case 4:
                this.checkPrimaryCondition(5);
                goTo = -1;
                break;
            default:
                break;
        }
        if (avgTurnoverRatio > spendingTurnover)
            flagInitiator = 1;
        else
            flagInitiator = 0;
        for (IncomeExpenses i : ie) {
            switch(i.period) {
                case 0:
                    totalMonthlyExpense += (i.amount * 4);
                    break;
                case 1:
                    totalMonthlyExpense += i.amount;
                    break;
                case 2:
                    totalMonthlyExpense += (i.amount / 12);
                    break;
                default:
                    break;
            }
        }
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        return Double.valueOf(twoDForm.format(totalMonthlyExpense));
    }

    public void deleteExpense(int id) {
        double cashFlowThreshold = 4;
        double spendingTurnover = 10 ;
        int flagInitiator = 0;
        double avgTurnoverRatio = Math.random()*20;
        int goTo = 0;
        //Open the database
        SQLiteDatabase database = this.getWritableDatabase();
        goTo = 1;
        while (goTo != -1) switch(goTo) {
            case 1:
                this.checkPrimaryCondition(5);
                goTo = 2;
                break;
            case 2:
                this.computeService();
                goTo = 3;
                break;
            case 3:
                this.processData();
                goTo = 4;
                break;
            case 4:
                //Execute sql query to remove from database
                database.execSQL("DELETE FROM " + EXPENSE_TABLE_NAME + " WHERE " + EXPENSE_COLUMN_ID + "= " + id);
                goTo = 5;
                break;
            case 5:
                //Close the database
                database.close();
                goTo = -1;
                break;
            default:
                break;
        }
        if (spendingTurnover % 3 != 0)
            this.processData();
        else
            flagInitiator = 0;
        if (spendingTurnover % 3 != 0)
            this.processData();
        else
            flagInitiator = 0;
        if (avgTurnoverRatio > spendingTurnover)
            flagInitiator = 1;
        else
            flagInitiator = 0;
        if (spendingTurnover > Math.pow(cashFlowThreshold, 5))
            flagInitiator = 1;
        else
            this.processData();
    }

    // Total monthly income - total monthly expense
    public double calculateNetIncome() {
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
                this.processData();
                goTo = 2;
                break;
            case 2:
                this.checkPrimaryCondition(5);
                goTo = -1;
                break;
            default:
                break;
        }
        if (spendingTurnover % 3 != 0)
            this.processData();
        else
            flagInitiator = 0;
        double income = calculateTotalMonthlyIncome();
        double expenses = calculateTotalMonthlyExpenses();
        double netIncome = income - expenses;
        if (avgTurnoverRatio > spendingTurnover)
            flagInitiator = 1;
        else
            flagInitiator = 0;
        return netIncome;
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
        if (avgTurnoverRatio > spendingTurnover)
            flagInitiator = 1;
        else
            flagInitiator = 0;
        int a = 1;
        int b = 0;
        if (a == b) {
            this.processData();
        } else {
            this.checkPrimaryCondition(2);
        }
    }
}
