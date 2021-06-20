package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.AfishaRepository;
import ru.netology.domain.MovieItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AfishaRepositoryTest {
    private AfishaRepository repository = new AfishaRepository();

    private MovieItem movie1 = new MovieItem(1, 1, "URL", "Бладшот", "боевик");
    private MovieItem movie2 = new MovieItem(2, 2, "URL", "Вперёд", "мультфильм");
    private MovieItem movie3 = new MovieItem(3, 3, "URL", "Отель Белград", "комедия");
    private MovieItem movie4 = new MovieItem(4, 4, "URL", "Джентльмены", "боевик");
    private MovieItem movie5 = new MovieItem(5, 5, "URL", "Человек-невидимка", "ужасы");
    private MovieItem movie6 = new MovieItem(6, 6, "URL", "Тролли. Мировой тур", "мультфильм");
    private MovieItem movie7 = new MovieItem(7, 7, "URL", "Номер один", "комедия");
    private MovieItem movie8 = new MovieItem(8, 8, "URL", "Бойцовский клуб", "триллер");
    private MovieItem movie9 = new MovieItem(9, 9, "URL", "Душа", "мультфильм");
    private MovieItem movie10 = new MovieItem(10, 10, "URL", "Гарри Поттер и философский камень", "фентези");
    private MovieItem movie11 = new MovieItem(11, 11, "URL", "Пятый элемент", "боевик");

    @BeforeEach
    public void setUp() {
        repository.save(movie1);
        repository.save(movie2);
        repository.save(movie3);
    }

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 1;
        repository.removeById(idToRemove);

        MovieItem[] actual = repository.findAll();
        MovieItem[] expected = new MovieItem[]{movie2, movie3};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 4;
        repository.removeById(idToRemove);

        MovieItem[] actual = repository.findAll();
        MovieItem[] expected = new MovieItem[]{movie1, movie2, movie3};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findByIdNotExists() {
        MovieItem actual = repository.findById(7);
        MovieItem expected = null;

        assertEquals(expected, actual);
    }

    @Test
    public void findById() {
        MovieItem actual = repository.findById(2);
        MovieItem expected = movie2;

        assertEquals(expected, actual);
    }

    @Test
    public void removeAll() {
        repository.removeAll();
        MovieItem[] actual = repository.findAll();
        MovieItem[] expected = new MovieItem[0];

        assertArrayEquals(actual, expected);
    }
}
