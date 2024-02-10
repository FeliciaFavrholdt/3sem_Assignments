package APIExercise;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final String API_KEY = "b7a1db6486c1b588148100e2c843c588";
    public static Gson gson = new GsonBuilder()
//            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .setPrettyPrinting()
            .create();

    public static void main(String[] args) {

        final String API_KEY = "b7a1db6486c1b588148100e2c843c588";

        //Returns a movie by id
        MovieDTO movie = MovieController.getMovieById("550", API_KEY);

        //Returns a list of movies by rating
        List<MovieDTO> movies = MovieController.getByRating(MovieController.movies, 8.0);

        //Returns a list of movies by release date
        List<MovieDTO> moviesByReleaseDate = MovieController.getSortedByReleaseDate(MovieController.movies, 2010);
    }

    private static class LocalDateAdapter {
    }
}