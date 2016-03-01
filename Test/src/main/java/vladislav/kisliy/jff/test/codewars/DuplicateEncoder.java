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

import java.util.TreeMap;
import java.util.stream.Collectors;

public class DuplicateEncoder {

    private final static Character UNIQ_BYTE = '(';
    private final static Character DUP_BYTE = ')';
    private final static TreeMap<Character, Character> CHARS_MAP = new TreeMap<>();

    // SithFire decision
    static String encode(String word) {
        return word.toLowerCase()
                .chars()
                .mapToObj(i -> String.valueOf((char) i))
                .map(i -> word.toLowerCase().indexOf(i) == word.toLowerCase().lastIndexOf(i) ? "(" : ")")
                .collect(Collectors.joining());
    }

//    static String encode(String word) {
//        CHARS_MAP.clear();
//        char[] chars = word.toLowerCase().toCharArray();
//        for (char aChar : chars) {
//            if (CHARS_MAP.containsKey(aChar)) {
//                CHARS_MAP.put(aChar, DUP_BYTE);
//            } else {
//                CHARS_MAP.put(aChar, UNIQ_BYTE);
//            }
//        }
//        char[] result = new char[chars.length];
//        for (int i = 0; i < result.length; i++) {
//            result[i] = CHARS_MAP.get(chars[i]);
//        }
//        return String.valueOf(result);
//    }
}
