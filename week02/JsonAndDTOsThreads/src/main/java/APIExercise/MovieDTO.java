package APIExercise;

import java.time.LocalDate;

public class MovieDTO {

    private String title;
    private String releaseDate;
    private double rating;
    private String id;


    public MovieDTO() {
    }

    public MovieDTO(String title, String releaseDate, double rating, String id) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public double getRating() {
        return rating;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "title='" + title + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", rating=" + rating +
                ", id='" + id + '\'' +
                '}';
    }
}


