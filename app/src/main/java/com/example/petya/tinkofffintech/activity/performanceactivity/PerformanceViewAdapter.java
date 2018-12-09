package com.example.petya.tinkofffintech.activity.performanceactivity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.petya.tinkofffintech.R;
import com.example.petya.tinkofffintech.data.animedata.courses.Courses;
import com.example.petya.tinkofffintech.data.animedata.courses.Grade;
import com.example.petya.tinkofffintech.data.animedata.event.Active;
import com.example.petya.tinkofffintech.data.animedata.event.Events;
import com.example.petya.tinkofffintech.data.animedata.link.Result;
import com.example.petya.tinkofffintech.util.Utils;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Random;


public class PerformanceViewAdapter extends RecyclerView.Adapter<PerformanceViewAdapter.ViewHolder> {

    private Courses mCourses;
    private final OnItemClickListener listener;

    public PerformanceViewAdapter(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_performance_second, viewGroup,  false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(mCourses.getGrades().get(i), listener);
    }

    @Override
    public int getItemCount() {
        return mCourses.getGrades().size();
    }

    public void setEvents(Courses example) {
        mCourses = example;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name;
        TextView score;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.textViewPerformanceImage);
            name = itemView.findViewById(R.id.textViewPerformanceName);
            score = itemView.findViewById(R.id.textViewPerformanceScore);

        }

        public void bind(final Grade grade, final OnItemClickListener listener) {
            name.setText(Utils.getFirstName(grade.getStudent()));
            score.setText(String.format("%s БАЛЛ", String.valueOf((grade.getSubGrades().get(grade.getSubGrades().size() - 1).getMark()))));
            Picasso.get()
                    .load(R.drawable.anime_avatar)
                    .into(image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(grade);
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Grade grade);
    }
}
