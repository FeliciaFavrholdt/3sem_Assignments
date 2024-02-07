package ThreadsExercise.Ex_6;

public class MegaDTO {
    private final JokeDTO dadJoke;
    private final String chuckNorrisJoke;
    private final String kanyeQuote;
    private final QuoteDTO trumpQuote;
    private final String spacexLatestLaunch;

    public MegaDTO(JokeDTO dadJoke, String chuckNorrisJoke, String kanyeQuote, QuoteDTO trumpQuote, String spacexLatestLaunch) {
        this.dadJoke = dadJoke;
        this.chuckNorrisJoke = chuckNorrisJoke;
        this.kanyeQuote = kanyeQuote;
        this.trumpQuote = trumpQuote;
        this.spacexLatestLaunch = spacexLatestLaunch;
    }

    @Override
    public String toString() {
        return "MegaDTO{" +
                "dadJoke: =" + dadJoke.getJoke() + "\n" +
                ", chuckNorrisJoke: " + chuckNorrisJoke + "\n" +
                ", kanyeQuote: " + kanyeQuote + "\n" +
                ", trumpQuote: " + trumpQuote.getQuote() + "\n" +
                ", spacexLatestLaunch: " + spacexLatestLaunch + "\n" +
                '}';
    }
}