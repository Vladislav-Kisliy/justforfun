package vladislav.kisliy.jff.test.leetcode.easy;

import org.junit.Test;
import vladislav.kisliy.jff.test.leetcode.easy.Roman2Integer;

import static org.junit.Assert.*;

public class Roman2IntegerTest {

    @Test
    public void romanToInt() {
        Roman2Integer target = new Roman2Integer();
        assertEquals(3, target.romanToInt("III"));
        assertEquals(58, target.romanToInt("LVIII"));
        assertEquals(4, target.romanToInt("IV"));
        assertEquals(9, target.romanToInt("IX"));
        assertEquals(1994, target.romanToInt("MCMXCIV"));
    }
}
