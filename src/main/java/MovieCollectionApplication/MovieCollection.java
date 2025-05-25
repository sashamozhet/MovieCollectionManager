package MovieCollectionApplication;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.*;
import java.util.Iterator;

public class MovieCollection implements Iterable<Movie> {
    private final Map<String, Movie> movies = new HashMap<>();
    private static final int MIN_YEAR = 1888; // Год первого фильма
    private static final int MAX_YEAR = LocalDate.now().getYear() + 2;
    public void addMovie(Movie movie) {
        if (movie == null) {
            throw new IllegalArgumentException("Фильм не может быть null");
        }
        if (movie.getTitle() == null || movie.getTitle().isBlank()) {
            throw new IllegalArgumentException("Название фильма не может быть пустым");
        }
        if (movie.getYear() < MIN_YEAR || movie.getYear() > MAX_YEAR) {
            throw new IllegalArgumentException(
                    String.format("Год должен быть между %d и %d", MIN_YEAR, MAX_YEAR)
            );
        }
        if (movies.containsKey(movie.getTitle())) {
            throw new IllegalArgumentException(
                    "Фильм '" + movie.getTitle() + "' уже существует"
            );
        }
        movies.put(movie.getTitle(), movie);
    }
    public void removeMovie(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Название для удаления не может быть пустым");
        }
        if (!movies.containsKey(title)) {
            throw new IllegalArgumentException("Фильм с названием '" + title + "' не найден");
        }
        movies.remove(title);
    }

    public Movie findMovieByTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Название для поиска не может быть пустым");
        }
        return movies.get(title);
    }

    public List<Movie> findMoviesByYear(int year) {
        if (year < MIN_YEAR || year > MAX_YEAR) {
            throw new IllegalArgumentException(
                    String.format("Год должен быть между %d и %d", MIN_YEAR, MAX_YEAR)
            );
        }
        return movies.values().stream()
                .filter(movie -> movie.getYear() == year)
                .toList(); // Java 17+
    }
    public List<Movie> findMoviesByDirector(String director) {
        if (director == null || director.isBlank()) {
            throw new IllegalArgumentException("Имя режиссера не может быть пустым");
        }
        return movies.values().stream()
                .filter(movie -> director.equalsIgnoreCase(movie.getDirector()))
                .toList();
    }

    public List<Movie> findMoviesByGenre(String genre) {
        if (genre == null || genre.isBlank()) {
            throw new IllegalArgumentException("Жанр не может быть пустым");
        }
        return movies.values().stream()
                .filter(movie -> genre.equalsIgnoreCase(movie.getGenre()))
                .toList();
    }
    @Override
    public Iterator<Movie> iterator(){
        return  movies.values().iterator();
    }
    public List<Movie> getAllMovies() {
        return movies.values().stream().toList();
    }

}
