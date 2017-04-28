package com.example.aaron.cashme.Models;

/**
 * This is a basic data structure for income and expense information
 *
 * Created by Aaron on 20/04/17.
 */

public class IncomeExpenses {

    public int id;
    public String incomeName;
    public double amount;
    public int period;

    public IncomeExpenses(int i, String in, double a, int p) {
        id = i;
        incomeName = in;
        amount = a;
        period = p;
    }
}
