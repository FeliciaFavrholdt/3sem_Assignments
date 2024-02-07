package APIExercise;

import java.io.IOException;
import java.time.LocalDate;


public class Main {

    public static void main(String[] args) throws IOException {
        MovieController<MovieDTO> movieController = new MovieController<MovieDTO>();

        //Request connection to API
        movieController.getResponseBody("https://api.themoviedb.org/3/authentication");

        //Retrieve details about movie by title
        System.out.println("Details about movie by title");

        //Retrieve details about movie by id (IMDB)
        System.out.println("Details about movie by id");

        //Get array of movies by rating
        System.out.println("Array of movies by rating");

        //Get array of movies by release date
        System.out.println("Array of movies by release date");
    }
}