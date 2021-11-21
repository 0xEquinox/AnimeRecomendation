import java.util.ArrayList;

public class User {

    private String[] generePreferences;
    private int maxRecomendations;
    private ArrayList<AnimeShow> recomendations = new ArrayList<AnimeShow>();

    public User(String[] generePreferences, int maxRecomendations) {
        this.generePreferences = generePreferences;
        this.maxRecomendations = maxRecomendations;
    }

    public String[] getGenerePreferences() {
        return generePreferences;
    }

    public int getMaxRecomendations() {
        return maxRecomendations;
    }

    public ArrayList<AnimeShow> getRecomendations() {
        return recomendations;
    }

    public void addRecomendation(AnimeShow recomendation) {
        recomendations.add(recomendation);
    }

    public void removeRecomendation(AnimeShow recomendation) {
        recomendations.remove(recomendation);
    }

    public void setRecomendations(ArrayList<AnimeShow> newList) {
        recomendations = newList;
    }

    public void printRecomendations() {
        for (AnimeShow recomendation : recomendations) {
            System.out.println(recomendation.toString());
        }
    }
}
