package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repistory.AfishaRepository;

public class MovieManager {
    private AfishaRepository repo;
    private int movieQty = 10;


    public MovieManager(AfishaRepository repo) {
        this.repo = repo;
    }

    public MovieManager() {
        movieQty = 10;
    }

    public MovieManager(int movieQty) {
        this.movieQty = movieQty;
    }

    public void add(Movie item) {
        repo.save(item);
    }

    public Movie[] findAll() {
        return repo.findAll();
    }

    public Movie[] getMovies() {
        Movie[] all = repo.findAll();
        Movie[] reversed = new Movie[all.length];
        for (int i = 0; i < reversed.length; i++) {
            reversed[i] = all[all.length - 1 - i];
        }
        return reversed;
    }
}