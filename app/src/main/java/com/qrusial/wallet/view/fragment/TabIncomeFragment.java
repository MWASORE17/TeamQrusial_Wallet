package com.qrusial.wallet.view.fragment;

import android.os.Bundle;
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
import com.qrusial.wallet.model.entity.IncomeHistory;

/**
 * Created by Ferik Enedy on 01/06/2017.
 */

public class TabIncomeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View _view = inflater.inflate(R.layout.tab1income, container, false);
        init(_view);
        event();

        return _view;
    }

    Button btnAddIncome;
    EditText incomeValue;
    Spinner spinnerIncome;
    public void init(View view){
        btnAddIncome = (Button) view.findViewById(R.id.submitIncome);
        incomeValue = (EditText) view.findViewById(R.id.incomeValue);
        spinnerIncome = (Spinner) view.findViewById(R.id.spinnerIncome);
    }

    public void event() {
        //Untuk tidak memunculkan angka 0 pada ketikan pertama
        incomeValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String inputEt_income = s.toString();
                if (inputEt_income.startsWith("0")) {
//                    Toast.makeText(getBaseContext(),"Gak bisa input 0",Toast.LENGTH_SHORT).show();
                    if (inputEt_income.length() > 0) {
                        incomeValue.setText(inputEt_income.substring(1));
                    } else {
                        incomeValue.setText("");
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        btnAddIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getItem = spinnerIncome.getSelectedItem().toString();

                if (incomeValue.getText() == null) {
                    Toast.makeText(getActivity(), "Submitted!!!", Toast.LENGTH_SHORT).show();
                } else {
                    String getInput = incomeValue.getText().toString();
                    int getNominal = Integer.parseInt(getInput);
                    IncomeHistory incomes = new IncomeHistory(getItem, getNominal);
                    IncomeHistory.arrayRecordIncome.add(incomes);
                    Toast.makeText(getActivity(), "Submitted!!!", Toast.LENGTH_SHORT).show();
                    incomeValue.setText("");
                }
            }
        });
    }
}
