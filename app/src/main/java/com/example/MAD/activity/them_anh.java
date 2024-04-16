package com.example.MAD.activity;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.MAD.R;
import com.example.MAD.adapters.PhotoAdapter;

import java.util.ArrayList;

public class them_anh extends AppCompatActivity {
    private static final int REQUEST_SELECT_IMAGE = 100;
    private RecyclerView recyclerView;
    private ArrayList<Uri> selectedPhotosUri = new ArrayList<>();
   private TextView chon_anh;

    PhotoAdapter adapter;
    private ActivityResultLauncher<String> imagePickerLauncher;

    @SuppressLint("WrongViewCast")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.them_anh);
        recyclerView = findViewById(R.id.rcv_photto);
        chon_anh = findViewById(R.id.totalPhotos);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PhotoAdapter(this, selectedPhotosUri);
        recyclerView.setAdapter(adapter);

        imagePickerLauncher = registerForActivityResult(new ActivityResultContracts.GetContent(),
                new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri result) {
                        // Xử lý kết quả trả về từ việc chọn ảnh ở đây
                        if (result != null) {
                            selectedPhotosUri.add(result);
                            adapter.notifyDataSetChanged();
                            updateTotalPhotos();
                        }
                    }
                });
    }

    // Phương thức xử lý khi nhấn vào nút "Chọn ảnh"
    public void pickImage(View view) {

        imagePickerLauncher.launch("image/*");
    }

    private void updateTotalPhotos() {
        int total = selectedPhotosUri.size();
        chon_anh.setText("Total Photos: " + total);
    }
}
