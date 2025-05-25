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
    @Override
    public Iterator<Movie> iterator(){
        return  movies.values().iterator();
    }
}
