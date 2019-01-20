package com.example.rickb.week2day3;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;


import java.util.ArrayList;
import java.util.Collections;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    ArrayList<Animal> animalsArrayList;
    Context context;

    public RecyclerViewAdapter(ArrayList<Animal> animalsArrayList) {
        this.animalsArrayList = animalsArrayList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder viewHolder, int position) {
        Animal animal = animalsArrayList.get(position);

        if (animal != null) {
            String type = animal.getType();
            String name = animal.getName();
            String sound = animal.getSound();
            String image = animal.getImage();
            viewHolder.type.setText(type);
            viewHolder.name.setText(name);
            viewHolder.sound.setText(sound);
            Glide.with(viewHolder.itemView.getContext()).load(image).into(viewHolder.ivImage);

        }
    }

    @Override
    public int getItemCount() {
        return animalsArrayList != null ? animalsArrayList.size() : 0;
    }

    public void removeAnimal(int position){
        animalsArrayList.remove(position);
        notifyItemRemoved(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView type;
        TextView name;
        TextView sound;
        ImageView ivImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            type = itemView.findViewById(R.id.type);
            name = itemView.findViewById(R.id.name);
            sound = itemView.findViewById(R.id.sound);
            ivImage = itemView.findViewById(R.id.ivImage);

        }

    }
}

