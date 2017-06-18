package com.qrusial.wallet.view.menu;

/**
 * Created by Agus Manto on 10/04/2017.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.qrusial.wallet.R;

public class Tab1Income extends AppCompatActivity {

    private Button income;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab1income);

        income = (Button) findViewById(R.id.submitIncome);


        income.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), " ", Toast.LENGTH_LONG).show();
            }
        });

    }
}
