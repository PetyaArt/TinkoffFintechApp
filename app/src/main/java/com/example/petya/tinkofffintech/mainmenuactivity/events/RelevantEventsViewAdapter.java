package com.example.petya.tinkofffintech.mainmenuactivity.events;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.petya.tinkofffintech.R;
import com.example.petya.tinkofffintech.data.animedata.event.Active;
import com.example.petya.tinkofffintech.data.animedata.event.Events;
import com.squareup.picasso.Picasso;

import java.util.Random;

import static com.example.petya.tinkofffintech.util.constants.ConstantsImageUrl.*;

public class RelevantEventsViewAdapter extends RecyclerView.Adapter<RelevantEventsViewAdapter.ViewHolder> {

    private Events mEvents;

    private static final String[] urlString = {image1, image2, image3, image4, image5, image6, image7, image8, image9};

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext().getApplicationContext())
                .inflate(R.layout.relevant_events_list_item, viewGroup,  false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(mEvents.getActive().get(i));
    }

    @Override
    public int getItemCount() {
        return mEvents.getActive().size();
    }

    public void setEvents(Events events) {
        mEvents = events;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageEvents;
        TextView dateEvents;
        TextView nameEvents;
        TextView themeEvents;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageEvents = itemView.findViewById(R.id.relevantImageEvents);
            dateEvents = itemView.findViewById(R.id.relevantDateEvents);
            nameEvents = itemView.findViewById(R.id.relevantNameEvents);
            themeEvents = itemView.findViewById(R.id.relevantThemeEvents);
        }

        public void bind(Active active) {
            dateEvents.setText("НОЯБ 2018 Г. "); //TODO: время
            nameEvents.setText(active.getTitle());
            if (active.getEventType() == null) {
                themeEvents.setText("Мероприятие");
            } else {
                themeEvents.setText(active.getEventType().getName());
            }
            Picasso.get()
                    .load(urlString[new Random().nextInt(urlString.length)]) //TODO: Странное решение петя
                    .into(imageEvents);
        }
    }
}
