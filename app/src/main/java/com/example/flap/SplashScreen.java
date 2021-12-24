package com.example.flap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.flap.ui.DrawerSection.merchants.authentic.LoginActivity;
import com.example.flap.ui.DrawerSection.merchants.authentic.SignUpActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
//        getWindow().addFlags(WindowsManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Thread td=new Thread()
        {
            public void run()
            {
                try {
                    sleep(3000);
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally {
                    startActivity(new Intent(SplashScreen.this, MainActivity.class));
                    finish();

                }
            }

        };td.start();
    }
}