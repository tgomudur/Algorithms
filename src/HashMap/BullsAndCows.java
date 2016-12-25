package HashMap;

/**
 * Created by incyphae10 on 12/23/16.
 * Problem description : https://leetcode.com/problems/bulls-and-cows/
 */
class BullsAndCowsSolution {

    public String getHint(String secret, String guess) {
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
}
public class BullsAndCows {
}
