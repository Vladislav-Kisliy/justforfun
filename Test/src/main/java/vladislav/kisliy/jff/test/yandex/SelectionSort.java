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
 * Searches min value and put this value on top.
 * @author Vladislav Kislyi <vladislav.kisliy@gmail.com>
 * @param <T>
 */
public class SelectionSort<T extends Comparable> extends AbstractSorter<T> {

    @Override
    public T[] sort(T[] input) {
        if (input.length > 0) {
            int insertPosition = 0;
            int minPosition = insertPosition;
            while (insertPosition < input.length) {
                for (int i = insertPosition; i < input.length; i++) {
                    if (more(input[minPosition], input[i])) {
                        minPosition = i;
                    }
                }
                swap(input, minPosition, insertPosition);
                insertPosition++;
                minPosition = insertPosition;
            }

        }
        return input;
    }
}
