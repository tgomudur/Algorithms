package CodeJam2017;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Problem2 {
    public static boolean isTidy(long num) {
        long n = num;
        long prevDigit = Integer.MAX_VALUE;
        long currentDigit;
        while (n > 0) {
            currentDigit = n%10;
            if (currentDigit > prevDigit)
                return false;
            prevDigit = currentDigit;
            n = n/10;
        }
        return true;
    }
    public static String solveProblem2(long num) {
        for (long i = num; i >= 0; i--) {
            if (isTidy(i))
                return String.valueOf(i);
        }
        return String.valueOf(0);
    }

    public static String solveProblem2Efficient(String num) {
        if (num.length() == 1)
            return num;
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        int n = num.length();
        int currentNum, nextNum;

        for (int i = 0; i < n - 1; i++) {
            currentNum = Integer.parseInt("" + num.charAt(i));
            nextNum = Integer.parseInt("" + num.charAt(i + 1));
            if (flag) {
                sb.append(9);
                continue;
            }
            if (nextNum <= currentNum) {
                sb.append(currentNum - 1);
                flag = true;
            } else {
                sb.append(currentNum);
            }
        }

        if (flag)
            sb.append(9);
        else
            sb.append(Integer.parseInt("" + num.charAt(n - 1)));


        return (sb.charAt(0) == '0')? sb.substring(1) : sb.toString();
    }

    public static void main(String[] args) {
        try {
            File file = new File("data/CodeJam2017/Problem2/Input/B-large.in");

            Scanner sc = new Scanner(file);
            int n = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            int caseNum = 1;
            long inputNum;
            String input;
            while (caseNum <= n) {
                //inputNum = sc.nextLong();
                input = sc.next();
                sb.append("Case #" + caseNum + ": " +solveProblem2Efficient(input) + "\n");
                caseNum++;
            }
            PrintWriter writer = new PrintWriter("data/CodeJam2017/Problem2/Output/B-large.out", "UTF-8");
            writer.write(sb.toString());
            writer.close();
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
