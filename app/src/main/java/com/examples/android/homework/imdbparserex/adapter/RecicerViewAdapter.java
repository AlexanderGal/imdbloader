package com.examples.android.homework.imdbparserex.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.examples.android.homework.imdbparserex.FilmInformationActivity;
import com.examples.android.homework.imdbparserex.MainActivity;
import com.examples.android.homework.imdbparserex.entity.Film;
import com.examples.android.homework.imdbparserex.entity.FilmsList;
import com.examples.android.homework.imdbparserex.R;

import java.util.List;

import static java.security.AccessController.getContext;

public class RecicerViewAdapter extends android.support.v7.widget.RecyclerView.Adapter<RecicerViewAdapter.ViewHolder> {
    private final static String TAG = RecicerViewAdapter.class.getCanonicalName();
    private List<Film> films;

    private  Context mContext;

    public RecicerViewAdapter(FilmsList list){
        this.films = list.getList();
        Log.d(TAG, "public RecicerViewAdapter(FilmsList list)");
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        Log.d(TAG, "public void onAttachedToRecyclerView(RecyclerView recyclerView)");
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.film_card,parent,false);


        Log.d(TAG, "public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)");
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.filmLabel.setText(films.get(position).getTitle());
        holder.filmDate.setText(films.get(position).getYear());
        holder.filmRating.setText(films.get(position).getRating());
        holder.filmIcon.setImageBitmap(films.get(position).getImage());
        Log.d(TAG, "public void onBindViewHolder(ViewHolder holder, int position)");

    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "public int getItemCount()");
        return films.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder {
        ImageView filmIcon;
        TextView filmLabel;
        TextView filmDate;
        TextView filmRating;
         CardView mCardView;

         ViewHolder(View itemView) {
            super(itemView);
             mContext = itemView.getContext();

             itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Intent intent = new Intent(mContext, FilmInformationActivity.class);
                     intent.putExtra("movieTitle",films.get(getAdapterPosition()).getFilmId());
                     Log.e(TAG,"onclick"+films.get(getAdapterPosition()).getFilmId());
                     mContext.startActivity(intent);
                 }
             });

            filmIcon = (ImageView) itemView.findViewById(R.id.card_image_view);
            filmLabel = (TextView) itemView.findViewById(R.id.card_film_title);
            filmDate = (TextView) itemView.findViewById(R.id.card_film_year);
            filmRating = (TextView) itemView.findViewById(R.id.card_film_rating);
             mCardView = (CardView)itemView.findViewById(R.id.card_view);
        }
    }
}
