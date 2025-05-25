package MovieCollectionApplication;

public class Movie {
    private final String title;
    private final int year;
    private final String director;
    private final String genre;

    public Movie(String title, int year, String director, String genre) {
        this.title = title;
        this.year = year;
        this.director = director;
        this.genre = genre;
    }
    public String getTitle(){return title;}
    public int getYear(){return year;}
    public String getDirector(){return  director;}
    public String getGenre(){return  genre;}
}
