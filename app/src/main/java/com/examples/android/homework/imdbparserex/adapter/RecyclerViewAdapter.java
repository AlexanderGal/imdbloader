package com.examples.android.homework.imdbparserex.adapter;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.examples.android.homework.imdbparserex.activity.FilmInformationActivity;
import com.examples.android.homework.imdbparserex.entity.Film;
import com.examples.android.homework.imdbparserex.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private final static String TAG = RecyclerViewAdapter.class.getCanonicalName();
    private final List<Film> mFilms;

    public RecyclerViewAdapter() {
        this.mFilms = new ArrayList<>();
        Log.d(TAG, "public RecyclerViewAdapter(FilmListStorage list)");
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        Log.d(TAG, "public void onAttachedToRecyclerView(RecyclerView recyclerView)");
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.film_card, parent, false);
        Log.d(TAG, "public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)");
        return new ViewHolder(view);
    }

    public void setFilms(List<Film> films) {
        mFilms.clear();
        mFilms.addAll(films);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mFilmLabel.setText(mFilms.get(position).getTitle());
        holder.mFilmDate.setText(mFilms.get(position).getYear());
        holder.mFilmRating.setText(mFilms.get(position).getRating());
        holder.mFilmIcon.setImageBitmap(mFilms.get(position).getImage());
        Log.d(TAG, "public void onBindViewHolder(ViewHolder holder, int position)");
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "public int getItemCount()");
        return mFilms.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mFilmIcon;
        TextView mFilmLabel;
        TextView mFilmDate;
        TextView mFilmRating;
        CardView mCardView;

        ViewHolder(View itemView) {
            super(itemView);
            mFilmIcon = (ImageView) itemView.findViewById(R.id.card_image_view);
            mFilmLabel = (TextView) itemView.findViewById(R.id.card_film_title);
            mFilmDate = (TextView) itemView.findViewById(R.id.card_film_year);
            mFilmRating = (TextView) itemView.findViewById(R.id.card_film_rating);


            mCardView = (CardView) itemView.findViewById(R.id.card_view);
            mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext().getApplicationContext(), FilmInformationActivity.class);
                    intent.putExtra("filmURL", mFilms.get(getAdapterPosition()).getURL());
                    v.getContext().getApplicationContext().startActivity(intent);
                }
            });
        }
    }
}
