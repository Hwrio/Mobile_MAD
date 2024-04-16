package com.example.MAD.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.MAD.R;
import com.example.MAD.adapters.CommentAdapter;
import com.example.MAD.models.Comment;

import java.util.ArrayList;
import java.util.List;

public class nhan_xet_khach_hang extends AppCompatActivity {
    private ImageButton imgbtn_quaylai;
    private RecyclerView cmt_recycle;
    private CommentAdapter cmtAdapter;
    private RadioGroup cmt_filter;
    private RadioButton btn_filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan_xet_khach_hang);

        cmt_recycle = findViewById(R.id.cmt_recycle);
        cmtAdapter = new CommentAdapter(getList());
        LinearLayoutManager manager = new LinearLayoutManager(this);
        cmt_recycle.setLayoutManager(manager);
        cmt_recycle.setAdapter(cmtAdapter);

        // Quay trở lại
        imgbtn_quaylai = findViewById(R.id.back_arr);
        imgbtn_quaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Chọn button để lọc comment
        cmt_filter = findViewById(R.id.classify);
        cmt_filter.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int starCount = 0;
                if(checkedId == R.id.btn_cmt_1star){
                    starCount = 1;
                } else if (checkedId == R.id.btn_cmt_2star) {
                    starCount = 2;
                }else if (checkedId == R.id.btn_cmt_3star) {
                    starCount = 3;
                }else if (checkedId == R.id.btn_cmt_4star) {
                    starCount = 4;
                }else if (checkedId == R.id.btn_cmt_5star) {
                    starCount = 5;
                }
                cmtAdapter.filterComment(starCount);
            }
        });

    }

    private List<Comment> getList() {
        List<Comment> cmtLst = new ArrayList<>();
        cmtLst.add(new Comment(R.drawable.coffee_shop_1, "user1", "Quán trông khá đẹp", 1));
        cmtLst.add(new Comment(R.drawable.coffee_shop_1, "user2", "Quán trông khá đẹp", 2));
        cmtLst.add(new Comment(R.drawable.coffee_shop_1, "user3", "Quán trông khá đẹp", 3));
        cmtLst.add(new Comment(R.drawable.coffee_shop_1, "user4", "Quán trông khá đẹp", 4));
        cmtLst.add(new Comment(R.drawable.coffee_shop_1, "user5", "Quán trông khá đẹp", 5));
        cmtLst.add(new Comment(R.drawable.coffee_shop_1, "user6", "Quán trông khá đẹp", 5));
        cmtLst.add(new Comment(R.drawable.coffee_shop_1, "user7", "Quán trông khá đẹp", 5));
        cmtLst.add(new Comment(R.drawable.coffee_shop_1, "user8", "Quán trông khá đẹp", 5));
        return cmtLst;
    }
}