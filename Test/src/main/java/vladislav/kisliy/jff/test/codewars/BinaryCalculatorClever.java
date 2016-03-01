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

import java.util.HashMap;

/**
 *
 * @author keeprocking
 */
public class BinaryCalculatorClever {

    interface Operation {

        int perform(int a, int b);
    }

    private final static HashMap<String, Operation> operations = new HashMap<String, Operation>() {
        {
            put("add", (a, b) -> a + b);
            put("subtract", (a, b) -> a - b);
            put("multiply", (a, b) -> a * b);
        }
    };

    public static String calculate(final String n1, final String n2, final String o) {
        int i1 = Integer.parseInt(n1, 2);
        int i2 = Integer.parseInt(n2, 2);
        int result = operations.get(o).perform(i1, i2);
        return Integer.toBinaryString(result);
    }

}
