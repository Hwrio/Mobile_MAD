package com.example.MAD.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.MAD.R;
import com.example.MAD.models.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {
    private List<Comment> mList_comment;
    private List<Comment> full_mList_comment;

    public CommentAdapter(List<Comment> mList_comment) {
        this.mList_comment = mList_comment;
        this.full_mList_comment = new ArrayList<>(mList_comment);
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_comment, parent, false);
        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {
        Comment cmt = mList_comment.get(position);
        if (cmt == null) {
            return;
        }
        holder.img_comment.setImageResource(cmt.getImg_comment());
        holder.txt_userName.setText(cmt.getUserName());
        holder.txt_comment.setText(cmt.getTxt_comment());
        holder.ratingBar.setRating(cmt.getRatingBar());
    }

    @Override
    public int getItemCount() {
        if (mList_comment != null) {
            return mList_comment.size();
        }
        return 0;
    }
    public void filterComment(int starCount){
        List<Comment> filtered_mList_comment = new ArrayList<>();
        for(Comment item : full_mList_comment){
            if(item.getRatingBar() == starCount){
                filtered_mList_comment.add(item);
            }
        }
        mList_comment.clear();
        mList_comment.addAll(filtered_mList_comment);
        notifyDataSetChanged();
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_comment;
        private TextView txt_userName, txt_comment;
        private RatingBar ratingBar;

        public CommentViewHolder(@NonNull View view) {
            super(view);
            img_comment = view.findViewById(R.id.img_comment);
            txt_comment = view.findViewById(R.id.cmt_content);
            txt_userName = view.findViewById(R.id.userName);
            ratingBar = view.findViewById(R.id.ratingBar_cmt);
        }
    }
}
