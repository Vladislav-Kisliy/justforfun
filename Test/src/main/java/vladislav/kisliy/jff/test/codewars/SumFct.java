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

/**
 *
 * @author vlad
 */
public class SumFct {
    
    private static BigInteger FOUR = BigInteger.valueOf(4);
    private static BigInteger THREE = BigInteger.valueOf(3);
    
    public static BigInteger perimeter(BigInteger n) {
        // (F(n+3) -1) * 4
        BigInteger result = (fib(n.add(THREE)).subtract(BigInteger.ONE)).multiply(FOUR);
        return result;
    }
    
    private static BigInteger fib(BigInteger n) {
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
    
}
