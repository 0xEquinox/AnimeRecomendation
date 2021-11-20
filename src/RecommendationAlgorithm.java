import java.util.ArrayList;
import java.util.Arrays;

public class RecommendationAlgorithm {

    private User user;
    private ArrayList<AnimeShow> animes;

    public RecommendationAlgorithm(User user, ArrayList<AnimeShow> animes) {
        this.user = user;
        this.animes = animes;
    }

    public void getRecommendations() {

        findCommonGenres();
        sortRecomendations();

    }

    private void findCommonGenres() {

        for (AnimeShow anime : animes) {

            for (String genre : anime.getGenre()) {

                if(Arrays.stream(user.getGenerePreferences()).anyMatch(genre::equals) && !user.getRecomendations().contains(anime)) {
                    user.addRecomendation(anime);
                }

            }

        }

    }

    private void sortRecomendations() {

        int firstCount = 0;
        int secondCount = 0;

        while (!isSorted()) {
            for (int i = 0; i < user.getRecomendations().size() - 1; i++) {
                for (int j = 0; j < user.getRecomendations().get(i).getGenre().length - 1; j++) {

                    if (Arrays.stream(user.getGenerePreferences()).anyMatch(user.getRecomendations().get(i).getGenre()[j]::equals)) {
                        firstCount++;
                    }

                }

                for (int k = 0; k < user.getRecomendations().get(i + 1).getGenre().length - 1; k++) {
                    if (Arrays.stream(user.getGenerePreferences()).anyMatch(user.getRecomendations().get(i + 1).getGenre()[k]::equals)) {
                        secondCount++;
                    }
                }

                if (firstCount > secondCount) {
                    user.swapRecomendations(i + 1, i);
                }

                System.out.println(user.getRecomendations().get(i));

                firstCount = 0;
                secondCount = 0;

            }
        }
    }

    private boolean isSorted(){

        int firstCount = 0;
        int secondCount = 0;

        if(user.getRecomendations().size() < 2){
            return true;
        }

        for (int i = 0; i < user.getRecomendations().size() - 1; i++) {
            for (int j = 0; j < user.getRecomendations().get(i).getGenre().length - 1; j++) {

                if (Arrays.stream(user.getGenerePreferences()).anyMatch(user.getRecomendations().get(i).getGenre()[j]::equals)) {
                    firstCount++;
                }

            }

            for (int k = 0; k < user.getRecomendations().get(i + 1).getGenre().length - 1; k++) {
                if (Arrays.stream(user.getGenerePreferences()).anyMatch(user.getRecomendations().get(i + 1).getGenre()[k]::equals)) {
                    secondCount++;
                }
            }

            if (firstCount < secondCount) {
                return false;
            }

            firstCount = 0;
            secondCount = 0;

        }

        return true;
    }

    public User getUser() {
        return user;
    }

}
