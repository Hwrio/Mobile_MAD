package com.example.cafe4u.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cafe4u.R;
import com.example.cafe4u.adapters.CommentAdapter;
import com.example.cafe4u.models.Comment;

import java.util.ArrayList;
import java.util.List;

public class nhan_xet_khach_hang extends AppCompatActivity {
    private ImageButton imgbtn_quaylai;
    private RecyclerView cmt_recycle;
    private CommentAdapter cmtAdapter;

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
                Intent back = new Intent(nhan_xet_khach_hang.this, chitiet_quan.class);
                startActivity(back);
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