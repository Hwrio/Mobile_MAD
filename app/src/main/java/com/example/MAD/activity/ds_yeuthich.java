package com.example.MAD.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import androidx.recyclerview.widget.RecyclerView;

import com.example.MAD.R;
import com.example.MAD.adapters.ShopAdapter;
import com.example.MAD.databinding.DsYeuthichBinding;
import com.example.MAD.models.Shop;
import com.google.firebase.firestore.FirebaseFirestore;

public class ds_yeuthich extends AppCompatActivity {
    //khai bao bien giao dien
    ImageButton btn_QuayLai;
    private ArrayList<Shop> favouriteCafe ;
    private RecyclerView mRecycleCafe;
    private ShopAdapter mCafeAdapter ;
    private DsYeuthichBinding binding;
    private FirebaseFirestore database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DsYeuthichBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mRecycleCafe = findViewById(R.id.listFavourite);
        favouriteCafe = new ArrayList<>();
        addEvent();
    }

    private void addEvent() {

        binding.btnQuaylai.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), home1.class));
        });
        binding.btnNewCoffe.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), goi_y.class));
        });
    }
    private void getShop() {
        favouriteCafe = new ArrayList<>();
        database = FirebaseFirestore.getInstance();

        database.collection("shops").get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    for (Shop shop : queryDocumentSnapshots.toObjects(Shop.class)) {
                        favouriteCafe.add(shop);
                    }
                    // Hiển thị danh sách quán lên RecyclerView
                    displayShopList();
                })
                .addOnFailureListener(e -> {
                    e.printStackTrace();
                    Toast.makeText(this, "Lỗi khi thực hiện ", Toast.LENGTH_SHORT).show();
                });
    }

    private void displayShopList() {
        mRecycleCafe = binding.listFavourite;
        mRecycleCafe.setLayoutManager(new LinearLayoutManager(this));
        mCafeAdapter = new ShopAdapter(this,favouriteCafe);
        mRecycleCafe.setAdapter(mCafeAdapter);
        mRecycleCafe.setLayoutManager(new LinearLayoutManager(this));
    }
//    private void addControl() {
//
//    }


    //laytt tu csdl
//    private void createCafeList() {
//        favouriteCafe.add(new Shop(0, "Thor",1.0F,"Cổ điển","Wakanda"));
//        favouriteCafe.add(new Shop(0,"IronMan",2.0F,"Hiện đại","Mondstadt"));
//        favouriteCafe.add(new Shop(0,"Hulk",3.0F,"Trung Hoa","Liyue"));
//        favouriteCafe.add(new Shop(0,"SpiderMan",4.0F,"Cổ điển","Inazuma"));
//        favouriteCafe.add(new Shop(0,"Thor",5.0F,"Bác học","Sumeru"));
//        favouriteCafe.add(new Shop(0,"IronMan",4.0F,"Thanh lịch","Fontaine"));
//        favouriteCafe.add(new Shop(0,"Hulk",3.0F,"Rock n' Roll","Natlan"));
//        favouriteCafe.add(new Shop(0,"SpiderMan",2.0F,"Nữ hoàng băng giá","Snezhnaya"));
//        favouriteCafe.add(new Shop(0,"Thor",1.0F,"Cổ điển","Wakanda"));
//        favouriteCafe.add(new Shop(0,"IronMan",2.0F,"Cổ điển","Wakanda"));
//    }
}