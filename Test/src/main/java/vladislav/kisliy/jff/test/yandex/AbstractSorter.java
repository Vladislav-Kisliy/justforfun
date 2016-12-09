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

import java.util.Random;

/**
 *
 * @author Vladislav Kislyi <vladislav.kisliy@gmail.com>
 */
public abstract class AbstractSorter implements Sorter {
    /**
     * Exchanges 2 items in the array. srcPos -> dstPos
     * @param input
     * @param srcPos
     * @param dstPos 
     */
    public static void swap(int[] input, int srcPos, int dstPos) {
        if (dstPos != srcPos) {
            int accum = input[dstPos];
            input[dstPos] = input[srcPos];
            input[srcPos] = accum;
            
        }
    }
    
    public static int[] shuffleArray(int[] inputArray) {
        int[] result = new int[inputArray.length];
        System.arraycopy(inputArray, 0, result, 0, inputArray.length);
        int index;
        Random random = new Random();
        for (int i = result.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            if (index != i) {
                swap(result, i, index);
            }
        }
        return result;
    }
}
