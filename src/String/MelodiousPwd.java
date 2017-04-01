package String;

/**
 * Created by tharun on 3/20/17.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class MelodiousPwd {
    public static void generateAllPwds(int n) {
        char[] consonants = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm',
                'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z'};
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        ArrayList<String> vowelStartStr = new ArrayList<>();
        ArrayList<String> constStartStr = new ArrayList<>();
        ArrayList<String> tmp = new ArrayList<>();

        vowelStartStr.add("");
        constStartStr.add("");
        for (int k = 0; k < n; k++) {
            tmp.clear();
            for (int i = 0; i < consonants.length; i++) {
                for (int j = 0; j < vowelStartStr.size(); j++) {
                    String newStr = vowelStartStr.get(j) + consonants[i];
                    if (newStr.length() == n) {
                        System.out.println(newStr);
                    }
                    tmp.add(newStr);
                }
            }
            vowelStartStr.clear();
            vowelStartStr.addAll(tmp);

            tmp.clear();
            for (int i = 0; i < vowels.length; i++) {
                for (int j = 0; j < constStartStr.size(); j++) {
                    String newStr = constStartStr.get(j) + vowels[i];
                    if (newStr.length() == n) {
                        System.out.println(newStr);
                    }
                    tmp.add(newStr);
                }
            }
            constStartStr.clear();
            constStartStr.addAll(tmp);

            ArrayList<String> tmp1 = new ArrayList<>(vowelStartStr);
            vowelStartStr.clear();
            vowelStartStr.addAll(constStartStr);
            constStartStr.clear();
            constStartStr.addAll(tmp1);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        generateAllPwds(n);
    }
}
