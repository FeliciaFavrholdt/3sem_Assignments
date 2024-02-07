package APIExercise;

import java.io.IOException;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) throws IOException {
        //Create instance of MovieController
        MovieController movieController = new MovieController();

        //Request connection to API
        movieController.requestConnection("https://api.themoviedb.org/3/authentication");

        //Retrieve details about movie by title
        System.out.println("Details about movie by title");
        System.out.println(movieController.getByTitle());

        //Retrieve details about movie by id (IMDB)
        System.out.println("Details about movie by id");
        System.out.println(movieController.getById());

        //Get array of movies by rating
        System.out.println("Array of movies by rating");
        System.out.println(Arrays.toString(movieController.getAllByRating()));

        //Get array of movies by release date
        System.out.println("Array of movies by release date");
        System.out.println(Arrays.toString(movieController.getAllByReleaseDate()));
    }
}