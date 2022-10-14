package vladislav.kisliy.jff.test.leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestCommonPrefixTest {

    @Test
    public void longestCommonPrefix() {
        LongestCommonPrefix target = new LongestCommonPrefix();
        assertEquals("", target.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        assertEquals("fl", target.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        assertEquals("a", target.longestCommonPrefix(new String[]{"ab", "a"}));
    }
}
