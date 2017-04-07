package CodeJam2016;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <a href=https://code.google.com/codejam/contest/6254486/dashboard> Counting Sheep</a>
 * <p>Bleatrix Trotter the sheep has devised a strategy that helps her fall asleep faster. First, she picks a number N. Then she starts naming N, 2 × N, 3 × N, and so on. Whenever she names a number, she thinks about all of the digits in that number. She keeps track of which digits (0, 1, 2, 3, 4, 5, 6, 7, 8, and 9) she has seen at least once so far as part of any number she has named. Once she has seen each of the ten digits at least once, she will fall asleep.
 * Bleatrix must start with N and must always name (i + 1) × N directly after i × N. For example, suppose that Bleatrix picks N = 1692. She would count as follows:
 * N = 1692. Now she has seen the digits 1, 2, 6, and 9.
 * 2N = 3384. Now she has seen the digits 1, 2, 3, 4, 6, 8, and 9.
 * 3N = 5076. Now she has seen all ten digits, and falls asleep.
 * What is the last number that she will name before falling asleep? If she will count forever, print INSOMNIA instead.
 * Input
 * The first line of the input gives the number of test cases, T. T test cases follow. Each consists of one line with a single integer N, the number Bleatrix has chosen.
 * Output
 * For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the last number that Bleatrix will name before falling asleep, according to the rules described in the statement</p>
 */

public class CountingSheep {
    public static List<Integer> getDigits(int num) {
        int n = num;
        List<Integer> result = new ArrayList<>();

        while (n > 0) {
            result.add(n%10);
            n = n / 10;
        }
        return result;
    }

    public static String countSheep(int n) {
        if (n == 0)
            return "INSOMNIA";
        int num = n;
        boolean[] digitsPresent = new boolean[10];
        boolean flag = false;
        int i = 0, factor = 1;
        int count = 10;
        while (true) {
            num = factor*n;
            for (int digit : getDigits(num)) {
                digitsPresent[digit] = true;
            }
            for (i = 0; i < 10; i++) {
                if (!digitsPresent[i])
                    break;
                if (i == 9)
                    flag = true;
            }
            if (flag)
                return String.valueOf(num);
            factor++;
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("data/CodeJam2016/CountingSheep/Input/A-large-practice.in");

            Scanner sc = new Scanner(file);
            int n = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            int caseNum = 1;
            int startNum;
            while (caseNum <= n) {
                startNum = sc.nextInt();
                sb.append("Case #"+ caseNum +": " + countSheep(startNum) + "\n");
                caseNum++;
            }
            PrintWriter writer = new PrintWriter("data/CodeJam2016/CountingSheep/Output/A-large-practiceOutput.txt", "UTF-8");
            writer.write(sb.toString());
            writer.close();
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
