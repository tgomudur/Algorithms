package CodeJam2017;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BathroomStalls {
    public static int getNextStall(String[] stalls) {
        int left = 0;
        int right = stalls.length - 1;

        int maxFreeSpaceCount = Integer.MIN_VALUE;
        int currentFreeSpaceCount = 0;

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i].equals("O")) {
                if (currentFreeSpaceCount > maxFreeSpaceCount) {
                    maxFreeSpaceCount = currentFreeSpaceCount;
                    right = i - 1;
                    left = i - currentFreeSpaceCount;
                }
                currentFreeSpaceCount = 0;
            } else {
                currentFreeSpaceCount++;
            }


        }
        return (int) Math.floor((left + right)/2);
    }

//    public static void fillStalls(String[] stalls) {
//        while (k )
//    }
    public static int[] computePenaltyAt(String[] stalls, int index) {
        int left = index - 1;
        int right = index + 1;
        int n = stalls.length;
        while (left >= 0) {
            if (stalls[left].equals("O")) {
                break;
            } else {
                left--;
            }
        }

        while (right < n) {
            if (stalls[right].equals("O")) {
                break;
            } else {
                right++;
            }
        }

        int Ls = index - left - 1;
        int Rs = right - index - 1;
        return new int[] {Math.max(Ls, Rs), Math.min(Ls, Rs)};
    }

    // Time Complexity: O(nk). Space complexity : O(n).
    // TODO: Cut time complexity to O(n). Needs to be more efficient.
    public static String solveProblem3(int numStalls, int k) {
        String[] stalls = new String[numStalls + 2];
        for (int i = 0; i < stalls.length; i++) {
            if (i == 0 || i == stalls.length - 1)
                stalls[i] = "O";
            else
                stalls[i] = ".";
        }

        int insertIdx = 0;
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int i = 1; i <= k - 1; i++) {
            insertIdx = getNextStall(stalls);
            indexes.add(insertIdx);
            stalls[insertIdx] = "O";
        }
        // Collections.sort(indexes);
        // System.out.println(indexes);
        int[] penalties = computePenaltyAt(stalls, getNextStall(stalls));
        return penalties[0] + " " + penalties[1];
    }

    public static void main(String[] args) {
        try {
            File file = new File("data/CodeJam2017/BathroomStalls/Input/Test.in");

            Scanner sc = new Scanner(file);
            int n = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            int caseNum = 1;
            int numStalls, k;
            while (caseNum <= n) {
                numStalls = sc.nextInt();
                k = sc.nextInt();
                sb.append("Case #" + caseNum + ": " + solveProblem3(numStalls, k) + "\n");
                caseNum++;
            }
            PrintWriter writer = new PrintWriter("data/CodeJam2017/BathroomStalls/Output/Test.out", "UTF-8");
            writer.write(sb.toString());
            writer.close();
            // System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
