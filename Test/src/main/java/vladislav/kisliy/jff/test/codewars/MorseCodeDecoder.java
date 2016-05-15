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
import java.util.Map;

/**
 *
 * @author vlad
 */
public class MorseCodeDecoder {

    private static final String ONE = "1";
    private static final String ZERO = "0";
    
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
        DECODER_MAP.put("-----", ZERO);
        DECODER_MAP.put(".----", ONE);
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
    public static String decodeBits(String bits) {
        String result;
        if (ONE.equals(bits)) {
            result = ".";
        } else {
            int minSequence = scanMinSequence(bits);
            StringBuilder signMatcher = new StringBuilder();
            for (int i = 0; i < minSequence; i++) {
                signMatcher.append(ONE);
            }
            String removedOnes = bits.replaceAll(signMatcher.toString(), ONE);
            signMatcher.setLength(0);
            for (int i = 0; i < minSequence; i++) {
                signMatcher.append(ZERO);
            }
            result = removedOnes
                    .replaceAll(signMatcher.toString(), ZERO)
                    .replaceAll("111", "-")
                    .replaceAll("10", ".")
                    .replaceAll(ONE, ".")
                    .replaceAll("00", " ")
                    .replaceAll(ZERO, "");
        }
        return result;
    }
    
    private static int scanMinSequence(String line) {
        int result;
        if (line.indexOf("010") > 1) {
            result = 1;
        } else {
            int startOne = line.indexOf(ONE);
            int startZero = line.indexOf(ZERO, startOne);
            if (startZero > 0) {
                // Scan 1's
                result = startZero - startOne;
                int startPos = 0;
                while (startPos < line.length()) {
                    startOne = line.indexOf(ONE, startZero);
                    startZero = line.indexOf(ZERO, startOne);
                    if ((startOne > 0 && startZero > 0)
                            && (startZero - startOne < result)) {
                        result = startZero - startOne;
                    } else {
                        startPos = line.length();
                    }
                }
                // Recheck by 0's
                startPos = 0;
                while (startPos < line.length()) {
                    startZero = line.indexOf(ZERO);
                    startOne = line.indexOf(ONE, startZero);
                    if ((startOne > 0 && startZero > 0)
                            && (startOne - startZero < result)) {
                        result = startOne - startZero;
                    } else {
                        startPos = line.length();
                    }
                }
            } else {
                result = line.length() - startOne;
            }
        }
        return result;
    }

    public static String decodeMorse(String morseCode) {
        return " ";
//      return MorseCode.get(morseCode);
    }
    
//    public static String decodeBits(String bits) {
//        String trimmedBits = bits.replaceAll("^0+|0+$", "");
//        int rate = getRate(trimmedBits);
//
//        String morseCode = "";
//        for (String word : trimmedBits.split("0{"+ (7 * rate) +"}")) {
//            for (String letter : word.split("0{"+ (3 * rate) +"}")) {
//                for (String dot : letter.split("0{" + rate + "}")) {
//                    morseCode += dot.length() > rate ? '-' : '.';
//                }
//                morseCode += ' ';
//            }
//            morseCode += "  ";
//        }
//        return morseCode;
//    }
//
//    private static int getRate(String bits) {
//        int rate = Integer.MAX_VALUE;
//        Matcher matcher = Pattern.compile("1+|0+").matcher(bits);
//        while (matcher.find()) {
//            rate = Math.min(rate, matcher.group().length());
//        }
//        return rate;
//    }
//
//    public static String decodeMorse(String morseCode) {
//        String decoded = "";
//        for (String word : morseCode.trim().split("   ")) {
//            for (String letter : word.split(" ")) {
//                decoded += MorseCode.get(letter);
//            }
//            decoded += ' ';
//        }
//        return decoded.trim();
//    }
}
