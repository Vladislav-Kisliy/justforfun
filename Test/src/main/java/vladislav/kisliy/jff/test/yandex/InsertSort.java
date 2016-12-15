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
 * @param <T>
 */
public class InsertSort<T extends Comparable> extends AbstractSorter<T> {

    @Override
    public T[] sort(T[] input) {
        if (input.length > 0) {
            for (int i = 0; i < input.length; i++) {
                for (int j = i; j > 0; j--) {
                    if (more(input[j - 1], input[j])) {
                        swap(input, j, j - 1);
                    } else {
                        break;
                    }
                }
            }
        }
        return input;
    }
}
