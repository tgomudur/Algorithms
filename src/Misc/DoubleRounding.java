package Misc;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DoubleRounding {
    public static void main(String[] args){
        double toBeTruncated = 1.33;
        double truncatedDouble = BigDecimal.valueOf(toBeTruncated).setScale(4, RoundingMode.HALF_UP).doubleValue();
        System.out.println(truncatedDouble);
    }
}
