package CodeJam2017;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by tharun on 4/7/17.
 *
 */
public class Problem1 {
    public static String solveProblem1() {
        return "";
    }

    public static void main(String[] args) {
        try {
            File file = new File("data/CodeJam2016/Problem1/Input/Test.in");

            Scanner sc = new Scanner(file);
            int n = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            int caseNum = 1;
            while (caseNum <= n) {
                // sb.append(solveProblem1() + "\n");
                 caseNum++;
            }
            PrintWriter writer = new PrintWriter("data/CodeJam2016/Problem1/Output/Test.out", "UTF-8");
            writer.write(sb.toString());
            writer.close();
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
