package ThreadsExercise.Ex_6.dtos;

import java.util.ArrayList;
import java.util.List;

public class MegaDTO {
    private List<JokeDTO> jokeDTOList = new ArrayList<>();
    private List<ChuckNorrisDTO> chuckNorrisDTOList = new ArrayList<>();
    private List<KanyeDTO> kanyeDTOList = new ArrayList<>();
    private List<TrumpDTO> trumpDTOList = new ArrayList<>();
    private List<LaunchDTO> launchDTOList = new ArrayList<>();

    public void addJokeDTO(JokeDTO jokeDTO) {
        jokeDTOList.add(jokeDTO);
    }

    public void addChuckNorrisJokeDTO(ChuckNorrisDTO chuckNorrisDTO) {
        chuckNorrisDTOList.add(chuckNorrisDTO);
    }

    public void addKanyeQuoteDTO(KanyeDTO kanyeDTO) {
        kanyeDTOList.add(kanyeDTO);
    }

    public void addTrumpQuoteDTO(TrumpDTO trumpDTO) {
        trumpDTOList.add(trumpDTO);
    }

    public void addLaunchDTO(LaunchDTO launchDTO) {
        launchDTOList.add(launchDTO);
    }

    @Override
    public String toString() {
        return "MegaDTO{" +
                "jokeDTOList=" + jokeDTOList +
                ", chuckNorrisJokeDTOList=" + chuckNorrisDTOList +
                ", kanyeQuoteDTOList=" + kanyeDTOList +
                ", trumpQuoteDTOList=" + trumpDTOList +
                ", launchDTOList=" + launchDTOList +
                '}';
    }
}