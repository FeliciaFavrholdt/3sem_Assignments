package APIExercise;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MovieController {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    List<MovieDTO> movies = Arrays.asList(
            new MovieDTO("The Shawshank Redemption", "1994-10-14", 9.3, "tt0111161"),
            new MovieDTO("The Godfather", "1972-03-24", 9.2, "tt0068646"),
            new MovieDTO("The Dark Knight", "2008-07-18", 9.0, "tt0468569"),
            new MovieDTO("The Godfather: Part II", "1974-12-20", 9.0, "tt0071562"),
            new MovieDTO("The Lord of the Rings: The Return of the King", "2003-12-17", 8.9, "tt0167260"),
            new MovieDTO("Pulp Fiction", "1994-10-14", 8.9, "tt0110912"),
            new MovieDTO("12 angry Men", "1957-04-10", 8.9, "tt0050083"),
            new MovieDTO("The Good, the Bad and the Ugly", "1966-12-29", 8.8, "tt0060196"),
            new MovieDTO("Forrest Gump", "1994-07-06", 8.8, "tt0109830"),
            new MovieDTO("Fight Club", "1999-10-15", 8.8, "tt0137523"),
            new MovieDTO("Inception", "2010-07-16", 8.7, "tt1375666")
    );


    public String requestConnection(String url) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                //.url("https://api.themoviedb.org/3/authentication")
                .url(url)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiN2ExZGI2NDg2YzFiNTg4MTQ4MTAwZTJjODQzYzU4OCIsInN1YiI6IjY1YmZlZGJhZmM2NTM4MDE0OWU5NjBmYSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.Vn8w-mIE8MCYtayQcyOkbCyTG2PQKlZy1eV2H9cazlQ")
                .build();

        try {
            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();
            System.out.println(responseBody);
            return responseBody;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public String getByTitle() {
        return requestConnection("https://api.themoviedb.org/3/search/movie?query={movieTitle}"
                .replace("{movieTitle}", getByTitle()));
    }

    public String getById() {
        return requestConnection("https://api.themoviedb.org/3/find/{movieID}?external_source=imdb_id"
                .replace("{movieID}", getById()));
    }

    public double[] getAllByRating(double rating) {
        return movies.stream()
                .filter(movie -> movie.getRating() == rating)
                .mapToDouble(MovieDTO::getRating)
                .toArray();
    }

    public double[] getAllByReleaseDate(String releaseDate) {
        return movies.stream()
                .filter(movie -> movie.getReleaseDate().equals(releaseDate))
                .mapToDouble(MovieDTO::getRating)
                .toArray();
    }
}
