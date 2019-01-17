package com.example.rickb.week2day3;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RowViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView type;
    TextView name;
    TextView sound;
    ImageView ivImage;
    Animal animal;

    private RecyclerViewClickListener mListener;

    RowViewHolder(View v, RecyclerViewClickListener listener) {
        super(v);
        mListener = listener;
        v.setOnClickListener(this);
        type = itemView.findViewById(R.id.type);
        name = itemView.findViewById(R.id.name);
        sound = itemView.findViewById(R.id.sound);
        ivImage = itemView.findViewById(R.id.ivImage);
    }

    @Override
    public void onClick(View view) {
        mListener.onClick(view, getAdapterPosition());
    }
}