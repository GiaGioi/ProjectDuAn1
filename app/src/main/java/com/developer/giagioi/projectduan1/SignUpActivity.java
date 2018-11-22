package com.developer.giagioi.projectduan1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {

    private Button btnsignin;
    private Button btnsignup;
    private EditText edUserName;
    private EditText edPassWord;
    private CheckBox chkRememberPass;
    private Button loginDangnhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnsignin = findViewById(R.id.btnsignin);
        btnsignup = findViewById(R.id.btnsignup);
        edUserName = findViewById(R.id.edUserName);
        edPassWord = findViewById(R.id.edPassWord);
        chkRememberPass = findViewById(R.id.chkRememberPass);
        loginDangnhap = findViewById(R.id.login_dangnhap);

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this,SignInActivity.class));
            }
        });
        loginDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
