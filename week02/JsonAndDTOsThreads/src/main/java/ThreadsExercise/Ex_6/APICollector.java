package ThreadsExercise.Ex_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

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

public class APICollector {

    public static void main(String[] args) throws Exception {

        //Solution using ExecutorService
        List<Future<JokeDTO>> futures = new ArrayList<>();

        String[] urls = new String[]{
                "https://icanhazdadjoke.com/api",
                "https://api.chucknorris.io/jokes/random",
                "https://api.kanye.rest",
                "https://api.whatdoestrumpthink.com/api/v1/quotes/random",
                "https://api.spacexdata.com/v5/launches/latest",
                "https://catfact.ninja/fact",
                "https://api.agify.io/?name=felicia",
                "https://dog.ceo/api/breeds/image/random",
                "https://restcountries.com/v3.1/name/Spain?fullText=true",
                "https://catfact.ninja/fact",
        };

        ExecutorService executor = Executors.newFixedThreadPool(10);

    }
}


//Solution using CompletableFuture
        /*List<String> urls = List.of(
                "https://icanhazdadjoke.com/",
                "https://api.chucknorris.io/jokes/random",
                "https://api.kanye.rest",
                "https://api.whatdoestrumpthink.com/api/v1/quotes/random",
                "https://api.spacexdata.com/v5/launches/latest"
        );

        CompletableFuture<JokeDTO> dadJokeFuture = fetchData(urls.get(0)).thenApply(JokeDTO::new);
        CompletableFuture<String> chuckNorrisJokeFuture = fetchData(urls.get(1));
        CompletableFuture<String> kanyeQuoteFuture = fetchData(urls.get(2));
        CompletableFuture<QuoteDTO> trumpQuoteFuture = fetchData(urls.get(3)).thenApply(QuoteDTO::new);
        CompletableFuture<String> spacexLatestLaunchFuture = fetchData(urls.get(4));

        CompletableFuture<MegaDTO> allFutures = CompletableFuture.allOf(
                        dadJokeFuture, chuckNorrisJokeFuture, kanyeQuoteFuture, trumpQuoteFuture, spacexLatestLaunchFuture)
                .thenApply(voidResult -> {
                    try {
                        System.out.println("All data has been fetched");
                        return new MegaDTO(
                                dadJokeFuture.get(),
                                chuckNorrisJokeFuture.get(),
                                kanyeQuoteFuture.get(),
                                trumpQuoteFuture.get(),
                                spacexLatestLaunchFuture.get()
                        );
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Error");
                    return null;
                });

        MegaDTO megaDTO = allFutures.get();
        System.out.println(megaDTO.toString());
    }

    public static CompletableFuture<String> fetchData(String url) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                URL apiUrl = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Accept", "application/json");
                connection.setRequestProperty("User-Agent", "Java Application");

                StringBuilder content;
                try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String line;
                    content = new StringBuilder();
                    while ((line = in.readLine()) != null) {
                        content.append(line);
                        content.append(System.lineSeparator());
                    }
                }

                connection.disconnect();
                return content.toString().trim();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        });
    }*/