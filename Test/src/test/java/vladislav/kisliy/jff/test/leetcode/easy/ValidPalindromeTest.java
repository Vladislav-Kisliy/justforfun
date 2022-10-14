package vladislav.kisliy.jff.test.leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidPalindromeTest {

    @Test
    public void isPalindrome() {
        ValidPalindrome target = new ValidPalindrome();
        assertFalse(target.isPalindrome("race a car"));
        assertTrue(target.isPalindrome("a"));
        assertTrue(target.isPalindrome(""));
        assertTrue(target.isPalindrome("A man, a plan, a canal: Panama"));
    }
}