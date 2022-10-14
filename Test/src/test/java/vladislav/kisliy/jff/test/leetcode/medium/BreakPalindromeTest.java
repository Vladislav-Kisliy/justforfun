package vladislav.kisliy.jff.test.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class BreakPalindromeTest {

    @Test
    public void breakPalindrome() {
        BreakPalindrome target = new BreakPalindrome();
        assertEquals("", target.breakPalindrome("a"));
        assertEquals("aaccba", target.breakPalindrome("abccba"));
    }
}