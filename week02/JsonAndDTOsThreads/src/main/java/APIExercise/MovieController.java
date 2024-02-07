package APIExercise;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class MovieController {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

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
        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }

    public boolean getByTitle() {
        return false;
    }

    public boolean getById() {
        return false;
    }

    public double[] getAllByRating() {
        return new double[0];
    }

    public double[] getAllByReleaseDate() {
        return new double[0];
    }
}
