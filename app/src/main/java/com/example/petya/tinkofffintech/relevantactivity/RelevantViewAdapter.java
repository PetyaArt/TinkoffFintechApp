package com.example.petya.tinkofffintech.relevantactivity;

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

import static com.example.petya.tinkofffintech.util.constants.СonstantsImageUrl.image1;
import static com.example.petya.tinkofffintech.util.constants.СonstantsImageUrl.image2;
import static com.example.petya.tinkofffintech.util.constants.СonstantsImageUrl.image3;
import static com.example.petya.tinkofffintech.util.constants.СonstantsImageUrl.image4;
import static com.example.petya.tinkofffintech.util.constants.СonstantsImageUrl.image5;
import static com.example.petya.tinkofffintech.util.constants.СonstantsImageUrl.image6;
import static com.example.petya.tinkofffintech.util.constants.СonstantsImageUrl.image7;
import static com.example.petya.tinkofffintech.util.constants.СonstantsImageUrl.image8;
import static com.example.petya.tinkofffintech.util.constants.СonstantsImageUrl.image9;

public class RelevantViewAdapter extends RecyclerView.Adapter<RelevantViewAdapter.ViewHolder> {

    private Events mEvents;

    private static final String[] urlString = {image1, image2, image3, image4, image5, image6, image7, image8, image9};

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext().getApplicationContext())
                .inflate(R.layout.relevant_list_item, viewGroup,  false);
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

        ImageView relevantImage;
        TextView relevantDate;
        TextView relevantName;
        TextView relevantTheme;
        TextView relevantDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            relevantImage = itemView.findViewById(R.id.relevantImage);
            relevantDate = itemView.findViewById(R.id.relevantDate);
            relevantName = itemView.findViewById(R.id.relevantName);
            relevantTheme = itemView.findViewById(R.id.relevantTheme);
            relevantDescription = itemView.findViewById(R.id.relevantDescription);
        }

        public void bind(Active active) {
            relevantDate.setText("НОЯБ 2018 Г. "); //TODO: время исправить
            relevantName.setText(active.getTitle());
            if (active.getEventType() == null) {
                relevantTheme.setText("Мероприятие");
            } else {
                relevantTheme.setText(active.getEventType().getName());
            }
            Picasso.get()
                    .load(urlString[new Random().nextInt(urlString.length)]) //TODO: Странное решение петя
                    .into(relevantImage);
            relevantDescription.setText(active.getDescription());
        }
    }
}
