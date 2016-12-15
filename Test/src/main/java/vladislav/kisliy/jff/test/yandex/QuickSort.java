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

import java.util.Arrays;

/**
 *
 * @author Vladislav Kislyi <vladislav.kisliy@gmail.com>
 * @param <T>
 */
public class QuickSort<T extends Integer> extends AbstractSorter<T> {

    @Override
    public Integer[] sort(Integer[] input) {
        quickSort(input, 0, input.length - 1);
        return input;
    }

    private void quickSort(Integer[] array, int left, int right) {
//        System.out.println("------------------------");
//        System.out.println("Start position. array =" + Arrays.toString(arr) + ", left =" + left + ", right =" + right);
        int index = partition(array, left, right);
        if (left < index - 1) {
            quickSort(array, left, index - 1);
        }
        if (index < right) {
            quickSort(array, index, right);
        }
    }

    private int partition(Integer[] arr, int left, int right) {
        int i = left, j = right;
        int tmp;
        int pivot;
        if ((left + 1) == right) {
            pivot = arr[(left + right) / 2];
        } else {
            pivot = (arr[left] + arr[right] + arr[(left + right) / 2]) / 3;
        }

//        System.out.println("array =" + Arrays.toString(arr) + ", left =" + left
//                + ", right =" + right + ", pivot =" + pivot);
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }
//            System.out.println("before swap i=" + i + ", j=" + j);
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
//        System.out.println("End. return i="+i+", array ="+Arrays.toString(arr));
//        System.out.println("------------------------");
        return i;
    }
}
