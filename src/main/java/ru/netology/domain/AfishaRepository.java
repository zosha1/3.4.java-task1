package ru.netology.domain;

public class AfishaRepository {
    private MovieItem[] items = new MovieItem[0];

    public void removeAll() {
        items = new MovieItem[0];
    }

    public void save(MovieItem item) {
        int length = items.length + 1;
        MovieItem[] tmp = new MovieItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public MovieItem[] findAll() {
        return items;
    }

    public void removeById(int id) {
        boolean idFound = false;
        for (MovieItem item : items) {
            if (item.getId() == id) {
                idFound = true;
            }
        }
        if (idFound) {
            int length = items.length - 1;
            MovieItem[] tmp = new MovieItem[length];
            int index = 0;
            for (MovieItem item : items) {
                if (item.getId() != id) {
                    tmp[index] = item;
                    index++;
                }
            }
            items = tmp;
        }
    }

    public MovieItem findById(int id) {
        MovieItem movie = null;
        for (MovieItem item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return movie;
    }
}
