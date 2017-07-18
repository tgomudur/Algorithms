package String;

/**
 * Created by Incyphae on 7/18/2017.
 * https://leetcode.com/problems/zigzag-conversion/#/description
 */
public class ZigZagConversion {
    public String convertZigZag(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        int charIdx = 0, n = s.length();
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }

        while (charIdx < n) {
            // Vertically Down
            for (int rowNum = 0; rowNum < numRows && charIdx < n; rowNum++) {
                sb[rowNum].append(s.charAt(charIdx++));
            }
            // Oblique up
            for (int rowNum = numRows - 2; rowNum > 0 && charIdx < n; rowNum--) {
                sb[rowNum].append(s.charAt(charIdx++));
            }
        }

        for (int i = 1; i < numRows; i++) {
            sb[0].append(sb[i].toString());
        }

        return sb[0].toString();
    }
}
