package com.example.petya.tinkofffintech.activity.mainmenuactivity.mycourses;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.petya.tinkofffintech.R;
import com.example.petya.tinkofffintech.activity.performanceactivity.PerformanceViewAdapter;
import com.example.petya.tinkofffintech.data.animedata.courses.Courses;
import com.example.petya.tinkofffintech.data.animedata.courses.Grade;
import com.example.petya.tinkofffintech.util.Utils;
import com.squareup.picasso.Picasso;

public class AcademicPerformanceViewAdapter extends RecyclerView.Adapter<AcademicPerformanceViewAdapter.ViewHolder> {

    private Courses mCourses;
    private final OnItemClickListener listener;

    public AcademicPerformanceViewAdapter(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext().getApplicationContext())
                .inflate(R.layout.item_performance_first, viewGroup, false);
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

        ImageView imagePerformance;
        TextView textViewNameUser;
        TextView textViewPointsUser;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagePerformance = itemView.findViewById(R.id.profile_image);
            textViewNameUser = itemView.findViewById(R.id.textViewNameUser);
            textViewPointsUser = itemView.findViewById(R.id.textViewPointsUser);
        }

        public void bind(final Grade grade, final OnItemClickListener listener) {
            textViewNameUser.setText(Utils.getFirstName(grade.getStudent()));
            textViewPointsUser.setText(String.valueOf((grade.getSubGrades().get(grade.getSubGrades().size() - 1).getMark())));
            Picasso.get()
                    .load(R.drawable.anime_avatar)
                    .into(imagePerformance);
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
