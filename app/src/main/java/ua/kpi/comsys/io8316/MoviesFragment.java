package ua.kpi.comsys.io8316;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class MoviesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.movies_fragment, container, false);
        try {
            List<Movie> movies = getMovies();
            RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
            MoviesAdapter adapter = new MoviesAdapter(movies);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
            recyclerView.setAdapter(adapter);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return view;
    }

    private List<Movie> getMovies() throws JsonProcessingException {
        InputStream inputStream = getResources().openRawResource(R.raw.movies);
        String moviesJson = new Scanner(inputStream).useDelimiter("\\A").next();
        ObjectMapper objectMapper = new ObjectMapper();
        MoviesDto moviesDto = objectMapper.readValue(moviesJson, MoviesDto.class);
        List<Movie> movies = moviesDto.getMovies();
        movies.forEach(movie -> {
            String poster = movie.getPoster();
            switch (poster) {
                case "Poster_01.jpg":
                    movie.setPosterId(R.drawable.poster_01);
                    break;
                case "Poster_02.jpg":
                    movie.setPosterId(R.drawable.poster_02);
                    break;
                case "Poster_03.jpg":
                    movie.setPosterId(R.drawable.poster_03);
                    break;
                case "Poster_05.jpg":
                    movie.setPosterId(R.drawable.poster_05);
                    break;
                case "Poster_06.jpg":
                    movie.setPosterId(R.drawable.poster_06);
                    break;
                case "Poster_07.jpg":
                    movie.setPosterId(R.drawable.poster_07);
                    break;
                case "Poster_08.jpg":
                    movie.setPosterId(R.drawable.poster_08);
                    break;
                case "Poster_10.jpg":
                    movie.setPosterId(R.drawable.poster_10);
                    break;
                default:
                    break;
            }
        });
        return movies;
    }

    private static class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder>{
        private final List<Movie> movies;

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
            holder.imdbIdView.setText(movie.getImdbId());
            holder.typeView.setText(movie.getType());
        }

        @Override
        public int getItemCount() {
            return movies.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            final ImageView posterView;
            final TextView titleView;
            final TextView yearView;
            final TextView imdbIdView;
            final TextView typeView;

            ViewHolder(View view){
                super(view);
                posterView = view.findViewById(R.id.poster);
                titleView = view.findViewById(R.id.title);
                yearView = view.findViewById(R.id.year);
                imdbIdView = view.findViewById(R.id.imdbId);
                typeView = view.findViewById(R.id.type);
            }
        }
    }
}