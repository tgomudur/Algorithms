package Misc;

/**
 * Created by tharun on 4/2/17.
 * Find the sum of two numbers without using + or - operator.
 */
public class SumofNumbers {
    public int getSum(int a, int b) {
        return (b == 0)? a : getSum(a^b, (a&b)<<1);
    }
}
