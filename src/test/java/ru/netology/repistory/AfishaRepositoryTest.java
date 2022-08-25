package ru.netology.repistory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

public class AfishaRepositoryTest {

    AfishaRepository repo = new AfishaRepository();
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
    void setUp() {
        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.save(fourth);
        repo.save(fifth);
        repo.save(sixth);
        repo.save(seventh);
        repo.save(eighth);
        repo.save(ninth);
        repo.save(tenth);

    }
    @Test
    public void shouldRemoveById() {
        repo.removeById(ninth.getId());
        Movie[] expected = {first, second, third, fourth, fifth, sixth, seventh, eighth, tenth};
        Movie[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void shouldFindAll() {
        repo.findAll();
        Movie[] expected = {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        Movie[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindById () {
        Movie expected =new Movie (8, "naGrani", "https//", "triller");
        Movie actual = repo.findById(8);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void shouldFindInvalidId() {
        Movie actual = repo.findById(100);
        Movie expected = null;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldRemoveAll() {

        repo.RemoveAll();
        Movie[] expected = new  Movie[]{};
        Movie[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void shouldSave (){
        Movie MovieToAdd = new Movie(11, "Betmen", "https//", "triller");
        repo.save(MovieToAdd);
        Movie[] expected = {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, new Movie(11, "Betmen", "https//", "triller")};
        Movie[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}