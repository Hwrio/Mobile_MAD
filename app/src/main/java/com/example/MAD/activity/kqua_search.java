package com.example.MAD.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.MAD.R;
import com.example.MAD.adapters.ShopAdapter;
import com.example.MAD.databinding.ActivityKquaSearchBinding;
import com.example.MAD.models.Shop;
import com.example.MAD.ultility.PreferenceManager;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class kqua_search extends AppCompatActivity {


    ActivityKquaSearchBinding binding;
    PreferenceManager preferenceManager;
    RecyclerView recyclerView;
    FirebaseFirestore database;
    ShopAdapter shopAdapter;
    ArrayList<Shop> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityKquaSearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        preferenceManager = new PreferenceManager(getApplicationContext());
        getShop();
        setListener();


    }

    private void getShop() {
        FirebaseFirestore database = FirebaseFirestore.getInstance();


    }

    private void setListener() {
        binding.btnQuaylai.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), home1.class));
        });
    }


}