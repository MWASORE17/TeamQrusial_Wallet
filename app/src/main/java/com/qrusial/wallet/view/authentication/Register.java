package com.qrusial.wallet.view.authentication;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.qrusial.wallet.R;
import com.qrusial.wallet.model.entity.User;
import com.qrusial.wallet.view.activity.Authentication;

/**
 * Created by Agus Manto on 21/03/2017.
 */

public class Register extends Fragment {

    private Button login;
    private TextInputLayout register_email;
    private TextInputLayout register_password;
    private TextInputLayout register_repassword;
    private TextInputLayout register_wallet;
    private EditText et_email;
    private EditText et_password;
    private EditText et_repassword;
    private EditText et_wallet;
    private Button btn_register;


    public Register() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View _view = inflater.inflate(R.layout.fragment_register, container, false);

        init(_view);
        event();

        return _view;
    }

    private void init(View view) {
        login = (Button) view.findViewById(R.id.register_login);
        register_email = (TextInputLayout) view.findViewById(R.id.register_email_container);
        register_password = (TextInputLayout) view.findViewById(R.id.register_password_container);
        register_repassword = (TextInputLayout) view.findViewById(R.id.register_repassword_container);
//        register_wallet = (TextInputLayout) view.findViewById(R.id.register_wallet_container);
        btn_register = (Button) view.findViewById(R.id.register_register);
        et_email = (EditText) view.findViewById(R.id.register_email);
        et_password = (EditText) view.findViewById(R.id.register_password);
        et_repassword = (EditText) view.findViewById(R.id.register_repassword);
//        et_wallet = (EditText)view.findViewById(R.id.register_wallet);
    }

    private void event() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Authentication) getActivity()).changefragment(new Login());
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean _isvalid = true;
                register_email.setErrorEnabled(false);
                register_password.setErrorEnabled(false);
                register_repassword.setErrorEnabled(false);

                if (TextUtils.isEmpty(et_email.getText())) {
                    _isvalid = false;
                    register_email.setErrorEnabled(true);
                    register_email.setError("Email is required");
                } else if (!Authentication.isemailvalid(et_email.getText().toString())) {
                    _isvalid = false;
                    register_email.setErrorEnabled(true);
                    register_email.setError("Email is not valid");
                } else if (TextUtils.isEmpty(et_password.getText())) {
                    _isvalid = false;
                    register_password.setErrorEnabled(true);
                    register_password.setError("Password is required");
                } else if (!Authentication.ispasswordvalid(et_password.getText().toString())) {
                    _isvalid = false;
                    register_password.setErrorEnabled(true);
                    register_password.setError("Password is not valid. Password must contains at least 1 lowercase, 1 uppercase, 1 number, 1 special character and minimum 8 characters");
                } else if (TextUtils.isEmpty(et_repassword.getText())) {
                    _isvalid = false;
                    register_repassword.setErrorEnabled(true);
                    register_repassword.setError("Re-Password is required");
                } else if (!et_password.getText().toString().equals(et_repassword.getText().toString())) {
                    _isvalid = false;
                    register_repassword.setErrorEnabled(true);
                    register_repassword.setError("Password not match");
                }

                if (_isvalid) {
                    User userNew = new User(et_email.getText().toString(), et_password.getText().toString());
                    User.users.add(userNew);
                    ((Authentication) getActivity()).changefragment(new Login());
                }
            }
        });
    }

}
