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

import java.util.ArrayList;
import java.util.List;

public class NbInSum {

    public static long[][] decompose(long n) {
        long[][] result = new long[2][];
        long[] powArray;
        long balance = 0l;
        if (n > 3) {
            List<Long> list = new ArrayList<>();
            long accumalator = 0l;
            int logBase = 1;
            long pow;
            while ((balance = Math.round(n - accumalator)) > 1) {
                logBase++;
                pow = logByX(n - accumalator, logBase);
                if (pow > 1) {
                    accumalator += Math.round(Math.pow(logBase, pow));
                    list.add(pow);
                } else {
                    break;
                }
            }
            powArray = list2Array(list);
        } else {
            balance = n;
            powArray = new long[0];
        }
        result[0] = powArray;
        result[1] = new long[]{balance};
        return result;
    }

    public static long logByX(long num, int base) {
        return Math.round(Math.floor(Math.log(num) / Math.log(base)));
    }

    public static long[] list2Array(List<Long> list) {
        long[] result = new long[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
