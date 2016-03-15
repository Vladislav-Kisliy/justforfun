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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mixing {

    private static final char[] LOWER_CHARS = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static String mix(String s1, String s2) {
        if (s1.equals(s2)) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        Map<Character, Integer> s1Index = createCharIndex(s1);
        Map<Character, Integer> s2Index = createCharIndex(s2);

        List<String> resultList = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : s1Index.entrySet()) {
            Character key1Index = entry.getKey();
            Integer value1Index = entry.getValue();
            result.setLength(0);
            int maxValue = value1Index;
            Integer value2Index = s2Index.get(key1Index);
            if (value2Index != null) {
                if (value2Index > value1Index) {
                    result.append("2:");
                    maxValue = value2Index;
                } else if (value2Index.equals(value1Index)) {
                    result.append("=:");
                } else {
                    result.append("1:");
                }
            }

            if (maxValue > 1) {
                char[] line = new char[maxValue];
                Arrays.fill(line, key1Index);
                result.append(line);
                resultList.add(result.toString());
            }

        }
        Collections.sort(resultList, new SpecialComparator());

        result.setLength(0);
        resultList.stream().map((string) -> {
            return string;
        }).map((string) -> {
            result.append(string);
            return string;
        }).forEach((_item) -> {
            result.append("/");
        });
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    private static Map<Character, Integer> createCharIndex(String line) {
        Map<Character, Integer> result = new HashMap<>();
        for (char c : LOWER_CHARS) {
            result.put(c, 0);
        }
        for (char c : line.toCharArray()) {
            if (result.containsKey(c)) {
                result.replace(c, result.get(c) + 1);
            }
        }
        return result;
    }

    private static class SpecialComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            int result = o2.length() - o1.length();
            if (result == 0) {
                result = (o1.charAt(0) - o2.charAt(0));

                if (result == 0) {
                    result = (o1.charAt(2) - o2.charAt(2));
                }
            }

            return result;
        }
    }
}
