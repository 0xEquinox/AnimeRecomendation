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
        sortRecomendations(user.getRecomendations().size());

        for(AnimeShow anime : user.getRecomendations()) {
            System.out.println(anime.toString());
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

    // A utility function to get maximum value in arr[]
    private int getMax(int n)
    {
        int mx = user.getRecomendations().get(0).getNumberInCommon();
        for (int i = 1; i < n; i++)
            if (user.getRecomendations().get(i).getNumberInCommon() > mx)
                mx = user.getRecomendations().get(i).getNumberInCommon();
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    private void countSort(int n, int exp)
    {
        AnimeShow output[] = new AnimeShow[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[ (user.getRecomendations().get(i).getNumberInCommon()/exp)%10 ]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--)
        {
            output[count[ (user.getRecomendations().get(i).getNumberInCommon()/exp)%10 ] - 1] = user.getRecomendations().get(i);
            count[ (user.getRecomendations().get(i).getNumberInCommon()/exp)%10 ]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current digit
        for (i = 0; i < n; i++)
            user.getRecomendations().set(i, output[i]);
    }

    // The main function to that sorts arr[] of size n using
    // Radix Sort
    private void sortRecomendations(int n)
    {
        // Find the maximum number to know number of digits
        int m = getMax(n);

        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(n, exp);

    }

    public User getUser() {
        return user;
    }

}
