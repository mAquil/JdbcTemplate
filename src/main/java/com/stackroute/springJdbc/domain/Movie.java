package com.stackroute.springJdbc.domain;

public class Movie {
    private String movieName;
    private int movieId;
    private int releaseYear;
    private int rating;

    public Movie() {
    }

    public Movie(String movieName, int movieId, int releaseYear, int rating) {
        this.movieName = movieName;
        this.movieId = movieId;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieName='" + movieName + '\'' +
                ", movieId='" + movieId + '\'' +
                ", releaseYear='" + releaseYear + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}
