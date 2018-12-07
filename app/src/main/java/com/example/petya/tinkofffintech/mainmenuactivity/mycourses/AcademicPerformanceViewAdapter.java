package com.example.petya.tinkofffintech.mainmenuactivity.mycourses;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.petya.tinkofffintech.R;
import com.example.petya.tinkofffintech.data.animedata.courses.Example;
import com.example.petya.tinkofffintech.data.animedata.courses.Grade;
import com.example.petya.tinkofffintech.util.Utils;
import com.squareup.picasso.Picasso;

public class AcademicPerformanceViewAdapter extends RecyclerView.Adapter<AcademicPerformanceViewAdapter.ViewHolder> {

    private Example mExample;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext().getApplicationContext())
                .inflate(R.layout.item_performance, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(mExample.getGrades().get(i));
    }

    @Override
    public int getItemCount() {
        return mExample.getGrades().size();
    }

    public void setEvents(Example example) {
        mExample = example;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imagePerformance;
        TextView textViewNameUser;
        TextView textViewPointsUser;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagePerformance = itemView.findViewById(R.id.profile_image);
            textViewNameUser = itemView.findViewById(R.id.textViewNameUser);
            textViewPointsUser = itemView.findViewById(R.id.textViewPointsUser);
        }

        public void bind(Grade grade) {
            textViewNameUser.setText(Utils.getFirstName(grade.getStudent()));
            textViewPointsUser.setText(String.valueOf((grade.getSubGrades().get(grade.getSubGrades().size() - 1).getMark())));
            Picasso.get()
                    .load(R.drawable.anime_avatar) //TODO: Создать аватарки пользователей
                    .into(imagePerformance);
        }
    }
}
