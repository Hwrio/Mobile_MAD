package com.example.MAD.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.MAD.R;

public class Send_Feedback extends AppCompatActivity {

    private Button cancel, publish, them_anh;
    private EditText cmt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_feedback);
        them_anh = findViewById(R.id.insert_img);
        them_anh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent them = new Intent(Send_Feedback.this, them_anh.class);
            }
        });

        cancel = findViewById(R.id.cancel_btn);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        cmt = findViewById(R.id.writeComment);
        publish = findViewById(R.id.upload);
        publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = cmt.getText().toString();
                if(s.trim().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Phần nhận xét không được để trống!", Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(getApplicationContext(), "Đăng tải nhận xét thành công!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}