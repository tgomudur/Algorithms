package HashMap;

/**
 * Created by incyphae10 on 12/23/16.
 * Problem description : https://leetcode.com/problems/bulls-and-cows/
 */
class BullsAndCowsSolution {
    // Two pass, two arrays
    public String getHint2(String secret, String guess) {
        int[] secretArr = new int[10];
        int[] guessArr = new int[10];

        char c;
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < secret.length(); i++){
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
            else{
                guessArr[guess.charAt(i) - '0']++;
                secretArr[secret.charAt(i) - '0']++;
            }
        }

        for (int i = 0; i < secretArr.length; i++){
            cows += Math.min(secretArr[i], guessArr[i]);
        }
        return bulls + "A" + cows + "B";
    }

    // One pass. Single array
    public String getHint(String secret, String guess) {
        public String getHint(String secret, String guess) {
            int[] countArray = new int[10];
            char c;
            int bulls = 0;
            int cows = 0;
            for (int i = 0; i < secret.length(); i++){
                if (secret.charAt(i) == guess.charAt(i)) bulls++;
                else{
                    if (countArray[guess.charAt(i) - '0'] > 0) cows++;
                    if (countArray[secret.charAt(i) - '0'] < 0) cows++;
                    countArray[guess.charAt(i) - '0']--;
                    countArray[secret.charAt(i) - '0']++;
                }
            }
            return bulls + "A" + cows + "B";
        }
    }
}
public class BullsAndCows {
    BullsAndCowsSolution s = new BullsAndCowsSolution();
    System.out.println(s.getHint("1234", "0111"));
}
