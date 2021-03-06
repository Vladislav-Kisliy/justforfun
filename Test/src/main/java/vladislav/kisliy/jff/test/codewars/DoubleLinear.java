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
public class DoubleLinear {

    private static final int[] ARRAY = new int[10000];

    static {
        ARRAY[0] = 1;
        ARRAY[1] = 3;
        ARRAY[2] = 4;
        ARRAY[3] = 7;
        ARRAY[4] = 9;
        ARRAY[5] = 10;
        ARRAY[6] = 13;
        ARRAY[7] = 15;
        ARRAY[8] = 19;
        ARRAY[9] = 21;
        ARRAY[10] = 22;
        ARRAY[11] = 27;
        int counter = 12;
        for (int i = 27; i < 10000; i++) {
            if ((i - 1) % 2 == 0 || (i - 1 % 3 == 0)) {
                ARRAY[counter] = i;
                counter++;
            }
        }
    }

    public static int dblLinear(int n) {
        return ARRAY[n];
    }

    public static void main(String[] args) {
        System.out.println("50 ="+ARRAY[50]);
    }
}
