package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PosterManagerTest {
  MovieItem movie1 = new MovieItem(1, 1, "URL", "Бладшот", "боевик");
  MovieItem movie2 = new MovieItem(2, 2, "URL", "Вперёд", "мультфильм");
  MovieItem movie3 = new MovieItem(3, 3, "URL", "Отель Белград", "комедия");
  MovieItem movie4 = new MovieItem(4, 4, "URL", "Джентльмены", "боевик");
  MovieItem movie5 = new MovieItem(5, 5, "URL", "Человек-невидимка", "ужасы");
  MovieItem movie6 = new MovieItem(6, 6, "URL", "Тролли. Мировой тур", "мультфильм");
  MovieItem movie7 = new MovieItem(7, 7, "URL", "Номер один", "комедия");
  MovieItem movie8 = new MovieItem(8, 8, "URL", "Бойцовский клуб", "триллер");
  MovieItem movie9 = new MovieItem(9, 9, "URL", "Душа", "мультфильм");
  MovieItem movie10 = new MovieItem(10, 10, "URL", "Гарри Поттер и философский камень", "фентези");
  MovieItem movie11 = new MovieItem(11, 11, "URL", "Пятый элемент", "боевик");

  @Test
  public void tenLastMovis() {
    PosterManager manager = new PosterManager();

    manager.add(movie1);
    manager.add(movie2);
    manager.add(movie3);
    manager.add(movie4);
    manager.add(movie5);
    manager.add(movie6);
    manager.add(movie7);
    manager.add(movie8);
    manager.add(movie9);
    manager.add(movie10);
    manager.add(movie11);

    MovieItem[] actual = manager.getLastMovies();
    MovieItem[] expected = new MovieItem[]{movie11, movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2};

    assertArrayEquals(expected, actual);
  }

  @Test
  public void tenLastMovis2() {
    PosterManager manager = new PosterManager();

    manager.add(movie1);
    manager.add(movie2);
    manager.add(movie3);
    manager.add(movie4);
    manager.add(movie5);
    manager.add(movie6);
    manager.add(movie7);
    manager.add(movie8);
    manager.add(movie9);
    manager.add(movie10);

    MovieItem[] actual = manager.getLastMovies();
    MovieItem[] expected = new MovieItem[]{movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2, movie1};

    assertArrayEquals(expected, actual);
  }

  @Test
  public void threeMovies() {
    PosterManager manager = new PosterManager(3);

    manager.add(movie1);
    manager.add(movie2);
    manager.add(movie3);

    MovieItem[] actual = manager.getLastMovies();
    MovieItem[] expected = new MovieItem[]{movie3, movie2, movie1};
    assertArrayEquals(expected, actual);
  }

  @Test
  public void lessTen() {
    PosterManager manager = new PosterManager();

    manager.add(movie1);
    manager.add(movie2);
    manager.add(movie3);

    MovieItem[] actual = manager.getLastMovies();
    MovieItem[] expected = new MovieItem[]{movie3, movie2, movie1};
    assertArrayEquals (expected, actual);
  }
}