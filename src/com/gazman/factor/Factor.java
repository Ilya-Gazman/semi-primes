package com.gazman.factor;

import com.gazman.math.SqrRoot;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by Ilya Gazman on 1/11/2016.
 */
public class Factor extends BaseFactor {

    private BigInteger zero = BigInteger.ZERO;
    private BigInteger one = BigInteger.ONE;
    private BigInteger two = BigInteger.valueOf(2);

    public void factor(BigInteger input) {
        BigInteger root = SqrRoot.bigIntSqRootFloor(input);
        BigInteger m1 = two, m2, m0;
        BigInteger delta, delta0;
        BigInteger counter = zero;
        BigInteger value;
        BigInteger extra;


        m1 = input.mod(root);
        m2 = input.mod(root.add(one));

        extra = m2.subtract(m1);

        while (!m1.equals(zero)) {
//        while (counter.compareTo(root) < 0){
            BigInteger i = root.add(counter);
            m0 = input.mod(i.subtract(one));
            m1 = input.mod(i);
            m2 = input.mod(i.add(one));

            delta = m2.subtract(m1);

            if (m1.compareTo(m2) > 0) {
                value = m1.subtract(m2).add(counter);
                delta0 = m1.subtract(m0);
                log(counter, m1, delta0.add(one), "#######", value);
            } else {
                BigInteger magic = counter.multiply(two).subtract(delta).add(extra).add(root);
                BigInteger magic2 = m1.add(counter).subtract(magic);
                log(i, m1, delta, calculateX(root, counter, m1, delta));
            }


            counter = counter.add(one);
        }


    }

    private BigDecimal calculateX(BigInteger r, BigInteger i, BigInteger m, BigInteger d) {
        BigInteger determinant = two.subtract(d).pow(2).subtract(fore.multiply(m.subtract(i.add(r))));
        return new BigDecimal(two.subtract(d)).add(SqrRoot.bigDecimalSqRootFloor(determinant)).divide(twoDecimal);
    }
}
