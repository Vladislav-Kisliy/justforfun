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
public class TotalIncreasingOrDecreasingNumbers {

    public static BigInteger totalIncDec(int x) {
        final long[][] incrementCollector = new long[10][x + 1];
        final long[][] decrementCollector = new long[10][x + 1];
        long sum = 1;
        for (int i = 1; i <= x; i++) {
            sum += calcIncrement(1, i, incrementCollector) + calcDecrement(9, i, decrementCollector) - 10;
        }
        return BigInteger.valueOf(sum);
    }
    
    private static long calcIncrement(int leftDigit, int amountDigits,
            long[][] incrementCollector) {
        if (incrementCollector[leftDigit][amountDigits] == 0) {
            if (amountDigits == 1) {
                incrementCollector[leftDigit][amountDigits] = 10 - leftDigit;
            } else {
                for (int i = leftDigit; i < 10; i++) {
                    incrementCollector[leftDigit][amountDigits] += calcIncrement(i, amountDigits - 1, incrementCollector);
                }
            }
        }
        return incrementCollector[leftDigit][amountDigits];
    }

    private static long calcDecrement(int leftDigit, int amountDigits,
            long[][] decrementCollector) {
        if (decrementCollector[leftDigit][amountDigits] == 0) {
            if (amountDigits == 1) {
                decrementCollector[leftDigit][amountDigits] = leftDigit + 1;
            } else {
                for (int i = leftDigit; i >= 0; i--) {
                    decrementCollector[leftDigit][amountDigits] += calcDecrement(i, amountDigits - 1, decrementCollector);
                }
            }
        }
        return decrementCollector[leftDigit][amountDigits];
    }

    public static BigInteger countNonBouncyNumbers(final int k) {
        if (k > 1000) {
            throw new IllegalArgumentException("K must be less than or equal to 1000");
        }

        long count = 0;
        BigInteger bigCount = BigInteger.ZERO;

        final BigInteger bigMaxNumber = BigInteger.TEN.pow(k);
        final long maxNumber = bigMaxNumber.longValue();
        for (long i = 0; i < maxNumber; i++) {
            if (!isBouncy(Long.toString(i).toCharArray())) {
                count++;
            }
        }

        if (maxNumber < Integer.MAX_VALUE) {
            return BigInteger.valueOf(count);
        }

        for (BigInteger i = BigInteger.valueOf(maxNumber); i.compareTo(bigMaxNumber) < 0; i = i.add(BigInteger.ONE)) {
            if (!isBouncy(i.toString().toCharArray())) {
                if (count != Integer.MAX_VALUE) {
                    count++;
                } else {
                    bigCount = bigCount.add(BigInteger.ONE);
                }
            }
        }
        return bigCount.add(BigInteger.valueOf(count));
    }

    public static boolean isBouncy(final char[] number) {
        if (number.length < 3) {
            return false;
        }

        boolean increasing = false;
        boolean decreasing = false;
        boolean equals = false;
        for (int i = 0; i < number.length - 1; i++) {
            increasing |= (number[i] > number[i + 1]);
            decreasing |= (number[i] < number[i + 1]);
            if (increasing && decreasing) {
                return true;
            }
        }
        return false;
    }

//    public static void main(final String argv[]) {
//        final int k = 9;
//        final long startTime = System.currentTimeMillis();
//        System.out.println("Found " + countNonBouncyNumbers(k));
//        final long endTime = System.currentTimeMillis();
//        final long durationMillis = endTime - startTime;
//        System.out.println("Executed k=" + k + " in " + durationMillis + " milliseconds");
//    }
    

//    public static void main(String[] args) {
//        final long start = System.currentTimeMillis();
//        long sum = 0;
//
//        for (int i = 1; i <= NUM_OF_DIGITS; i++) {
//            sum += calcIncrement(1, i) + calcDecrement(9, i) - 10;
//        }
//        System.out.println(sum);
//        System.out.format("%.3f\n", (System.currentTimeMillis() - start) / 1000.0);
//        System.out.println("inc array =" + Arrays.toString(INC_VALUES[1]));
//        System.out.println("dec array =" + Arrays.toString(DEC_VALUES[9]));
//    }
}
