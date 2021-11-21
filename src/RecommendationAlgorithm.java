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


        //Finds all shows that have at least one common genre with the user
        findCommonGenres();

        //Filters the shows so the user only gets the ones that have the most  common genres
        filterShows(user.getGenerePreferences().length);

        //Sorts the list of recomendations by the score using a selection sort
        for (int i = 0; i < user.getRecomendations().size() - 1; i++) {

            int min_idx = i;

            for (int j = i + 1; j < user.getRecomendations().size(); j++)
                if (user.getRecomendations().get(j).getScore() > user.getRecomendations().get(min_idx).getScore())
                    min_idx = j;


            AnimeShow temp = user.getRecomendations().get(min_idx);
            user.getRecomendations().set(min_idx, user.getRecomendations().get(i));
            user.getRecomendations().set(i, temp);
        }

        //Cut the list to the max number of recomendations
        if(user.getRecomendations().size() > user.getMaxRecomendations()) {
            ArrayList<AnimeShow> temp = new ArrayList<>();
            for (int i = 0; i < user.getMaxRecomendations(); i++) {
                temp.add(user.getRecomendations().get(i));
            }
            user.setRecomendations(temp);
        }

    }

    private void findCommonGenres() {

        for (AnimeShow anime : animes) {

            for (String genre : anime.getGenre()) {

                if(Arrays.stream(user.getGenerePreferences()).anyMatch(genre::equals)) {
                    anime.setNumberInCommon(anime.getNumberInCommon() + 1);
                }

                if(Arrays.stream(user.getGenerePreferences()).anyMatch(genre::equals) && !user.getRecomendations().contains(anime)) {
                    user.addRecomendation(anime);
                }

            }

        }

    }

    private void filterShows(int neededCommonGenres){

        ArrayList<AnimeShow> toKeep = new ArrayList<>();

        for (AnimeShow anime : user.getRecomendations()) {
            if (anime.getNumberInCommon() >= neededCommonGenres) {
                toKeep.add(anime);
            }
        }

        if(neededCommonGenres == 1){
            user.setRecomendations(toKeep);
        }else if(toKeep.size() < user.getMaxRecomendations()) {
            filterShows(neededCommonGenres - 1);
        }else{
            user.setRecomendations(toKeep);
        }

    }


    public User getUser() {
        return user;
    }

}
