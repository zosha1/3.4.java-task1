package ru.netology.manager;

import ru.netology.domain.AfishaRepository;
import ru.netology.domain.MovieItem;

public class AfishaManager {
    private AfishaRepository repository = new AfishaRepository();

    private MovieItem[] items = new MovieItem[0];
    private int movieAmount = 10;

    public AfishaManager(int movieAmount, AfishaRepository repository) {
        this.movieAmount = movieAmount;
        this.repository = repository;
    }

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public void add(MovieItem item) {
        repository.save(item);
    }

    public MovieItem[] getLastMovies() {
        MovieItem[] movies = repository.findAll();
        int resultLength;
        if (movieAmount > movies.length) {
            resultLength = movies.length;
        } else {
            resultLength = movieAmount;
        }

        MovieItem[] result = new MovieItem[resultLength];
        for (int i = 0; i < resultLength; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}
