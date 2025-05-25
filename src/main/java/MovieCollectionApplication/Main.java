package MovieCollectionApplication;

public class Main {
    public static void main(String[] args) {
        MovieCollection collection = new MovieCollection();

        //тестируем добавление фильма
         collection.addMovie(new Movie("Начало", 2010, "Нолан", "Фантастика"));
        collection.addMovie(new Movie("Мстители", 2012, "Уидон", "Комикс"));
        collection.addMovie(new Movie("111", 2005, "WIlson", "Ужасы"));

        //тестируем поиск
         System.out.println(collection.findMovieByTitle("Начало").getDirector());
        System.out.println(collection.findMoviesByYear(2012).size());
        //тестируем итератор
        for(Movie movie : collection){
            System.out.println(movie.getTitle());
            System.out.println(movie.getGenre());
            System.out.println(movie.getYear());
            System.out.println(movie.getDirector());
        }
        System.out.println(collection.getAllMovies().size());
        collection.removeMovie("111");
        System.out.println(collection.getAllMovies().size());

    }
}
