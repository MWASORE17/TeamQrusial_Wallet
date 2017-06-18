package com.qrusial.wallet.view.activity;

/**
 * Created by Angsono Putra on 21/03/2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.qrusial.wallet.R;


public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread thread = new Thread(){
            public void run() {
                try {
                    sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    startActivity(new Intent(SplashActivity.this,MainActivity.class));
                    finish();
                }
            }
        };
        thread.start();
    }
}
