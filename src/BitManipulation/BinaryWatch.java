package BitManipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tharun on 4/1/17.
 * https://leetcode.com/problems/binary-watch/#/description
 */

public class BinaryWatch {
    public List<String> readBinaryWatchDFS(int num) {
        List<String> result = new ArrayList<>();
        readBinaryWatchDFSHelper(result, num, 0, 0, 0);
        return result;
    }

    private void readBinaryWatchDFSHelper(List<String> result, int bitsLeft, int startIdx, int hour, int minute) {
        if (hour > 11 || minute > 60)
            return;
        if (bitsLeft == 0) {
            result.add(String.format("%d:%02d", hour, minute));
        }

        for (int i = startIdx; i < 10; i++) {
            if (i < 4)
                readBinaryWatchDFSHelper(result, bitsLeft - 1, i + 1, hour | (1 << i), minute);
            else
                readBinaryWatchDFSHelper(result, bitsLeft - 1, i + 1, hour , minute | (1 << (i - 4)));
        }
    }

    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                int sum = countBits(m) + countBits(h);
                if (sum == num) {
                    result.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return result;
    }

    public int countBits(int num) {
        int count = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num = num >> 1;
        }
        return count;
    }
}
