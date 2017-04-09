package com.example.aaron.cashme;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class IncomeFragment extends Fragment {


    public IncomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_income, container, false);


        Button minusClick;
        Button plusClick;
        Button updateAmount;
        final TextView amount;
        final EditText enteredAmount;

        minusClick = (Button)root.findViewById(R.id.decrement);
        plusClick = (Button)root.findViewById(R.id.increment);
        updateAmount = (Button) root.findViewById(R.id.newAmount);

        enteredAmount = (EditText) root.findViewById(R.id.dollarValue);

        amount = (TextView)root.findViewById(R.id.value);

        minusClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String amountValue = amount.getText().toString();

                int addedAmount = Integer.parseInt(amountValue);
                addedAmount--;

                amount.setText(String.valueOf(addedAmount));
            }
        });


        plusClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amountValue = amount.getText().toString();

                int addedAmount = Integer.parseInt(amountValue);
                addedAmount++;

                amount.setText(String.valueOf(addedAmount));

            }
        });

        updateAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String entered = enteredAmount.getText().toString();

                amount.setText(String.valueOf(entered));
            }
        });


    return root;
    }



}
