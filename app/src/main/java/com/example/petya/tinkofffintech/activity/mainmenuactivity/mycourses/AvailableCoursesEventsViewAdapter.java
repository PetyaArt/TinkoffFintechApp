package com.example.petya.tinkofffintech.activity.mainmenuactivity.mycourses;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.petya.tinkofffintech.R;
import com.example.petya.tinkofffintech.data.animedata.availablecourses.AvailableCourses;
import com.example.petya.tinkofffintech.data.animedata.availablecourses.Course;
import com.example.petya.tinkofffintech.util.Utils;

public class AvailableCoursesEventsViewAdapter extends RecyclerView.Adapter<AvailableCoursesEventsViewAdapter.ViewHolder> {

    private AvailableCourses mAvailableCourses;
    private float mPoints;

    AvailableCoursesEventsViewAdapter(float points) {
        mPoints = points;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_courses_completed, viewGroup,  false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(mAvailableCourses.getCourses().get(i));
    }

    @Override
    public int getItemCount() {
        return mAvailableCourses.getCourses().size();
    }

    public void setEvents(AvailableCourses availableCourses) {
        mAvailableCourses = availableCourses;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView iconPassed;
        private TextView iconNotPassed;
        private TextView date;
        private TextView name;
        private TextView points;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iconPassed = itemView.findViewById(R.id.textViewIconCoursesCompletedPassed);
            iconNotPassed = itemView.findViewById(R.id.textViewIconCoursesCompletedNotPassed);
            date = itemView.findViewById(R.id.textViewDateCoursesCompleted);
            name = itemView.findViewById(R.id.textViewNameCoursesCompleted);
            points = itemView.findViewById(R.id.textViewPointsCoursesCompleted) ;
        }

        public void bind(Course courses) {
            date.setText(Utils.getParseTime(courses.getEventDateStart(), courses.getEventDateStart()));
            if (courses.getStatus().equals("ongoing")) {
                iconNotPassed.setVisibility(View.VISIBLE);
                iconPassed.setVisibility(View.INVISIBLE);
            } else {
                iconNotPassed.setVisibility(View.INVISIBLE);
                iconPassed.setVisibility(View.VISIBLE);
            }
            points.setText(String.valueOf(mPoints));
            name.setText(courses.getTitle());
        }
    }
}
