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

/**
 *
 * @author vlad
 */
public class MinNbDiv {

    private final static int[] PRIME_NUMBERS = new int[]{2, 3, 5, 7, 11, 13, 17, 19,
        23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,
        101, 103};

    public static int findMinNum(int num) {
        int result = num;
        if (num > 2) {
            if (isPrimeNumber(num)) {
                result = 1 << (num - 1);
            } else {
                while (factorization(result) != num) {
                    result++;
                }
            }
        }

        return result;
    }

    private static int factorization(long x) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                count++;
                if (x / i != i) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isPrimeNumber(int num) {
        for (int i : PRIME_NUMBERS) {
            if (i == num) {
                return true;
            }
        }
        return false;
    }
}
