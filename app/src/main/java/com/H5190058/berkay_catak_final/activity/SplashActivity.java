package com.H5190058.berkay_catak_final.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;

import com.H5190058.berkay_catak_final.R;
import com.H5190058.berkay_catak_final.util.InternetUtil;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();

    }

    private void init(){
        if(checkInternetInSplash()){
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
    }

    private void openActivity(){
        Intent yeniIntent = new Intent(getBaseContext(), HomeActivity.class);
        startActivity(yeniIntent);
        finish();
    }

    private boolean checkInternetInSplash() {
        if (!InternetUtil.checkInternet(getApplicationContext())){
            noInternetAlert();
            return false;
        }
        else{
            return true;
        }
    }

    private void noInternetAlert() {
        final AlertDialog.Builder builder = new AlertDialog.Builder( SplashActivity.this );
        builder.setMessage(getResources().getString(R.string.internetYok));
        builder.setCancelable( true );
        builder.setNegativeButton( getResources().getString(R.string.internetYokCikis),new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setPositiveButton( getResources().getString(R.string.internetYokAyarlar), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(Settings.ACTION_SETTINGS));
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
