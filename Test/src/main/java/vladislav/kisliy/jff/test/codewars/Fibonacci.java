/*
 * Copyright (C) 2016 vlad
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package vladislav.kisliy.jff.test.codewars;

import java.math.BigInteger;

public class Fibonacci {

    public static BigInteger fib(BigInteger n) {
        BigInteger calculateN = n;
        boolean changeSign = false;
        if (n.compareTo(BigInteger.ZERO) < 0) {
            calculateN = n.negate();
            changeSign = true;
        }
        // Calculation via matrix form
        BigInteger a = BigInteger.ONE, ta;
        BigInteger b = BigInteger.ONE, tb;
        BigInteger c = BigInteger.ONE;
        BigInteger result = BigInteger.ZERO, tc;
        BigInteger d = BigInteger.ZERO, rd = BigInteger.ONE;
        while (calculateN.compareTo(BigInteger.ZERO) > 0) {
            if ((calculateN.and(BigInteger.ONE).equals(BigInteger.ONE))) {
                tc = result;
                result = result.multiply(a).add(rd.multiply(c));
                rd = tc.multiply(b).add(rd.multiply(d));
            }
            ta = a;
            tb = b;
            tc = c;
            a = a.pow(2).add(b.multiply(c));
            b = ta.multiply(b).add(b.multiply(d));
            c = c.multiply(ta).add(d.multiply(c));
            d = tc.multiply(tb).add(d.pow(2));

            calculateN = calculateN.shiftRight(1);
        }

        if (changeSign) {
            if (n.mod(new BigInteger("2")).equals(BigInteger.ZERO)) {
                result = result.negate();
            }
        }

        return result;
    }

//    final class Matrix2x2 {
//
//        final BigInteger m00, m01, m10, m11;
//
//        Matrix2x2(BigInteger M00, BigInteger M01, BigInteger M10, BigInteger M11) {
//            m00 = M00;
//            m01 = M01;
//            m10 = M10;
//            m11 = M11;
//        }
//
//        Matrix2x2 multiply(Matrix2x2 B) {
//            BigInteger a = m00.multiply(B.m00).add(m01.multiply(B.m10));
//            BigInteger b = m00.multiply(B.m01).add(m01.multiply(B.m11));
//            BigInteger c = m10.multiply(B.m00).add(m11.multiply(B.m10));
//            BigInteger d = m10.multiply(B.m01).add(m11.multiply(B.m11));
//            return new Matrix2x2(a, b, c, d);
//        }
//
//        Matrix2x2 pow(int k) {
//            Matrix2x2 res = new Matrix2x2(BigInteger.ONE, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ONE);
//            Matrix2x2 base = this;
//            for (; k > 0; k >>= 1) {
//                if ((k & 1) == 1) {
//                    res = res.multiply(base);
//                }
//                base = base.multiply(base);
//            }
//            return res;
//        }
//    }
//
//    class Fibonacci {
//
//        public static BigInteger fib(BigInteger bn) {
//            int n = bn.intValue();
//            if (n == 0) {
//                return BigInteger.ZERO;
//            }
//            Matrix2x2 m = new Matrix2x2(BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ZERO);
//            Matrix2x2 p = m.pow(Math.abs(n) - 1);
//            return n < 0 && n % 2 == 0 ? p.m00.negate() : p.m00;
//        }
//    }
    public static int getFibNumb(int n) {
        BigInteger calculateN = BigInteger.valueOf(n);
        // Calculation via matrix form
        BigInteger a = BigInteger.ONE, ta;
        BigInteger b = BigInteger.ONE, tb;
        BigInteger c = BigInteger.ONE;
        BigInteger result = BigInteger.ZERO, tc;
        BigInteger d = BigInteger.ZERO, rd = BigInteger.ONE;
        while (calculateN.compareTo(BigInteger.ZERO) > 0) {
            if ((calculateN.and(BigInteger.ONE).equals(BigInteger.ONE))) {
                tc = result;
                result = result.multiply(a).add(rd.multiply(c));
                rd = tc.multiply(b).add(rd.multiply(d));
            }
            ta = a;
            tb = b;
            tc = c;
            a = a.pow(2).add(b.multiply(c));
            b = ta.multiply(b).add(b.multiply(d));
            c = c.multiply(ta).add(d.multiply(c));
            d = tc.multiply(tb).add(d.pow(2));

            calculateN = calculateN.shiftRight(1);
        }
        return result.divideAndRemainder(BigInteger.TEN)[1].intValue();
    }
}
