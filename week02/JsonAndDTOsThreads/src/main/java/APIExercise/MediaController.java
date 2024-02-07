package APIExercise;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface MediaController<T> { ;

    String getResponseBody(String url);
    T getById(String id);
    T[] getAllByRating(String rating);
    T[] getAllByReleaseDate();
}