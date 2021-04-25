package ua.kpi.comsys.io8316;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MoviesDto {
    @JsonProperty("Search")
    private List<Movie> movies;

    public MoviesDto() {
    }

    public MoviesDto(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
