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
import java.util.Arrays;

/**
 *
 * @author vlad
 */
public class ProdFib {

    private static final BigInteger[] FIBONACCI_NUMBERS = new BigInteger[50];

    static {
        FIBONACCI_NUMBERS[0] = BigInteger.ZERO;
        FIBONACCI_NUMBERS[1] = BigInteger.ONE;
        for (int i = 1; i < FIBONACCI_NUMBERS.length - 1; i++) {
            FIBONACCI_NUMBERS[i + 1] = FIBONACCI_NUMBERS[i].add(FIBONACCI_NUMBERS[i - 1]);
        }
    }

    private static final double SQUARE_FIVE = 2.236;
    private static final double GOLDER_RATIO = 1.618;

    public static long[] productFib(long prod) {
        long[] result = new long[3];
        double position = Math.log(Math.pow(prod, 0.5) * SQUARE_FIVE) / Math.log(GOLDER_RATIO);
        if (position > FIBONACCI_NUMBERS.length) {
            throw new IllegalArgumentException("Too big value");
        }
        int secondIndex = (int) Math.round(position);
        int firstIndex = secondIndex - 1;
        if (FIBONACCI_NUMBERS[firstIndex].multiply(FIBONACCI_NUMBERS[secondIndex]).equals(BigInteger.valueOf(prod))) {
            result[2] = 1;
        } else {
            firstIndex++;
            secondIndex++;
            result[2] = 0;
        }
        result[0] = FIBONACCI_NUMBERS[firstIndex].longValue();
        result[1] = FIBONACCI_NUMBERS[secondIndex].longValue();
        return result;
    }
    
//    public static long[] productFib(long prod) {
//    long a = 0L;
//    long b = 1L;
//    while (a * b < prod) {
//      long tmp = a;
//      a = b;
//      b = tmp + b;
//    }
//    return new long[] { a, b, a * b == prod ? 1 : 0 };
//   }
}
