package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import ru.netology.manager.MovieManager;

public class MovieManagerTest {
    MovieManager manager = new MovieManager();
    private Movie first = new Movie(1, "Bladshot", "https//", "action");
    private Movie second = new Movie(2, "Vpered", "https//", "cartoon");
    private Movie third = new Movie(3, "HotelBelgrad", "https//", "comedy");
    private Movie fourth = new Movie(4, "Gentlmeny", "https//", "action");
    private Movie fifth = new Movie(5, "ChelovekNevidimka", "https//", "horror");
    private Movie sixth = new Movie(6, "TrolliMirovoyTur", "https//", "cartoon");
    private Movie seventh = new Movie(7, "NomerOdin", "https//", "comedy");
    private Movie eighth = new Movie(8, "naGrani", "https//", "triller");
    private Movie ninth = new Movie(9, "Terminal", "https//", "drama");
    private Movie tenth = new Movie(10, "Biven'", "https//", "triller");

    @Test
    public void shouldAddMovies () {
        MovieManager manager = new MovieManager();
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        Movie[] expected = {first, second, third, fourth, fifth};
        Movie[] actual = manager.getAll();
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void shouldGetEmpty () {
        MovieManager manager = new MovieManager();
        Movie[] expected = {};
        Movie[] actual = manager.getAll();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldGetLastMovie(){
        MovieManager manager = new MovieManager(5);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        Movie[] expected = {tenth, ninth, eighth, seventh, sixth};
        Movie[] actual = manager.getLastMovie();
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void shouldNoMovie(){
        MovieManager manager = new MovieManager(10);
        Movie[] actual = manager.getLastMovie();
        Movie[] expected = new Movie[]{};
        Assertions.assertArrayEquals(expected, actual);
    }
}