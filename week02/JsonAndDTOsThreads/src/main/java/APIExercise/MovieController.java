package APIExercise;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static APIExercise.Main.gson;

public class MovieController {

    public static List<MovieDTO> movies = new ArrayList<>();

    // method to get movies by rating
    public static List<MovieDTO> getByRating(List<MovieDTO> movies, double rating) {
        return movies.stream().filter(movieDTO -> movieDTO.getVote_average() >= rating)
                .collect(Collectors.toList());
    }

    // method to get movies by release date
    public static List<MovieDTO> getSortedByReleaseDate(List<MovieDTO> movies, int releaseYear) {

        return movies.stream()
                .sorted(Comparator.comparing(MovieDTO::getRelease_date))
                .collect(Collectors.toList());
    }

    // method to get movie by id
    public static MovieDTO getMovieById(String id, String apiKey) {
        String url = "https://api.themoviedb.org/3/movie/{id}?api_key={key}"
                .replace("{id}", id)
                .replace("{key}", apiKey);

        String response = getResponseByAPIKey(url);
        System.out.println("JSON: " + response);

        MovieDTO movieDTO = gson.fromJson(response, MovieDTO.class);
        System.out.println("Movie title: " + movieDTO.getTitle());

        return movieDTO;
    }

    public static String getResponseByAPIKey(String url) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request req = new Request.Builder()
                .url(url)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiN2ExZGI2NDg2YzFiNTg4MTQ4MTAwZTJjODQzYzU4OCIsInN1YiI6IjY1YmZlZGJhZmM2NTM4MDE0OWU5NjBmYSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.Vn8w-mIE8MCYtayQcyOkbCyTG2PQKlZy1eV2H9cazlQ")
                .build();
        try {
            Response res = client.newCall(req).execute();
            return res.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    public String getMovieById(String movieId, String key) {
//        String url = "https://api.themoviedb.org/3/movie/{id}?api_key={key}"
//                .replace("{id}", movieId)
//                .replace("{key}", key);
//
//        String response = getResponseByAPIKey(url);
//        System.out.println("JSON: " + response);
//
//        MovieDTO movieDTO = gson.fromJson(response, MovieDTO.class);
//        System.out.println("Movie title: " + movieDTO.getTitle());
//        return response;
//    }
}