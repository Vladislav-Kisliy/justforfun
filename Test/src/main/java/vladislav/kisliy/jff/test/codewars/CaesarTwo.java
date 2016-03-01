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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CaesarTwo {

    private static final char[] CHAR_ARRAY = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final int RUNNER_AMOUNT = 5;
    private static final StringBuilder resultLine = new StringBuilder();
    private static Map<Character, Character> transformMap;

    public static List<String> encodeStr(String inputLine, int shift) {
        long maxLength = Math.round(Math.ceil((double) (inputLine.length() + 2) / RUNNER_AMOUNT));
        int counter = 2;
        int mailPart = 1;
        char[] chars = inputLine.toCharArray();
        //Header
        resultLine.setLength(0);
        resultLine.append(Character.toLowerCase(chars[0]));
        resultLine.append((char) (Character.toLowerCase(chars[0]) + shift));
        transformMap = generateEncodeDecodeMap(shift, true);
        List<String> result = new ArrayList<>();
        for (char c : chars) {
            transformChar(c);
            counter++;
            if ((counter == maxLength) && (mailPart < RUNNER_AMOUNT)) {
                result.add(resultLine.toString());
                resultLine.setLength(0);
                counter = 0;
                mailPart++;
            }
        }
        if (resultLine.length() > 0) {
            result.add(resultLine.toString());
        }
        return result;
    }

    public static String decode(List<String> s) {
        // Shift calculate
        char[] chars = s.get(0).toCharArray();
        int shift = (char) chars[1] - chars[0];
        resultLine.setLength(0);
        transformMap = generateEncodeDecodeMap(shift, false);
        int lineCounter = 0;
        for (String string : s) {
            chars = string.toCharArray();
            int startPos = 0;
            if (lineCounter == 0) {
                startPos = 2;
            }
            for (int i = startPos; i < chars.length; i++) {
                transformChar(chars[i]);
            }
            lineCounter++;

        }
        return resultLine.toString();
    }

    private static Map<Character, Character> generateEncodeDecodeMap(int shift, boolean encode) {
        Map<Character, Character> resultMap = new HashMap<>();

        if (encode) {
            for (char c : CHAR_ARRAY) {
                resultMap.put(c, (char) (c + shift));
            }
        } else {
            for (char c : CHAR_ARRAY) {
                resultMap.put((char) (c + shift), c);
            }
        }
        return resultMap;
    }

    private static void transformChar(char c) {
        if (transformMap.containsKey(c)) {
            resultLine.append(transformMap.get(c));
        } else {
            resultLine.append(c);
        }
    }
}
