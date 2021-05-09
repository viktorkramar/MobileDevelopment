package ua.kpi.comsys.io8316;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    private List<Movie> movies;

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }

    MoviesAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public MoviesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MoviesAdapter.ViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.posterView.setImageResource(movie.getPosterId());
        holder.titleView.setText(movie.getTitle());
        holder.yearView.setText(movie.getYear());
        holder.typeView.setText(movie.getType());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        final ImageView posterView;
        final TextView titleView;
        final TextView yearView;
        final TextView typeView;

        ViewHolder(View view){
            super(view);
            view.findViewById(R.id.movie_card_view).setOnClickListener(this);
            posterView = view.findViewById(R.id.poster);
            titleView = view.findViewById(R.id.title);
            yearView = view.findViewById(R.id.year);
            typeView = view.findViewById(R.id.type);
        }

        @Override
        public void onClick(View view) {
            LayoutInflater inflater = LayoutInflater.from(super.itemView.getContext());
            View v = inflater.inflate(R.layout.movie_card_full,null);

            AlertDialog.Builder addDialog = new AlertDialog.Builder(super.itemView.getContext());

            Movie movie = movies.get(getAbsoluteAdapterPosition());
            ((ImageView)v.findViewById(R.id.poster)).setImageResource(movie.getPosterId());
            ((TextView)v.findViewById(R.id.title)).setText(movie.getTitle());
            ((TextView)v.findViewById(R.id.year))
                    .setText("Year: " + (movie.getYear() == null ? "" : movie.getYear()));
            ((TextView)v.findViewById(R.id.rated))
                    .setText("Rated: " + (movie.getRated() == null ? "" : movie.getRated()));
            ((TextView)v.findViewById(R.id.released))
                    .setText("Released: " + (movie.getReleased() == null ? "" : movie.getReleased()));
            ((TextView)v.findViewById(R.id.runtime))
                    .setText("Runtime: " + (movie.getRuntime() == null ? "" : movie.getRuntime()));
            ((TextView)v.findViewById(R.id.genre))
                    .setText("Genre: " + (movie.getGenre() == null ? "" : movie.getGenre()));
            ((TextView)v.findViewById(R.id.director))
                    .setText("Director: " + (movie.getDirector() == null ? "" : movie.getDirector()));
            ((TextView)v.findViewById(R.id.writer))
                    .setText("Writer: " + (movie.getWriter() == null ? "" : movie.getWriter()));
            ((TextView)v.findViewById(R.id.actors))
                    .setText("Actors: " + (movie.getActors() == null ? "" : movie.getActors()));
            ((TextView)v.findViewById(R.id.plot))
                    .setText("Plot: " + (movie.getPlot() == null ? "" : movie.getPlot()));
            ((TextView)v.findViewById(R.id.language))
                    .setText("Language: " + (movie.getLanguage() == null ? "" : movie.getLanguage()));
            ((TextView)v.findViewById(R.id.country))
                    .setText("Country: " + (movie.getCountry() == null ? "" : movie.getCountry()));
            ((TextView)v.findViewById(R.id.awards))
                    .setText("Awards: " + (movie.getAwards() == null ? "" : movie.getAwards()));
            ((TextView)v.findViewById(R.id.imdb_rating))
                    .setText("IMDB Rating: " + (movie.getImdbRating() == null ? "" : movie.getImdbRating()));
            ((TextView)v.findViewById(R.id.imdb_votes))
                    .setText("IMDB Votes: " + (movie.getImdbVotes() == null ? "" : movie.getImdbVotes()));
            ((TextView)v.findViewById(R.id.imdb_id))
                    .setText("IMDB Id: " + (movie.getImdbId() == null ? "" : movie.getImdbId()));
            ((TextView)v.findViewById(R.id.type))
                    .setText("Type: " + (movie.getType() == null ? "" : movie.getType()));
            ((TextView)v.findViewById(R.id.production))
                    .setText("Production: " + (movie.getProduction() == null ? "" : movie.getProduction()));
            addDialog.setView(v);
            addDialog.create();
            addDialog.show();
        }
    }
}
