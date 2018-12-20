package com.example.fidenz.api.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fidenz.api.R;
import com.example.fidenz.api.model.Post;

import java.util.List;

public class PostDataAdapter extends RecyclerView.Adapter<PostDataAdapter.PostDataViewHolder> {

    private List<Post> listData;

    public PostDataAdapter(List<Post> listData) {
        this.listData = listData;
    }

    @NonNull
    @Override
    public PostDataViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.widget_sample, viewGroup, false);
        return new PostDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostDataViewHolder postDataViewHolder, int i) {
        Post data = listData.get(i);

        postDataViewHolder.txt_userId.setText(String.valueOf(data.getUserId()));
        postDataViewHolder.txt_id.setText(String.valueOf(data.getId()));
        postDataViewHolder.txt_title.setText(data.getTitle());
        postDataViewHolder.txt_body.setText(data.getBody());
    }

    @Override
    public int getItemCount() {
        return 100;
    }

    class PostDataViewHolder extends RecyclerView.ViewHolder {

        TextView txt_userId;
        TextView txt_id;
        TextView txt_title;
        TextView txt_body;

        PostDataViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_userId = itemView.findViewById(R.id.txt_userId);
            txt_id = itemView.findViewById(R.id.txt_id);
            txt_title = itemView.findViewById(R.id.txt_body);
            txt_body = itemView.findViewById(R.id.txt_title);
        }
    }
}
