package ThreadsExercise.Ex_6;

import ThreadsExercise.Ex_6.dtos.JokeDTO;
import ThreadsExercise.Ex_6.dtos.MegaDTO;

import java.util.ArrayList;
import java.util.concurrent.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;


//Exercise Description:
/* Create a program to get data from 10 different web services (APIs) at the same time.
   Get the returned value from the web service and save it in DTOs.
   Collect all the DTO data in a mega DTO and print it out in a nice format.
   Examples of APIs to use:
   String[] urls = new String[]{
        "https://icanhazdadjoke.com/api",
        "https://api.chucknorris.io/jokes/random",
        "https://api.kanye.rest",
        "https://api.whatdoestrumpthink.com/api/v1/quotes/random",
        "https://api.spacexdata.com/v5/launches/latest"
    };
*/


//Solution using ExecutorService
public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        String[] urls = new String[]{
                "https://icanhazdadjoke.com/api",
                "https://api.chucknorris.io/jokes/random",
                "https://api.kanye.rest",
                "https://api.whatdoestrumpthink.com/api/v1/quotes/random",
                "https://api.spacexdata.com/v5/launches/latest"
        };

        ExecutorService executorService = Executors.newFixedThreadPool(urls.length);
        MegaDTO megaDTO = new MegaDTO();

        List<Callable<Void>> tasks = new ArrayList<>();

        for (String url : urls) {
            tasks.add(() -> {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .header("Accept", "application/json")
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                switch (url) {
                    case "https://icanhazdadjoke.com/api":
                        JokeDTO jokeDTO = new JokeDTO();
                        jokeDTO.setJoke(response.body());
                        megaDTO.addJokeDTO(jokeDTO);
                        break;
                    case "https://api.chucknorris.io/jokes/random":
                        ChuckNorrisJokeDTO chuckNorrisJokeDTO = new ChuckNorrisJokeDTO();
                        chuckNorrisJokeDTO.setValue(response.body());
                        megaDTO.addChuckNorrisJokeDTO(chuckNorrisJokeDTO);
                        break;
                    case "https://api.kanye.rest":
                        KanyeQuoteDTO kanyeQuoteDTO = new KanyeQuoteDTO();
                        kanyeQuoteDTO.setQuote(response.body());
                        megaDTO.addKanyeQuoteDTO(kanyeQuoteDTO);
                        break;
                    case "https://api.whatdoestrumpthink.com/api/v1/quotes/random":
                        TrumpQuoteDTO trumpQuoteDTO = new TrumpQuoteDTO();
                        trumpQuoteDTO.setMessage(response.body());
                        megaDTO.addTrumpQuoteDTO(trumpQuoteDTO);
                        break;
                    case "https://api.spacexdata.com/v5/launches/latest":
                        LaunchDTO launchDTO = new LaunchDTO();
                        launchDTO.setDetails(response.body());
                        megaDTO.addLaunchDTO(launchDTO);
                        break;
                    default:
                        System.out.println("Invalid URL: " + url);
                }

                return null;
            });
        }

        executorService.invokeAll(tasks);
        executorService.shutdown();

        System.out.println(megaDTO);
    }
}