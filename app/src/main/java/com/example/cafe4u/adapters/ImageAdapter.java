//package com.example.cafe4u.adapters;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.cafe4u.R;
//
//import java.util.List;
//
//public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
//    private List<String> imageUrls;
//
//    public ImageAdapter(List<String> imageUrls) {
//        this.imageUrls = imageUrls;
//    }
//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//        String imageUrl = imageUrls.get(position);
//        // Load image from imageUrl here
//        // ...
//    }
//
//    @Override
//    public int getItemCount() {
//        // Only show up to 5 images
//        return Math.min(imageUrls.size(), 5);
//    }
//
//    public static class ViewHolder extends RecyclerView.ViewHolder {
//        ImageView imageView;
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//            imageView = itemView.findViewById(R.id.imageView);
//        }
//    }
//}