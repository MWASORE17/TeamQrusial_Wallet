package com.qrusial.wallet.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.qrusial.wallet.R;
import com.qrusial.wallet.model.entity.ExpenseHistory;

/**
 * Created by Ferik Enedy on 01/06/2017.
 */

public class TabExpenseFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View _view = inflater.inflate(R.layout.tab2expense, container, false);
        init(_view);
        event();

        return _view;
    }

    Button btnAddExpense;
    EditText expenseValue;
    Spinner spinnerExpense;
    public void init(View view){
        btnAddExpense = (Button) view.findViewById(R.id.submitExpense);
        expenseValue = (EditText) view.findViewById(R.id.expenseValue);
        spinnerExpense = (Spinner) view.findViewById(R.id.spinnerExpense);
    }

    public void event() {
        //Untuk tidak memunculkan angka 0 pada ketikan pertama
        expenseValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String inputEt_income = s.toString();
                if (inputEt_income.startsWith("0")) {
//                    Toast.makeText(getBaseContext(),"Gak bisa pencet Nol",Toast.LENGTH_SHORT).show();
                    if (inputEt_income.length() > 0) {
                        expenseValue.setText(inputEt_income.substring(1));
                    } else {
                        expenseValue.setText("");
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        btnAddExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getItem = spinnerExpense.getSelectedItem().toString();


                if (expenseValue.getText() == null) {
                    Toast.makeText(getActivity(), "Please enter the value", Toast.LENGTH_SHORT).show();
                } else {
                    String getInput = expenseValue.getText().toString();
                    int getNominal = Integer.parseInt(getInput);
                    ExpenseHistory expenses = new ExpenseHistory(getItem, getNominal);
                    ExpenseHistory.arrayRecordExpense.add(expenses);
//                    ExpenseHistory.arrayRecordExpense.add(getItem + " = IDR. " + getInput);
                    Toast.makeText(getActivity(), "Submitted!!!", Toast.LENGTH_SHORT).show();
                    expenseValue.setText("");
                }
            }
        });
    }
}
