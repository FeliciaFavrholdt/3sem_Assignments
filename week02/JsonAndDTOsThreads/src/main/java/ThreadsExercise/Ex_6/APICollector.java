package ThreadsExercise.Ex_6;

import com.google.gson.Gson;

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


//Solution using ExecutorService
public class APICollector {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
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
    }
}