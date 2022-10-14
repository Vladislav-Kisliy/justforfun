package vladislav.kisliy.jff.test.leetcode.medium;

public class BreakPalindrome {

    public String breakPalindrome(String palindrome) {
        int palindromeLength = palindrome.length();
        if (palindromeLength == 1) {
            return "";
        }

        for (int i = 0; i < palindromeLength; i++) {
            if (palindrome.charAt(i) != 'a' &&
                    (palindromeLength % 2 == 0 || i != palindromeLength / 2)) {
                return palindrome.substring(0, i) + "a" + palindrome.substring(i + 1);
            }
        }
        return palindrome.substring(0, palindromeLength - 1) + "b";
    }
}
