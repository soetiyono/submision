package com.notur.submitionsatu;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private Context context;

    String data;

    public MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    private ArrayList<Movie> movies;

    private ArrayList<Movie>getMovies(){
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }





    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }





    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_movie,viewGroup,false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        Movie movie = (Movie) getItem(i);
        viewHolder.bind(movie);


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent(context,DetailActivity.class);
              intent.putExtra("title",getMovies().get(i).getTitle());
              intent.putExtra("desc",getMovies().get(i).getDescription());
              intent.putExtra("photo",getMovies().get(i).getPhoto());
              context.startActivities(new Intent[]{intent});
            }
        });

        return view;

    }

    private class ViewHolder {
        private TextView txtTitle;
        private TextView txtDescription;
        private ImageView imgPhoto;

        ViewHolder(View view) {
            txtTitle = view.findViewById(R.id.txt_title);
            txtDescription = view.findViewById(R.id.txt_description);
            imgPhoto = view.findViewById(R.id.img_photo);

        }

        void bind(Movie movie) {
            txtTitle.setText(movie.getTitle());
            txtDescription.setText(movie.getDescription());
            imgPhoto.setImageResource(movie.getPhoto());

        }





    }


}
