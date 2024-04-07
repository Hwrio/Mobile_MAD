package com.example.cafe4u.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import com.example.cafe4u.R;
import com.example.cafe4u.activity.nhan_xet_khach_hang;

public class chitiet_quan extends AppCompatActivity {
    ImageButton btn_QuayLai;
    Button btn_seeComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chitiet_quan);
        btn_QuayLai = findViewById(R.id.back_arr);

        btn_QuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        // Chuyển sang layout đọc đánh giá của khách hàng
        btn_seeComment = findViewById(R.id.btnSeeComment);
        btn_seeComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chitiet_quan.this, nhan_xet_khach_hang.class);
                startActivity(intent);
            }
        });
    }
}