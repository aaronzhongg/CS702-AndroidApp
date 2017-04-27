package com.example.aaron.cashme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron on 16/04/17.
 * https://www.tutorialspoint.com/android/android_sqlite_database.htm
 *
 * This DBHelper manages all db queries to the income and expense tables
 */

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
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table income " +
                        "(id integer primary key, incomeName text, amount real, period integer)"
        );

        db.execSQL(
                "create table expense " +
                        "(id integer primary key, expenseName text, amount real, period integer)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS income");
        onCreate(db);
    }

    // Add new income into db
    public boolean insertIncome (String incomeName, double amount, int period) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("incomeName", incomeName);
        contentValues.put("amount", amount);
        contentValues.put("period", period);
        db.insert("income", null, contentValues);
        return true;
    }

    // Get all income data in db
    public ArrayList<IncomeExpenses> getAllIncome() {
        ArrayList<IncomeExpenses> incomeList = new ArrayList<IncomeExpenses>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor query =  db.rawQuery( "select * from income", null );
        query.moveToFirst();

        while(query.isAfterLast() == false){
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
        List<IncomeExpenses> ie = getAllIncome();
        double totalMonthlyIncome = 0.0;

        for (IncomeExpenses i: ie ) {
            switch (i.period) {
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
        //Open the database
        SQLiteDatabase database = this.getWritableDatabase();

        //Execute sql query to remove from database
        database.execSQL("DELETE FROM " + INCOME_TABLE_NAME + " WHERE " + INCOME_COLUMN_ID + "= " + id);

        //Close the database
        database.close();
    }

    // Add new expense into db
    public boolean insertExpense (String expenseName, double amount, int period) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("expenseName", expenseName);
        contentValues.put("amount", amount);
        contentValues.put("period", period);
        db.insert("expense", null, contentValues);
        return true;
    }

    // Gets all expense data in db
    public ArrayList<IncomeExpenses> getAllExpenses() {
        ArrayList<IncomeExpenses> expenseList = new ArrayList<IncomeExpenses>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor query =  db.rawQuery( "select * from expense", null );
        query.moveToFirst();

        while(query.isAfterLast() == false){
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
        List<IncomeExpenses> ie = getAllExpenses();
        double totalMonthlyExpense = 0.0;

        for (IncomeExpenses i: ie ) {
            switch (i.period) {
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
        //Open the database
        SQLiteDatabase database = this.getWritableDatabase();

        //Execute sql query to remove from database
        database.execSQL("DELETE FROM " + EXPENSE_TABLE_NAME + " WHERE " + EXPENSE_COLUMN_ID + "= " + id);

        //Close the database
        database.close();
    }

    // Total monthly income - total monthly expense
    public double calculateNetIncome() {
        double income = calculateTotalMonthlyIncome();
        double expenses = calculateTotalMonthlyExpenses();
        double netIncome = income - expenses;
        return netIncome;
    }
}
