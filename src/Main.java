import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {

        ArrayList<AnimeShow> animeShows = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get("D:\\java\\Anime_Recs\\animes.csv"))) {

            // read the file line by line
            String line = "";

            for (int i = 0; (line = br.readLine()) != null; i++) {
                if(i != 0) {
                    animeShows.add(generateAnimeShow(line.split(",")));
                    //System.out.println(i + ": "+ animeShows.get(i - 1).toString());
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }


        RecommendationAlgorithm recommendationAlgorithm = new RecommendationAlgorithm(new User(new String[]{"Magic"}, User.Length.SHORT, 10), animeShows);

        recommendationAlgorithm.getRecommendations();

        recommendationAlgorithm.getUser().printRecomendations();


    }


    public static AnimeShow generateAnimeShow(String[] line) {

        if (line[4].equals("Unknown"))
            line[4] = "0";

        if(line[2].equals(""))
            line[2] = "None";

        if(line[5].equals(""))
            line[5] = "0";

        if(line[6].equals(""))
            line[6] = "0";

        return new AnimeShow(line[1], Integer.parseInt(line[6]), Float.parseFloat(line[5]), Integer.parseInt(line[4]), line[2].substring(0, line[2].length() - 1).split("\\|"));

    }

}
