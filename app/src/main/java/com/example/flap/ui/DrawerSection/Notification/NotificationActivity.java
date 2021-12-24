package com.example.flap.ui.DrawerSection.Notification;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.flap.R;

import java.util.Objects;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Notifications");
    }
}