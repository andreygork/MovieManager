package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieManager {
    private Movie[] items = new Movie[0];
    private int movieQty;

    public MovieManager(int movieQty) {
        this.movieQty = movieQty;
    }

    public MovieManager() {
    }

    public void add(Movie item) {
        Movie tmp[] = new Movie[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public Movie[] getAll() {
        return items;

    }

    public Movie[] getLastMovie() {
        int limit = movieQty;
        if (limit > movieQty) {
            limit = movieQty;
        }
        int resultLength = limit < items.length ? limit : items.length;
        Movie[] result = new Movie[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = items[items.length - 1 - i];
        }
        return result;
    }
}
