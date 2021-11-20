import java.util.ArrayList;

public class User {

    public enum Length {
        SHORT, MEDIUM, LONG
    }

    private String[] generePreferences;
    private Length lengthPreferences;
    private int maxRecomendations;
    private ArrayList<AnimeShow> recomendations = new ArrayList<AnimeShow>();

    public User(String[] generePreferences, Length lengthPreferences, int maxRecomendations) {
        this.generePreferences = generePreferences;
        this.lengthPreferences = lengthPreferences;
        this.maxRecomendations = maxRecomendations;
    }

    public String[] getGenerePreferences() {
        return generePreferences;
    }

    public Length getLengthPreferences() {
        return lengthPreferences;
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

    public void printRecomendations() {
        for (AnimeShow recomendation : recomendations) {
            System.out.println(recomendation.getTitle());
        }
    }

    public void swapRecomendations(int newRecomendations, int oldRecomendations) {
        AnimeShow tmp = recomendations.get(oldRecomendations);
        recomendations.set(oldRecomendations, recomendations.get(newRecomendations));
        recomendations.set(newRecomendations, tmp);
    }


}
