import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class AnimeShow {


    private String title = "";
    private String[] genre;
    private int popularity = 0;
    private float score = 0;
    private int episodes = 0;


    public AnimeShow(String title, int popularity, float score, int episodes, String[] genre) {

        this.title = title;
        this.popularity = popularity;
        this.score = score;
        this.episodes = episodes;
        this.genre = genre;

    }

    public String getTitle() {
        return title;
    }

    public String[] getGenre() {
        return genre;
    }

    public int getPopularity() {
        return popularity;
    }

    public float getScore() {
        return score;
    }

    public int getEpisodes() {
        return episodes;
    }


    public String toString() {
        return "AnimeShow{" + "title=" + title + ", genre=" + genre + ", popularity=" + popularity + ", score=" + score + ", episodes=" + episodes + '}';
    }



}
