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

    }

    public User getUser() {
        return user;
    }

}
