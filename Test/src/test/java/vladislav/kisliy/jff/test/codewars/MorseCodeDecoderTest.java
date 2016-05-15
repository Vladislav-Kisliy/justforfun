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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 *
 * @author vlad
 */
public class MorseCodeDecoderTest {

    public MorseCodeDecoderTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testExampleFromDescription() {
        assertThat(MorseCodeDecoder.decode(".... . -.--   .--- ..- -.. ."), is("HEY JUDE"));
    }

    @Test
    public void test1() {
        assertThat(MorseCodeDecoder.decode("...---..."), is("SOS"));
    }

    @Test
    public void test2() {
        assertThat(MorseCodeDecoder.decode("    .   .     "), is("E E"));
    }

    @Test
    public void testMoreComplexTests() {
        assertThat(MorseCodeDecoder.decode("...---..."), is("SOS"));

//        assertThat(MorseCodeDecoder.decode(" ...---... -.-.-- - .... . --.- ..- .. -.-. -.- -... .-. --- .-- -. ..-. --- -..- .--- ..- -- .--. ... --- ...- . .-. - .... . .-.. .- --.. -.-- -.. --- --. .-.-.- "),
//                is("SOS! THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG."));
    }

    @Test
    public void testBitsExampleFromDescription() throws Exception {
        assertThat(MorseCodeDecoder.decode(MorseCodeDecoder.decodeBits("1100110011001100000011000000"
                + "1111110011001111110011"
                + "111100000000000000110011111100111111001111110000001100110011"
                + "11110000001111110011001100000011")),
                is("HEY JUDE"));
    }

    @Test
    public void testExtraZerosHandling() throws Exception {
        assertThat(MorseCodeDecoder.decode(MorseCodeDecoder.decodeBits("01110")),
                is("E"));
    }

    @Test
    public void testBasicBitsDecoding() throws Exception {
        assertThat(MorseCodeDecoder.decode(MorseCodeDecoder.decodeBits("1")),
                is("E"));
        assertThat(MorseCodeDecoder.decode(MorseCodeDecoder.decodeBits("101")),
                is("I"));
        assertThat(MorseCodeDecoder.decode(MorseCodeDecoder.decodeBits("10001")),
                is("EE"));
        assertThat(MorseCodeDecoder.decode(MorseCodeDecoder.decodeBits("10111")),
                is("A"));
        assertThat(MorseCodeDecoder.decode(MorseCodeDecoder.decodeBits("1110111")),
                is("M"));
    }

    @Test
    public void testLongMessagesHandling() throws Exception {
        assertThat(MorseCodeDecoder.decode(MorseCodeDecoder.decodeBits("000111000101010100010000000"
                + "111011101011100010101110001010001110101110100011101011100000001110101010001011101"
                + "000111011101110001011101110001110100000001010111010001110111011100011101010111"
                + "00000001011101110111000101011100011101110001011101110100010101000000011101110111"
                + "00010101011100010001011101000000011100010101010001000000010111010100010111000111"
                + "0111010100011101011101110000000111010100011101110111000111011101000101110101110101110")),
                is("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG."));
        assertThat(MorseCodeDecoder.decode(MorseCodeDecoder.decodeBits(
                "11111111111111100000000000000011111000001111100000111110000011111"
                + "000000000000000111110000000000000000000000000000000000011111111111111100000"
                + "111111111111111000001111100000111111111111111000000000000000111110000011111"
                + "00000111111111111111000000000000000111110000011111000000000000000"
                + "1111111111111110000011111000001111111111111110000011111"
                + "00000000000000011111111111111100000111110000011111111111"
                + "11110000000000000000000000000000000000011111111111111100000111110000011111000"
                + "0011111000000000000000111110000011111111111111100000111110000000000000001111111111111"
                + "110000011111111111111100000111111111111111000000000000000"
                + "1111100000111111111111111000001111111111111110000000000000001111111111111110000011111"
                + "00000000000000000000000000000000000111110000011111000001111111111111110000011111"
                + "0000000000000001111111111111110000011111111111111100000111111111111111000000000000000"
                + "1111111111111110000011111000001111100000111111111111111"
                + "00000000000000000000000000000000000111110000011111111111111100000"
                + "1111111111111110000011111111111111100000000000000011111000001111100000"
                + "11111111111111100000000000000011111111111111100000111111111111111000000000000000"
                + "11111000001111111111111110000011111111111111100000111110000000000000001111100000"
                + "1111100000111110000000000000000000000000000000000011111111111111100000111111111111111"
                + "00000111111111111111000000000000000111110000011111000001111100000111111111111111"
                + "0000000000000001111100000000000000011111000001111111111111110000011111"
                + "000000000000000000000000000000000001111111111111110000000000000001111100000"
                + "11111000001111100000111110000000000000001111100000000000000000000000000000000000"
                + "1111100000111111111111111000001111100000111110000000000000001111100000111111111111111"
                + "0000000000000001111111111111110000011111111111111100000111110000011111000000000000000"
                + "1111111111111110000011111000001111111111111110000011111111111111100000000000000000000000000000000000"
                + "111111111111111000001111100000111110000000000000001111111111111110000011111111111111100000"
                + "111111111111111000000000000000111111111111111000001111111111111110000011111000000000000000"
                + "1111100000111111111111111000001111100000111111111111111000001111100000111111111111111")),
                is("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG."));
    }

    @Test
    public void testMultipleBitsPerDotHandling() throws Exception {
        assertThat(MorseCodeDecoder.decode(MorseCodeDecoder.decodeBits("111")),
                is("E"));
        assertThat(MorseCodeDecoder.decode(MorseCodeDecoder.decodeBits("1111111")),
                is("E"));
        assertThat(MorseCodeDecoder.decode(MorseCodeDecoder.decodeBits("110011")),
                is("I"));
        assertThat(MorseCodeDecoder.decode(MorseCodeDecoder.decodeBits("111000111")),
                is("I"));
        assertThat(MorseCodeDecoder.decode(MorseCodeDecoder.decodeBits("111110000011111")),
                is("I"));
        assertThat(MorseCodeDecoder.decode(MorseCodeDecoder.decodeBits("11111100111111")),
                is("M"));
        
    }

// input bits =
//
//Expected: is ""
//     but: was "VUU EEUVUVFUEFUE EUU EFEVEIU UUEFEIUUE UEEVUIVEE UU EEVUU EU VUU UEU IEUFUEE EUFEIE EUEUE"
}
