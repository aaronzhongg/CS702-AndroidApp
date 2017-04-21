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
 */

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "CashMe.db";
    public static final String INCOME_TABLE_NAME = "income";
    public static final String INCOME_COLUMN_ID = "id";
    public static final String INCOME_COLUMN_NAME = "incomeName";
    public static final String INCOME_COLUMN_AMOUNT = "amount";
    public static final String INCOME_COLUMN_PERIOD = "period";

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
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS income");
        onCreate(db);
    }

    public boolean insertIncome (String incomeName, double amount, int period) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("incomeName", incomeName);
        contentValues.put("amount", amount);
        contentValues.put("period", period);
        db.insert("income", null, contentValues);
        return true;
    }

    public ArrayList<IncomeExpenses> getAllIncome() {
        ArrayList<IncomeExpenses> incomeList = new ArrayList<IncomeExpenses>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor query =  db.rawQuery( "select * from income", null );
        query.moveToFirst();
//        IncomeExpenses temp = new IncomeExpenses();

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

    public void deleteIncome(int id) {
        //Open the database
        SQLiteDatabase database = this.getWritableDatabase();

        //Execute sql query to remove from database
        database.execSQL("DELETE FROM " + INCOME_TABLE_NAME + " WHERE " + INCOME_COLUMN_ID + "= " + id);

        //Close the database
        database.close();
    }
}
