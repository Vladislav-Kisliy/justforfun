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

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Vladislav Kislyi <vladislav.kisliy@gmail.com>
 * @param <T>
 */
public abstract class AbstractSorter<T extends Comparable> implements Sorter<T> {

    public void swap(final T[] input, int srcPos, int dstPos) {
        if (dstPos != srcPos) {
            T accum = input[dstPos];
            input[dstPos] = input[srcPos];
            input[srcPos] = accum;

        }
    }

    public T[] shuffleArray(final T[] inputArray) {
        //        E[] arr = (E[])new Object[INITIAL_ARRAY_LENGTH];
//        T[] result = (T[]) new Comparable[inputArray.length];
//        System.arraycopy(inputArray, 0, result, 0, inputArray.length);
        T[] result = Arrays.copyOf(inputArray, inputArray.length);

          // Variant 2
//        final T t = inputArray[0];
//        T[] result = (T[]) Array.newInstance(t.getClass(), inputArray.length);
//        System.arraycopy(inputArray, 0, result, 0, inputArray.length);
        
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

    public boolean more(final T x, final T y) {
        return (x.compareTo(y) > 0);
    }

//    public Integer[] shuffleArray(final Integer[] inputArray) {
////        E[] arr = (E[])new Object[INITIAL_ARRAY_LENGTH];
//        Integer[] result = new Integer[inputArray.length];
//        System.arraycopy(inputArray, 0, result, 0, inputArray.length);
//        int index;
//        Random random = new Random();
//        for (int i = result.length - 1; i > 0; i--) {
//            index = random.nextInt(i + 1);
//            if (index != i) {
//                Integer accum = result[index];
//            result[index] = result[i];
//            result[i] = accum;
////                swap(result, i, index);
//            }
//        }
//        return result;
//    }
}
