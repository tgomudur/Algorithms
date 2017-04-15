package Misc;

/**
 * <p>Reverse digits of an integer. <br/>
 * Example1: x = 123, return 321 <br/>
 * Example2: x = -123, return -321</p>
 * <a href=https://leetcode.com/problems/reverse-integer/#/description>More Info</a>
 */
public class ReverseInteger {
    public int reverse(int x) {
        long reverseNum = 0;
        while (x != 0) {
            reverseNum = reverseNum*10 + x%10;
            x = x/10;
            if (reverseNum > Integer.MAX_VALUE || reverseNum < Integer.MIN_VALUE)
                return 0;
        }
        return (int) reverseNum;
    }
}
