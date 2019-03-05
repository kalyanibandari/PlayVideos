package com.example.playvideos.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.playvideos.view.DetailScreenActivity;
import com.example.playvideos.R;
import com.example.playvideos.model.PlayVideosObj;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.MyViewHolder> {

    private final Context context;
    private List<PlayVideosObj> videosList;

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView title, description;
        public ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_title);
            description = itemView.findViewById(R.id.tv_description);
            imageView = itemView.findViewById(R.id.imageView);

        }
    }

    public VideosAdapter(Context context,List<PlayVideosObj> videosList){
        this.context = context;
        this.videosList = videosList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.video_list_row, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final PlayVideosObj playVideosObj = videosList.get(i);
        myViewHolder.title.setText(playVideosObj.getTitle());
        myViewHolder.description.setText(playVideosObj.getDescription());
        Picasso.with(context)
                .load(playVideosObj.getThumb())
                .fit()
                .into(myViewHolder.imageView);

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailScreenActivity.class);
               /* intent.putExtra(VIDEO_URL, playVideosObj.getUrl());
                intent.putExtra(TITLE, playVideosObj.getTitle());
                intent.putExtra(DESCRIPTION, playVideosObj.getDescription());*/
                intent.putExtra("class", playVideosObj);
                intent.putExtra("objLists", (ArrayList<PlayVideosObj>) videosList);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return videosList.size();
    }
}
