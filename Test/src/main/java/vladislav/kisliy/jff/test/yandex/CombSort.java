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

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Vladislav Kislyi <vladislav.kisliy@gmail.com>
 */
public class CombSort implements Sorter {

    @Override
    public int[] sort(int[] input) {
        float loadFactor = 1.247f;
        Map hashMap = new HashMap();
        int step = input.length;
        boolean sorted = false;
        int accum;
        while (!sorted) {
            sorted = true;
            step /= loadFactor;
            if (step < 1) {
                step = 1;
            }
            for (int i = 0; i < input.length - 1; i++) {
                if ((i + step) < input.length) {
                    if (input[i] > input[i + step]) {
                        accum = input[i];
                        input[i] = input[i + step];
                        input[i + step] = accum;
                        sorted = false;
                    }
                } else {
                    sorted = false;
                }
            }
        }
        return input;
    }
}
