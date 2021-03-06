package HashMap;

/**
 * Created by tharun on 1/10/17.
 * Problem description: https://leetcode.com/problems/fraction-to-recurring-decimal/
 */
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

class RecurringDecimalSolution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) return "";

        StringBuilder sb = new StringBuilder();
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0))
            sb.append('-');

        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);
        int r;
        sb.append(String.valueOf(n/d));

        if (n % d == 0) return sb.toString();

        sb.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        for (long remainder = n % d; remainder > 0; remainder=remainder%d) {
            if (map.containsKey(remainder) && map.get(remainder) > 0) {
                sb.insert(map.get(remainder), "(");
                sb.append(")");
                break;
            }
            map.put(remainder, sb.length());
            remainder = remainder*10;
            sb.append(String.valueOf(remainder/d));
        }
        return sb.toString();
    }
}

public class RecurringDecimal {
    @Test
    public void testFractionToDecimal() {
        RecurringDecimalSolution s = new RecurringDecimalSolution();
        assertEquals("0.(012)", s.fractionToDecimal(4, 333));
        assertEquals("0.0000000004656612873077392578125", s.fractionToDecimal(-1, -2147483648));
    }
}
