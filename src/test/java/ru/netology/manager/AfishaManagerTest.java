package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.AfishaRepository;
import ru.netology.domain.MovieItem;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AfishaManagerTest {

    private AfishaRepository repository = Mockito.mock(AfishaRepository.class);

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

    @Test
    public void tenLastMovis() {
        AfishaManager manager = new AfishaManager(repository);
        MovieItem[] returned = new MovieItem[]{movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10, movie11};
        doReturn(returned).when(repository).findAll();

        MovieItem[] actual = manager.getLastMovies();
        MovieItem[] expected = new MovieItem[]{movie11, movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void tenLastMovis2() {
        AfishaManager manager = new AfishaManager(repository);

        MovieItem[] returned = new MovieItem[]{movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10};
        doReturn(returned).when(repository).findAll();

        MovieItem[] actual = manager.getLastMovies();
        MovieItem[] expected = new MovieItem[]{movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2, movie1};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void threeMovies() {
        AfishaManager manager = new AfishaManager(3, repository);

        MovieItem[] returned = new MovieItem[]{movie1, movie2, movie3};
        doReturn(returned).when(repository).findAll();

        MovieItem[] actual = manager.getLastMovies();
        MovieItem[] expected = new MovieItem[]{movie3, movie2, movie1};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void lessTen() {
        AfishaManager manager = new AfishaManager(repository);

        MovieItem[] returned = new MovieItem[]{movie1, movie2, movie3};
        doReturn(returned).when(repository).findAll();

        MovieItem[] actual = manager.getLastMovies();
        MovieItem[] expected = new MovieItem[]{movie3, movie2, movie1};
        assertArrayEquals(expected, actual);
    }
}