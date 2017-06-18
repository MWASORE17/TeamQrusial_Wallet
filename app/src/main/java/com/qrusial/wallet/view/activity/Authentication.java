package com.qrusial.wallet.view.activity;

/**
 * Created by Agus Manto on 21/03/2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.qrusial.wallet.R;
import com.qrusial.wallet.view.authentication.Login;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Authentication extends Parent {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        changefragment(new Login());
        this.setTitle("Wallet");
    }

    public static boolean isemailvalid(String email) {
        String _expression = "^[a-z]([a-z0-9-\\.]+)?+@[a-z]+\\.[a-z]{2,4}+(\\.[a-z]{2,4})?$";
        CharSequence _email = email;
        Pattern _pattern = Pattern.compile(_expression, Pattern.CASE_INSENSITIVE);
        Matcher _mathcer = _pattern.matcher(_email);

        if (_mathcer.matches()) {
            return true;
        }
        return false;
    }

    public static boolean ispasswordvalid(String password) {
        String _expression = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[@!\\*?$&\\^#-])[\\w@!\\*?$&\\^#-]{8,}$";
        CharSequence _password = password;
        Pattern _pattern = Pattern.compile(_expression, Pattern.CASE_INSENSITIVE);
        Matcher _mathcer = _pattern.matcher(_password);

        if (_mathcer.matches()) {
            return true;
        }
        return false;
    }

    public void changefragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.activity_auth, fragment).commit();
    }

}
