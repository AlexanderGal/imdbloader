package com.examples.android.homework.imdbparserex;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

class RecicerViewAdapter extends android.support.v7.widget.RecyclerView.Adapter<RecicerViewAdapter.ViewHolder> {
    private List<Film> films;

    RecicerViewAdapter(List<Film> list){
        this.films = list;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.film_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //todo init view date
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

     static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView filmIcon;
        TextView filmLabel;
        TextView filmDate;
        TextView filmRating;

         ViewHolder(View itemView) {
            super(itemView);
            filmIcon = (ImageView) itemView.findViewById(R.id.card_image_view);
            filmLabel = (TextView) itemView.findViewById(R.id.card_film_title);
            filmDate = (TextView) itemView.findViewById(R.id.card_film_year);
            filmRating = (TextView) itemView.findViewById(R.id.card_film_rating);
        }
    }
}
