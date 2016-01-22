package com.gazman.factor;

import com.gazman.math.SqrRoot;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by Ilya Gazman on 1/11/2016.
 */
public class Factor2 extends BaseFactor {

    public void factor(BigInteger input) {
        BigInteger r = SqrRoot.bigIntSqRootFloor(input);
        BigInteger i = two;
        BigInteger m = input.mod(i.add(r));
        BigInteger d = input.mod(i.add(r).add(one)).subtract(m);

        while (true) {
            BigDecimal xDecimal = calculateX(r, i, m, d);
            BigInteger x = xDecimal.toBigInteger();
            if (new BigDecimal(x).equals(xDecimal)) {
                log("Found it:", i.add(r.add(x)));
                break;
            }

            x = x.add(one);

            i = i.add(x);
            m = d.subtract(two).multiply(x).add(x.multiply(x.add(one))).add(m).subtract(i.add(r));
            d = d.add(two.multiply(x)).subtract(one);

            log(x, i, m, d);
        }
    }

    private BigDecimal calculateX(BigInteger r, BigInteger i, BigInteger m, BigInteger d) {
        BigInteger determinant = two.subtract(d).pow(2).subtract(fore.multiply(m.subtract(i.add(r))));
        return new BigDecimal(two.subtract(d)).add(SqrRoot.bigDecimalSqRootFloor(determinant)).divide(twoDecimal);
    }
}
