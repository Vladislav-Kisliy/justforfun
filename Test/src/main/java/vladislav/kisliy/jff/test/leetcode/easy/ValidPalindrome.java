package vladislav.kisliy.jff.test.leetcode.easy;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if ("".equals(s) || s.length() < 2) {
            return true;
        }
        char[] chars = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase().toCharArray();
        boolean result = true;
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
