/*
 * Copyright (C) 2016 Vladislav Kislyi <vladislav.kisliy@gmail.com>
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
package vladislav.kisliy.jff.test.yandex;

/**
 *
 * @author Vladislav Kislyi <vladislav.kisliy@gmail.com>
 */
public class ShellSort extends AbstractSorter {

    @Override
    public int[] sort(int[] input) {
        int length = input.length;

        // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ... 
        int h = 1;
        while (h < length / 3) {
            h = 3 * h + 1;
//            System.out.println("calc h =" + h);
        }

        while (h >= 1) {
            // h-sort the array
//            System.out.println("h =" + h + ", length =" + length);
            for (int i = h; i < length; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (input[j] < input[j - h]) {
//                        System.out.println("swap val =" + input[j] + "[" + j + "] -> [" + (j - h)+"]");
                        swap(input, j, j - h);
                    } 

                }
            }
//            assert isHsorted(a, h); 
            h /= 3;
        }
//        assert isSorted(a);
        return input;
    }

}
