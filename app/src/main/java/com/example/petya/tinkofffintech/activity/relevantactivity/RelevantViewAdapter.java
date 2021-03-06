package com.example.petya.tinkofffintech.activity.relevantactivity;

import android.content.Context;
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
import com.example.petya.tinkofffintech.data.animedata.link.Result;
import com.example.petya.tinkofffintech.util.Utils;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Random;


public class RelevantViewAdapter extends RecyclerView.Adapter<RelevantViewAdapter.ViewHolder> {

    private Events mEvents;
    private Context mContext;
    private List<Result> mResults;

    RelevantViewAdapter(Context context, List<Result> results) {
        mContext = context;
        mResults = results;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
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

    public class ViewHolder extends RecyclerView.ViewHolder {

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
            relevantDate.setText(Utils.getParseTime(active.getDateStart(), active.getDateEnd()));
            relevantName.setText(active.getTitle());
            if (active.getEventType() == null) {
                relevantTheme.setText("Мероприятие");
                relevantTheme.setBackgroundColor(mContext.getResources().getColor(R.color.themeEvents));
            } else {
                relevantTheme.setText(active.getEventType().getName());
                if (active.getEventType().getName().equals("Финтех Школа")) {
                    relevantTheme.setBackgroundColor(mContext.getResources().getColor(R.color.themeFintech));
                }
                if (active.getEventType().getName().equals("Стажировка")){
                    relevantTheme.setBackgroundColor(mContext.getResources().getColor(R.color.themeInternship));
                }
                if (active.getEventType().getName().equals("Школьникам")){
                    relevantTheme.setBackgroundColor(mContext.getResources().getColor(R.color.themeSchool));
                }
                if (active.getEventType().getName().equals("Курсы для школьников")){
                    relevantTheme.setBackgroundColor(mContext.getResources().getColor(R.color.themeSchool));
                }
                if (active.getEventType().getName().equals("Спецкурс")){
                    relevantTheme.setBackgroundColor(mContext.getResources().getColor(R.color.themeSpecialCourse));
                }
            }
            Picasso.get()
                    .load(mResults.get(new Random().nextInt(mResults.size())).getUrls().getSmall())
                    .into(relevantImage);
            relevantDescription.setText(active.getDescription());
        }
    }
}
