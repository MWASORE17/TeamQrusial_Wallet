package com.qrusial.wallet.view.activity;

/**
 * Created by Agus Manto on 21/03/2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;

import com.qrusial.wallet.R;
import com.qrusial.wallet.model.entity.IncomeHistory;
import com.qrusial.wallet.model.entity.User;
import com.qrusial.wallet.model.session.SessionManager;
import com.qrusial.wallet.view.menu.Content;

import java.util.ArrayList;

public class MainActivity extends Parent {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User a = new User("agus@mobile.id", "agus");
        User b = new User("angsono@mobile.id", "angsono");
        User c = new User("ferik@mobile.id", "ferik");
        User.users.add(a);
        User.users.add(b);
        User.users.add(c);


             /* checking the session */
        if (!SessionManager.with(getApplicationContext()).isuserlogin()) {
            this.doChangeActivity(getApplicationContext(), Authentication.class);
        }

        this.changefragment(new Content());
        this.setTitle("Wallet");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                SessionManager.with(getApplicationContext()).clearsession();
                Parent.doChangeActivity(getApplicationContext(), Authentication.class);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    public void changefragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.activity_main, fragment).commit();
    }
}
