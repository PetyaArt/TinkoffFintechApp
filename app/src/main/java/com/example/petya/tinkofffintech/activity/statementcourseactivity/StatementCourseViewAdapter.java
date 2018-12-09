package com.example.petya.tinkofffintech.activity.statementcourseactivity;

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
import com.example.petya.tinkofffintech.data.animedata.courses.GroupedTask;
import com.example.petya.tinkofffintech.data.animedata.courses.SubGrade;
import com.example.petya.tinkofffintech.util.Utils;
import com.squareup.picasso.Picasso;

import java.util.List;


public class StatementCourseViewAdapter extends RecyclerView.Adapter<StatementCourseViewAdapter.ViewHolder> {

    private Grade grade;
    private List<GroupedTask> list;
    private String studentId;

    public StatementCourseViewAdapter(List<GroupedTask> list, Grade grade) {
        this.list = list;
        this.grade = grade;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_general_statement, viewGroup,  false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(grade.getSubGrades().get(i), i);
    }

    @Override
    public int getItemCount() {
        return grade.getSubGrades().size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView shortName;
        TextView title;
        TextView mark;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            shortName = itemView.findViewById(R.id.textViewShortName);
            title = itemView.findViewById(R.id.textViewTitle);
            mark = itemView.findViewById(R.id.textViewMark);

        }

        public void bind(SubGrade subGrade, int i) {
            shortName.setText(list.get(i).getShortName());
            title.setText(list.get(i).getTitle());
            mark.setText(String.valueOf(subGrade.getMark()));
        }
    }

}
