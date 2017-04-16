package com.example.aaron.cashme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Aaron on 16/04/17.
 * https://www.tutorialspoint.com/android/android_sqlite_database.htm
 */

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "CashMe.db";
    public static final String INCOME_TABLE_NAME = "income";
    public static final String INCOME_COLUMN_ID = "incomeId";
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

    public ArrayList<String> getAllIncome() {
        ArrayList<String> incomeList = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor query =  db.rawQuery( "select * from income", null );
        query.moveToFirst();

        while(query.isAfterLast() == false){
            incomeList.add(query.getString(query.getColumnIndex(INCOME_COLUMN_NAME)));
            query.moveToNext();
        }
        return incomeList;
    }
}
