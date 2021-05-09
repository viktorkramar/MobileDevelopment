package ua.kpi.comsys.io8316;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MoviesFragment extends Fragment {
    private List<Movie> movies;
    private List<Movie> filteredMovies;
    private MoviesAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMovies();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movies_fragment, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        filteredMovies = new ArrayList<>(movies);
        adapter = new MoviesAdapter(filteredMovies);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(adapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        EditText editText = view.findViewById(R.id.edittext);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
        FloatingActionButton button = view.findViewById(R.id.addingBtn);
        button.setOnClickListener(v -> addMovie());
        return view;
    }

    private void addMovie() {
        LayoutInflater inflater = LayoutInflater.from(this.getContext());
        View v = inflater.inflate(R.layout.add_movie,null);
        AlertDialog.Builder addDialog = new AlertDialog.Builder(this.getContext());
        addDialog.setView(v);
        addDialog.setPositiveButton("OK", (dialog, id) -> {
            Movie movie = new Movie();
            movie.setTitle(((EditText) v.findViewById(R.id.title)).getText().toString());
            movie.setYear(((EditText) v.findViewById(R.id.year)).getText().toString());
            movie.setType(((EditText) v.findViewById(R.id.type)).getText().toString());
            movies.add(movie);
            filter("");
            dialog.cancel();
        });
        addDialog.setNegativeButton("Cancel", (dialog, id) -> dialog.cancel());
        addDialog.create();
        addDialog.show();
    }

    private void getMovies() {
        try {
            InputStream inputStream = getResources().openRawResource(R.raw.movies);
            String moviesJson = new Scanner(inputStream).useDelimiter("\\A").next();
            ObjectMapper objectMapper = new ObjectMapper();
            MoviesDto moviesDto = objectMapper.readValue(moviesJson, MoviesDto.class);
            movies = moviesDto.getMovies();
            movies.forEach(Movie::setPosterId);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private void filter(String text) {
        filteredMovies =
                movies.stream().filter(movie -> movie.getTitle().toLowerCase().contains(text.toLowerCase()))
                        .collect(Collectors.toList());
        adapter.setMovies(filteredMovies);
    }

    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder,
                              @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            int position = viewHolder.getAbsoluteAdapterPosition();
            switch (direction) {
                case ItemTouchHelper.LEFT:
                    Movie movie = filteredMovies.get(position);
                    movies.remove(movie);
                    filteredMovies.remove(movie);
                    adapter.notifyItemRemoved(position);
                    break;
                case ItemTouchHelper.RIGHT:
                    break;
            }

        }
    };
}