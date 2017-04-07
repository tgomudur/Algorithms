package CodeJam2016;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by tharun on 4/7/17.
 * https://code.google.com/codejam/contest/6254486/dashboard#s=p1
 */
public class FlippingPancakes {
    public static int countMinFlips() {
        // TODO: Implement solution
        return 0;
    }

    public static void main(String[] args) {
        try {
            File file = new File("data/CodeJam2016/FlippingPancakes/Input/Test.in");

            Scanner sc = new Scanner(file);
            int n = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            int caseNum = 1;
            while (caseNum <= n) {
                // sb.append(solveProblem1() + "\n");

                caseNum++;
            }
            PrintWriter writer = new PrintWriter("data/CodeJam2016/FlippingPancakes/Output/Test.out", "UTF-8");
            writer.write(sb.toString());
            writer.close();
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
