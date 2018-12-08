package com.example.petya.tinkofffintech.activity.pastactivity;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.petya.tinkofffintech.R;
import com.example.petya.tinkofffintech.data.animedata.event.Archive;
import com.example.petya.tinkofffintech.data.animedata.event.Events;
import com.example.petya.tinkofffintech.util.Utils;
import com.squareup.picasso.Picasso;


public class PastViewAdapter extends RecyclerView.Adapter<PastViewAdapter.ViewHolder> {

    private Events mEvents;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.past_list_item, viewGroup,  false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(mEvents.getArchive().get(i));
    }

    @Override
    public int getItemCount() {
        return mEvents.getArchive().size();
    }

    public void setEvents(Events events) {
        mEvents = events;
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
}