package com.gazman;

import com.gazman.factor.BaseFactor;
import com.gazman.factor.Factor2;

import java.math.BigInteger;
import java.util.Random;

public class Main extends BaseFactor {

    private static Random random = new Random();

    public static void main(String[] args) {
        new Main().init();
    }

    private void init() {
        int length = 20;
        BigInteger a = BigInteger.probablePrime(length, random);
        BigInteger b = BigInteger.probablePrime(length, random);
        a = BigInteger.valueOf(907);
        b = BigInteger.valueOf(733);

        BigInteger input = a.multiply(b);
        log(a, b);
        log(input);
        log("---------");
        log();
        new Factor2().factor(input);
    }
}
