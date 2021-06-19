package ru.netology.manager;

import ru.netology.domain.MovieItem;

public class PosterManager {
    private MovieItem[] items = new MovieItem[0];
    private int MovieAmount = 10;

    public PosterManager() {
    }

    public PosterManager(int MovieAmount) {
        this.MovieAmount = MovieAmount;
    }


    public void add(MovieItem item) {
        int length = items.length + 1;
        MovieItem[] tmp = new MovieItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public MovieItem[] getLastMovies() {

        int resultLength;
        if (MovieAmount > items.length) {
            resultLength = items.length;
        } else {
            resultLength = MovieAmount;
        }

        MovieItem[] result = new MovieItem[resultLength];
        for (int i = 0; i < resultLength; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}
