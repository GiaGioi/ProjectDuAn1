package com.developer.giagioi.projectduan1.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.developer.giagioi.projectduan1.R;

import java.util.Timer;
import java.util.TimerTask;

public class FlashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);


        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(FlashActivity.this, SignInActivity.class));
                finish();
            }
        }, 1500);
    }
}

