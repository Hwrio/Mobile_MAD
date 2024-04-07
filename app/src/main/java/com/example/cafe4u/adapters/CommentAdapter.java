package com.example.cafe4u.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cafe4u.R;
import com.example.cafe4u.models.Comment;
import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder>{
    private List<Comment> mList_comment;

    public CommentAdapter(List<Comment> mList_comment) {
        this.mList_comment = mList_comment;
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_comment, parent, false);
        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {
        Comment cmt = mList_comment.get(position);
        if(cmt==null){
            return;
        }
        holder.img_comment.setImageResource(cmt.getImg_comment());
        holder.txt_userName.setText(cmt.getUserName());
        holder.txt_comment.setText(cmt.getTxt_comment());
        holder.ratingBar.setRating(cmt.getRatingBar());
    }

    @Override
    public int getItemCount() {
        if(mList_comment!=null){
            return mList_comment.size();
        }
        return 0;
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder{
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
