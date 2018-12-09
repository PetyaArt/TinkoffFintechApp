package com.example.petya.tinkofffintech.activity.performanceactivity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Filter;

import com.example.petya.tinkofffintech.R;
import com.example.petya.tinkofffintech.data.animedata.courses.Courses;
import com.example.petya.tinkofffintech.data.animedata.courses.Grade;
import com.example.petya.tinkofffintech.data.animedata.event.Active;
import com.example.petya.tinkofffintech.data.animedata.event.Events;
import com.example.petya.tinkofffintech.data.animedata.link.Result;
import com.example.petya.tinkofffintech.util.Utils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;


public class PerformanceViewAdapter extends RecyclerView.Adapter<PerformanceViewAdapter.ViewHolder> implements Filterable {

    private List<Grade> mGrade;
    private List<Grade> mGradeFull;
    private final OnItemClickListener listener;

    public PerformanceViewAdapter(OnItemClickListener listener, Courses courses) {
        this.listener = listener;
        mGrade = courses.getGrades();
        mGradeFull = new ArrayList<>(courses.getGrades());
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
        viewHolder.bind(mGrade.get(i), listener);
    }

    @Override
    public int getItemCount() {
        return mGrade.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
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
            name.setText(grade.getStudent());
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

    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Grade> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(mGradeFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Grade item : mGradeFull) {
                    if (item.getStudent().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mGrade.clear();
            mGrade.addAll( (ArrayList<Grade>) results.values);
            notifyDataSetChanged();
        }
    };
}
