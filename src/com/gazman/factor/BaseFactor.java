package com.gazman.factor;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by Ilya Gazman on 1/11/2016.
 */
public class BaseFactor {

    protected BigInteger zero = BigInteger.ZERO;
    protected BigInteger one = BigInteger.ONE;
    protected BigInteger two = BigInteger.valueOf(2);
    protected BigDecimal twoDecimal = BigDecimal.valueOf(2);
    protected BigInteger fore = BigInteger.valueOf(4);

    private String emptyChar = (new char[1])[0] + "";

    protected void log(Object... params) {
        for (Object param : params) {
            if (param instanceof Number) {
                printNumber(param);
            }
            else{
                System.out.print(param + " ");
            }
        }
        System.out.println();
    }

    private void printNumber(Object value) {
        int minLength = 5;
        String out = value.toString() + " ";
        if (out.length() < minLength) {
            out = out + new String(new char[minLength - out.length()]).replaceAll(emptyChar, " ");
        }
        System.out.print(out);
    }
}
