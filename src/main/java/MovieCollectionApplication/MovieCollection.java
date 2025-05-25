package MovieCollectionApplication;

import java.util.HashMap;
import java.util.*;
import java.util.Iterator;

public class MovieCollection implements Iterable<Movie> {
    private final Map<String, Movie> movies = new HashMap<>();
    public void addMovie(Movie movie){
        movies.put(movie.getTitle(), movie);
    }
    public void removeMovie(String title){
        movies.remove(title);
    }
    public Movie findMovieByTitle(String title){
        return  movies.get(title);
    }
    public List<Movie> findMoviesByYear(int year) {
        return movies.values().stream()
                .filter(movie -> movie.getYear() == year)
                .toList();
    }
    public List<Movie> findMoviesByDirector(String director) {
        return movies.values().stream()
                .filter(movie -> movie.getDirector().equals(director))
                .toList();
    }

    public List<Movie> findMoviesByGenre(String genre) {
        return movies.values().stream()
                .filter(movie -> movie.getGenre().equals(genre))
                .toList();
    }
    @Override
    public Iterator<Movie> iterator(){
        return  movies.values().iterator();
    }

}
