package APIExercise;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class MovieController<MovieDTO> implements MediaController<MovieDTO> {

    @Override
    public String getResponseBody(String url) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiN2ExZGI2NDg2YzFiNTg4MTQ4MTAwZTJjODQzYzU4OCIsInN1YiI6IjY1YmZlZGJhZmM2NTM4MDE0OWU5NjBmYSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.Vn8w-mIE8MCYtayQcyOkbCyTG2PQKlZy1eV2H9cazlQ")
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            System.out.println("Connection to API successful");
        } catch (IOException e) {
            throw new RuntimeException("Connection to API failed");
        }
        try {
            return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse response body");
        }

    }

    @Override
    public MovieDTO getById(String id) {
        return null;
    }

    @Override
    public MovieDTO[] getAllByRating(String rating) {
        return null;
    }

    @Override
    public MovieDTO[] getAllByReleaseDate() {
        return null;
    }
}
