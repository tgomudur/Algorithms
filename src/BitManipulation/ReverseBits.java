package BitManipulation;

/**
 * Reverse Bits
 * https://leetcode.com/problems/reverse-bits/#/description
 */
public class ReverseBits {
    public int reverseBitsEfficient(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            if ((n & 1) == 1) result++;
            n >>= 1;
        }
        return result;
    }

    public int reversBitsNaive(int n) {
        int result = 0, startBit, endBit;
        //Assume 32 bit integer
        for (int i = 0; i < 16; i++) {
            startBit = (n >> (31 - i)) & 1;
            endBit = (n >> i) & 1;
            result = result & ((startBit << i) | (endBit << (31 - i)));
        }
        return result;
    }
}
