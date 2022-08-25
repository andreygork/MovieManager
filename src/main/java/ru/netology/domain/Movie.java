package ru.netology.domain;


public class Movie {
    private int id;
    private String movieName;
    private String movieUrl;
    private String movieGenre;

    public Movie(int id, String movieName, String movieUrl, String movieGenre) {
        this.id = id;
        this. movieName = movieName;
        this. movieUrl = movieUrl;
        this.movieGenre = movieGenre;
    }
}