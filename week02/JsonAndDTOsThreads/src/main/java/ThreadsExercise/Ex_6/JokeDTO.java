package ThreadsExercise.Ex_6;

class JokeDTO {
    private String source;
    private String joke;

    // Constructor, getters, and setters
    public JokeDTO(String source, String joke) {
        this.source = source;
        this.joke = joke;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    @Override
    public String toString() {
        return source + ": " + joke;
    }
}