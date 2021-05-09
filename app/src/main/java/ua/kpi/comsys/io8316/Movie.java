package ua.kpi.comsys.io8316;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private String year;

    @JsonProperty("Rated")
    private String rated;

    @JsonProperty("Released")
    private String released;

    @JsonProperty("Runtime")
    private String runtime;

    @JsonProperty("Genre")
    private String genre;

    @JsonProperty("Director")
    private String director;

    @JsonProperty("Writer")
    private String writer;

    @JsonProperty("Actors")
    private String actors;

    @JsonProperty("Plot")
    private String plot;

    @JsonProperty("Language")
    private String language;

    @JsonProperty("Country")
    private String country;

    @JsonProperty("Awards")
    private String awards;

    @JsonProperty("Poster")
    private String poster;

    @JsonProperty("imdbRating")
    private String imdbRating;

    @JsonProperty("imdbVotes")
    private String imdbVotes;

    @JsonProperty("imdbID")
    private String imdbId;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("Production")
    private String production;

    private int posterId;

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getRated() {
        return rated;
    }

    public String getReleased() {
        return released;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public String getWriter() {
        return writer;
    }

    public String getActors() {
        return actors;
    }

    public String getPlot() {
        return plot;
    }

    public String getLanguage() {
        return language;
    }

    public String getCountry() {
        return country;
    }

    public String getAwards() {
        return awards;
    }

    public String getPoster() {
        return poster;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public String getImdbId() {
        return imdbId;
    }

    public String getType() {
        return type;
    }

    public String getProduction() {
        return production;
    }

    public int getPosterId() {
        return posterId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPosterId() {
        switch (poster) {
            case "Poster_01.jpg":
                posterId = R.drawable.poster_01;
                break;
            case "Poster_02.jpg":
                posterId = R.drawable.poster_02;
                break;
            case "Poster_03.jpg":
                posterId = R.drawable.poster_03;
                break;
            case "Poster_05.jpg":
                posterId = R.drawable.poster_05;
                break;
            case "Poster_06.jpg":
                posterId = R.drawable.poster_06;
                break;
            case "Poster_07.jpg":
                posterId = R.drawable.poster_07;
                break;
            case "Poster_08.jpg":
                posterId = R.drawable.poster_08;
                break;
            case "Poster_10.jpg":
                posterId = R.drawable.poster_10;
                break;
            default:
                break;
        }
    }
}