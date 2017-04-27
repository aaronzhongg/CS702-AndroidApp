package com.example.aaron.cashme;

/**
 * This is a basic data structure for income and expense information
 *
 * Created by Aaron on 20/04/17.
 */

public class IncomeExpenses {

    int id;
    String incomeName;
    double amount;
    int period;

    public IncomeExpenses(int i, String in, double a, int p) {
        id = i;
        incomeName = in;
        amount = a;
        period = p;
    }
}
