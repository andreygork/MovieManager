package ru.netology.repistory;

import ru.netology.domain.Movie;

public class AfishaRepository {
    private Movie[] items = new Movie[0];

    public Movie[] findAll() {
        return items;
    }

    public void RemoveAll() {
        items = new Movie[0];
    }

    public void save(Movie item) {
        Movie[] tmp = new Movie[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public void removeById(int id) {
        Movie[] tmp = new Movie[items.length - 1];
        int copyToIndex = 0;
        for (Movie item : items) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = tmp;
    }

    public Movie findById(int id) {
        for (Movie item : items) {
            if (item.getId() == id) {
                return item;

            }
        }

        return null;
    }
}
