package APIExercise;
public interface Media <T> {
    T getByRating(double rating);

    T getSortedByReleaseDate(int releaseYear);
}