package vladislav.kisliy.jff.test.leetcode.easy;

public class LongestCommonPrefix {

    private static final String EMPTY = "";

    public String longestCommonPrefix(String[] strs) {
        if (strs == null && strs.length < 1) {
            return EMPTY;
        }
        char[][] strInChars = new char[strs.length][];
        for (int i = 0; i < strs.length; i++) {
            strInChars[i] = (strs[i].toCharArray());
        }

        StringBuilder result = new StringBuilder();

        char[] firstElement = strInChars[0];
        boolean theSame = true;
        out:
        for (int i = 0; i < firstElement.length; i++) {
            char symbol = firstElement[i];
            for (int j = 1; j < strs.length; j++) {
                if (i < strInChars[j].length) {
                    theSame = theSame && (symbol == strInChars[j][i]);
                    if (!theSame) break out;
                } else break out;
            }
            if (theSame) {
                result.append(symbol);
            }
        }

        return result.length() == 0 ? EMPTY : result.toString();
    }
}
