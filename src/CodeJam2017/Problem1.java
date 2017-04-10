package CodeJam2017;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by tharun on 4/7/17.
 *
 */
public class Problem1 {
    public static void flipBits(int[] pancakes, int startIndex, int k) {
        for (int i = startIndex; i < startIndex + k && i < pancakes.length; i++) {
            pancakes[i] = (pancakes[i] == 1)? 0 : 1;
        }
    }

    public static boolean checkPancakes(int[] pancakes) {
        for (int i = 0; i < pancakes.length; i++) {
            if (pancakes[i] == 0)
                return false;
        }
        return true;

    }
    public static String pancakeSort(String pancakesStr, int k) {
        int i = 0;
        int[] pancakes = new int[pancakesStr.length()];
        for (char ch : pancakesStr.toCharArray()) {
            pancakes[i++] = (ch == '+')? 1 : 0;
        }

        i = 0;
        int count = 0;
        while (i + k <= pancakes.length ) {
            if (pancakes[i] == 0) {
                flipBits(pancakes, i, k);
                count++;
            }
            i++;
        }

        return (checkPancakes(pancakes))? String.valueOf(count) : "IMPOSSIBLE";

    }
    public static void main(String[] args) {
        try {
            File file = new File("data/CodeJam2017/Problem1/Input/A-large.in");

            Scanner sc = new Scanner(file);
            int n = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            int caseNum = 1;
            int k;
            String inputStr;
            while (caseNum <= n) {
                inputStr = sc.next();
                k = sc.nextInt();
                sb.append("Case #" + caseNum + ": " +pancakeSort(inputStr, k) + "\n");
                caseNum++;
            }
            PrintWriter writer = new PrintWriter("data/CodeJam2017/Problem1/Output/A-large.out", "UTF-8");
            writer.write(sb.toString());
            writer.close();
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
