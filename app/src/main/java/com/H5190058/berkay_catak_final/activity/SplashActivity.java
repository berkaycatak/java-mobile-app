package com.H5190058.berkay_catak_final.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.H5190058.berkay_catak_final.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();

    }

    private void init(){
        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    openActivity();
                }
            }
        };
        timerThread.start();
    }

    private void openActivity(){
        Intent yeniIntent = new Intent(getBaseContext(), HomeActivity.class);
        startActivity(yeniIntent);
        finish();
    }
}
