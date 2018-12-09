package com.example.petya.tinkofffintech.activity.pastactivity;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.petya.tinkofffintech.R;
import com.example.petya.tinkofffintech.activity.mainmenuactivity.events.PastEventsViewAdapter;
import com.example.petya.tinkofffintech.activity.performanceactivity.PerformanceViewAdapter;
import com.example.petya.tinkofffintech.data.animedata.courses.Courses;
import com.example.petya.tinkofffintech.data.animedata.courses.Grade;
import com.example.petya.tinkofffintech.data.animedata.event.Archive;
import com.example.petya.tinkofffintech.data.animedata.event.Events;
import com.example.petya.tinkofffintech.util.Utils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class PastViewAdapter extends RecyclerView.Adapter<PastViewAdapter.ViewHolder> implements Filterable {

    private List<Archive> mArchive;
    private List<Archive> mArchiveFull;

    public PastViewAdapter(Events events) {
        mArchive = events.getArchive();
        mArchiveFull = new ArrayList<>(events.getArchive());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.past_list_item, viewGroup,  false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(mArchive.get(i));
    }

    @Override
    public int getItemCount() {
        return mArchive.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView pastImage;
        TextView pastName;
        TextView pastTheme;
        TextView pastDate;
        TextView pastCity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pastImage = itemView.findViewById(R.id.pastImage);
            pastName = itemView.findViewById(R.id.pastName);
            pastTheme = itemView.findViewById(R.id.pastTheme);
            pastDate = itemView.findViewById(R.id.pastDate);
            pastCity = itemView.findViewById(R.id.pastCity);
        }

        public void bind(Archive archive) {
            pastDate.setText(Utils.getParseTime(archive.getDateStart(), archive.getDateEnd()));
            pastName.setText(archive.getTitle());
            if (archive.getEventType() == null) {
                pastTheme.setText("Мероприятие");
                Picasso.get().load(R.drawable.ic_education).into(pastImage);
            } else {
                pastTheme.setText(archive.getEventType().getName());
                if (archive.getEventType().getName().equals("Финтех Школа")) {
                    Picasso.get().load(R.drawable.ic_fintech_school).into(pastImage);
                }
                if (archive.getEventType().getName().equals("Стажировка")){
                    Picasso.get().load(R.drawable.ic_internship).into(pastImage);
                }
                if (archive.getEventType().getName().equals("Школьникам")){
                    Picasso.get().load(R.drawable.ic_school_children).into(pastImage);
                }
                if (archive.getEventType().getName().equals("Спецкурс")){
                    Picasso.get().load(R.drawable.ic_special_course).into(pastImage);
                }
            }
            pastCity.setText(archive.getPlace());
        }
    }

    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Archive> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(mArchiveFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Archive item : mArchiveFull) {
                    if (item.getTitle().toLowerCase().contains(filterPattern)) {
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
            mArchive.clear();
            mArchive.addAll( (ArrayList<Archive>) results.values);
            notifyDataSetChanged();
        }
    };
}
