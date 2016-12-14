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
 * Classic merge sort algorithm.
 * @author Vladislav Kislyi <vladislav.kisliy@gmail.com>
 */
public class MergeSort extends AbstractSorter {

    // merge mainArray[start .. middle] with mainArray[middle+1 ..end] 
    // using tempArray[start .. end]
    private void merge(int[] mainArray, int[] tempArray, int start, int middle, int end) {
        System.arraycopy(mainArray, start, tempArray, start, end - start + 1);

        // merge back to mainArray[]
        int firstSubarray = start, secondSubarray = middle + 1;
        for (int counter = start; counter <= end; counter++) {
            if (firstSubarray > middle) { // exhausted firstSubarray
                mainArray[counter] = tempArray[secondSubarray++];
            } else if (secondSubarray > end) { // exhausted secondSubarray
                mainArray[counter] = tempArray[firstSubarray++];
            } else if (tempArray[secondSubarray] < tempArray[firstSubarray]) {
                mainArray[counter] = tempArray[secondSubarray++];
            } else {
                mainArray[counter] = tempArray[firstSubarray++];
            }
        }
    }

    // mergesort mainArray[start..end] using temp. array tempArray[start..end]
    private void sort(int[] mainArray, int[] tempArray, int start, int end) {
        if (end <= start) {
            return;
        }
        int middle = start + (end - start) / 2;
        sort(mainArray, tempArray, start, middle);
        sort(mainArray, tempArray, middle + 1, end);
        merge(mainArray, tempArray, start, middle, end);
    }

    @Override
    public int[] sort(int[] input) {
        int[] aux = new int[input.length];
        sort(input, aux, 0, input.length - 1);
        return input;
    }

}
