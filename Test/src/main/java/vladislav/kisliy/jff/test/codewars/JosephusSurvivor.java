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

public class JosephusSurvivor {

    public static int josephusSurvivor(final int people, final int k) {
        int result = people;
        if (k > 1) {
            int len = people;

            int[] index = new int[len];
            int m = k - 1;//start from 0,not 1
            //f(m,i)=(((m%(n-i)+k)%(n-i+1)+k)%(n-i+2)+k...)%n
            for (int i = 0; i < len; i++) {
                index[i] = m % (len - i);
            }
            int j = 1;
            while (j < len) {
                for (int i = 0; i < len - j; i++) {
                    index[i + j] = (index[i + j] + k) % (len - i);
                }
                j++;
            }
            result = index[index.length - 1] + 1;
        }
        return result;
    }

    private static int generateIndexList(int size, int k) {
        int result = size;
        int counter = 1;
        if (k > 1) {
            List<Integer> positionList = new ArrayList<>();
            for (int i = 1; i <= size; i++) {
                positionList.add(i);
            }
            List<Integer> resultList = new ArrayList<>();
            while (positionList.size() > 1) {
                for (Integer index : positionList) {
                    if (counter == k) {
                        resultList.add(index);
                        counter = 0;
                    }
                    counter++;
                }
                positionList.removeAll(resultList);
            }
            result = positionList.get(0);
        }
        return result;
    }

    public static int josephusPermutation(int people, int k) {
        int result = people;
        if (k > 1) {
            int len = people;

            int[] index = new int[len];
            int m = k - 1;//start from 0,not 1
            //f(m,i)=(((m%(n-i)+k)%(n-i+1)+k)%(n-i+2)+k...)%n
            for (int i = 0; i < len; i++) {
                index[i] = m % (len - i);
            }
            int j = 1;
            while (j < len) {
                for (int i = 0; i < len - j; i++) {
                    index[i + j] = (index[i + j] + k) % (len - i);
                }
                j++;
            }
            result = index[index.length - 1] + 1;
        }
        return result;
    }
    
//    public static int josephusSurvivor(final int n, final int k) {
//        int remaining = 0;
//        for (int i = 2; i <= n; i++) {
//            remaining = (remaining + k) % i;
//        }
//
//        return remaining + 1;
//    }

}
