package ua.kpi.comsys.io8316;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private String year;

    @JsonProperty("imdbID")
    private String imdbId;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("Poster")
    private String poster;

    private int posterId;

    public Movie () {
    }

    public Movie (String title, String year, String imdbId, String type, String poster, int posterId) {
        this.title =title;
        this.year = year;
        this.imdbId = imdbId;
        this.type = type;
        this.poster = poster;
        this.posterId = posterId;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getImdbId() {
        return imdbId;
    }

    public String getType() {
        return type;
    }

    public String getPoster() {
        return poster;
    }

    public int getPosterId() {
        return posterId;
    }

    public void setPosterId(int posterId) {
        this.posterId = posterId;
    }
}
