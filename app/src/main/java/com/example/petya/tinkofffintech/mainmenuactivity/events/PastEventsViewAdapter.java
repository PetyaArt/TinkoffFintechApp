package com.example.petya.tinkofffintech.mainmenuactivity.events;

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
import com.squareup.picasso.Picasso;

public class PastEventsViewAdapter extends RecyclerView.Adapter<PastEventsViewAdapter.ViewHolder> {

    private Events mEvents;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.past_event_list_item, viewGroup,  false);
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

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageEvents;
        TextView nameEvents;
        TextView themeEvents;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageEvents = itemView.findViewById(R.id.pastImageEvents);
            nameEvents = itemView.findViewById(R.id.pastNameEvents);
            themeEvents = itemView.findViewById(R.id.pastThemeEvents);
        }

        public void bind(Archive archive) {
            nameEvents.setText(archive.getTitle());
            if (archive.getEventType() == null) {
                themeEvents.setText("Мероприятие");
                Picasso.get().load(R.drawable.ic_education).into(imageEvents);
            } else {
                themeEvents.setText(archive.getEventType().getName());
                if (archive.getEventType().getName().equals("Финтех Школа")) {
                    Picasso.get().load(R.drawable.ic_fintech_school).into(imageEvents);
                }
                if (archive.getEventType().getName().equals("Стажировка")){
                    Picasso.get().load(R.drawable.ic_internship).into(imageEvents);
                }
                if (archive.getEventType().getName().equals("Школьникам")){
                    Picasso.get().load(R.drawable.ic_school_children).into(imageEvents);
                }
                if (archive.getEventType().getName().equals("Спецкурс")){
                    Picasso.get().load(R.drawable.ic_special_course).into(imageEvents);
                }
            }


        }
    }
}
