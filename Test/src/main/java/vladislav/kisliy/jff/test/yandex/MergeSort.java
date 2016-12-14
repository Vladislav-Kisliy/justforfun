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
public class MergeSort extends AbstractSorter {

    // stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
    private static void merge(int[] mainArray, int[] tempArray, int start, int middle, int end) {
        // copy to aux[]
        System.arraycopy(mainArray, start, tempArray, start, end - start + 1);

        // merge back to a[]
        int i = start, j = middle + 1;
        for (int k = start; k <= end; k++) {
            if (i > middle) {
                mainArray[k] = tempArray[j++];
            } else if (j > end) {
                mainArray[k] = tempArray[i++];
            } else if (tempArray[j] < tempArray[i]) {
                mainArray[k] = tempArray[j++];
            } else {
                mainArray[k] = tempArray[i++];
            }
        }
    }

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private void sort(int[] mainArray, int[] tempArray, int start, int end) {
        if (end <= start) {
            return;
        }
        int mid = start + (end - start) / 2;
        sort(mainArray, tempArray, start, mid);
        sort(mainArray, tempArray, mid + 1, end);
        merge(mainArray, tempArray, start, mid, end);
    }

    @Override
    public int[] sort(int[] input) {
        int[] aux = new int[input.length];
        sort(input, aux, 0, input.length - 1);
        return input;
    }

}
