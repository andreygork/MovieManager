package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.Movie;
import ru.netology.manager.MovieManager;
import ru.netology.repistory.AfishaRepository;

import static org.mockito.Mockito.*;

public class MovieManagerTest {
    AfishaRepository repo = Mockito.mock(AfishaRepository.class);
    MovieManager manager = new MovieManager(repo);

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

    @BeforeEach
    public void setUp() {
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
    }

    @Test
    public void shouldReversedAllMovies() {
        Movie[] items = {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(items).when(repo).findAll();

        Movie[] expected = {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        Movie[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReversedFindLast() {
        Movie[] items = {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(items).when(repo).findAll();

        Movie[] expected = {tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        Movie[] actual = manager.getMovies();
        Assertions.assertArrayEquals(expected, actual);
    }
}