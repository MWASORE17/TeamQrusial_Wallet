package com.qrusial.wallet.view.menu;

/**
 * Created by Agus Manto on 21/03/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Spinner;

import com.qrusial.wallet.R;
import com.qrusial.wallet.model.entity.Account;
import com.qrusial.wallet.model.entity.User;
import com.qrusial.wallet.view.activity.Authentication;
import com.qrusial.wallet.view.authentication.Login;

public class AddAccount extends AppCompatActivity {

    private Spinner spinner1;
    private EditText account_name;
    private EditText initial_value;
    private TextInputLayout accountnamecontainer;
    private TextInputLayout initialvaluecontainer;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);

        spinner1 = (Spinner) findViewById(R.id.spinner);
        account_name = (EditText) findViewById(R.id.accountName);
        accountnamecontainer = (TextInputLayout) findViewById(R.id.account_name_container);
        initial_value = (EditText) findViewById(R.id.initialValue);
        initialvaluecontainer = (TextInputLayout) findViewById(R.id.initial_value_container);
        submit = (Button) findViewById(R.id.submitButton);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean _isvalid = true;
                accountnamecontainer.setErrorEnabled(false);
                initialvaluecontainer.setErrorEnabled(false);

                if (TextUtils.isEmpty(account_name.getText())) {
                    _isvalid = false;
                    accountnamecontainer.setErrorEnabled(true);
                    accountnamecontainer.setError("Account name is required");
                }
                else if (TextUtils.isEmpty(initial_value.getText())){
                    _isvalid = false;
                    initialvaluecontainer.setErrorEnabled(true);
                    initialvaluecontainer.setError("Value is required");
                }

                if (_isvalid) {
                    Account accountNew = new Account(account_name.getText().toString(), initial_value.getText().toString());
                    Account.accounts.add(accountNew);
                }
            }
        });
    }
}
