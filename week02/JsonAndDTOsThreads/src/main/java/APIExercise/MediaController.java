package APIExercise;

public interface MediaController<T> {

    T requestConnection(String url);
    T getById(String id);

    T[] getAllByRating();
    T[] getAllByReleaseDate();
    T getByTitle();
}