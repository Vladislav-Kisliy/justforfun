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

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author vlad
 */
public class MorseCodeDecoder {

    private static final Map<String, String> DECODER_MAP = new HashMap<>();

    static {
        DECODER_MAP.put(".-", "A");
        DECODER_MAP.put("-...", "B");
        DECODER_MAP.put("-.-.", "C");
        DECODER_MAP.put("-..", "D");
        DECODER_MAP.put(".", "E");
        DECODER_MAP.put("..-.", "F");
        DECODER_MAP.put("--.", "G");
        DECODER_MAP.put("....", "H");
        DECODER_MAP.put("..", "I");
        DECODER_MAP.put(".---", "J");
        DECODER_MAP.put("-.-", "K");
        DECODER_MAP.put(".-..", "L");
        DECODER_MAP.put("--", "M");
        DECODER_MAP.put("-.", "N");
        DECODER_MAP.put("---", "O");
        DECODER_MAP.put(".--.", "P");
        DECODER_MAP.put("--.-", "Q");
        DECODER_MAP.put(".-.", "R");
        DECODER_MAP.put("...", "S");
        DECODER_MAP.put("-", "T");
        DECODER_MAP.put("..-", "U");

        DECODER_MAP.put("...-", "V");
        DECODER_MAP.put(".--", "W");
        DECODER_MAP.put("-..-", "X");
        DECODER_MAP.put("-.--", "Y");

        DECODER_MAP.put("--..", "Z");
        DECODER_MAP.put("-----", "0");
        DECODER_MAP.put(".----", "1");
        DECODER_MAP.put("..---", "2");
        DECODER_MAP.put("...--", "3");
        DECODER_MAP.put("....-", "4");
        DECODER_MAP.put(".....", "5");
        DECODER_MAP.put("-....", "6");
        DECODER_MAP.put("--...", "7");
        DECODER_MAP.put("---..", "8");
        DECODER_MAP.put("----.", "9");
        DECODER_MAP.put(".-.-.-", ".");
        DECODER_MAP.put("--..--", ",");
        DECODER_MAP.put("..--..", "?");
        DECODER_MAP.put("-.-.--", "!");
        
        DECODER_MAP.put("...---...", "SOS");
    }

    public static String decode(String morseCode) {
        StringBuilder strBuf = new StringBuilder();
        if (morseCode.contains(" ")) {
            String[] morseSplit = morseCode.trim().split(" ");

            int spaceCounter = 1;
            for (String morseSign : morseSplit) {
                if (DECODER_MAP.containsKey(morseSign)) {
                    strBuf.append(DECODER_MAP.get(morseSign));
                    spaceCounter = 1;
                } else {
                    spaceCounter++;
                    if (spaceCounter == 3) {
                        strBuf.append(" ");
                    }
                }
            }
        } else {
            strBuf.append(DECODER_MAP.get(morseCode.trim()));
        }

        return strBuf.toString();
    }
    
//    public static String decode(String morseCode) {
//      return Arrays.stream(morseCode.split("   "))
//                      .map(i -> Arrays.stream(i.split(" "))   
//                                      .map(l -> MorseCode.get(l))                                        
//                                      .filter(l -> l != null)                                      
//                                      .collect(Collectors.joining()))
//                      .collect(Collectors.joining(" "))
//                      .trim();
//    }
    
//    public static String decode(String morseCode) {
//      String result = "";
//      for(String word : morseCode.trim().split("   ")) {
//        for(String letter : word.split("\\s+")) {
//          result += MorseCode.get(letter);
//        }
//        result += ' ';
//      }
//      return result.trim();
//    }
}
