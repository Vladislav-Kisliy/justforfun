package vladislav.kisliy.jff.test.leetcode.easy;

public class Roman2Integer {
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int counter = 0;
        int lastIndex = chars.length - 1;
        for (int i = lastIndex; i >= 0; i--) {
            int value = CharValue.getDecValue(chars[i]);
            if (i != lastIndex && value < CharValue.getDecValue(chars[i + 1])) {
                counter -= value;
            } else {
                counter += value;
            }
        }

        return counter;
    }

    private enum CharValue {
        I('I', 1), V('V', 5), X('X', 10), L('L', 50),
        C('C', 100), D('D', 500), M('M', 1000);

        private final char romanChar;
        private final int decValue;

        CharValue(char romanChar, int decValue) {
            this.romanChar = romanChar;
            this.decValue = decValue;
        }

        public static int getDecValue(char romanChar) {
            int result = 0;
            for (CharValue charValue : CharValue.values()) {
                if (charValue.romanChar == romanChar) {
                    result = charValue.decValue;
                    break;
                }
            }
            return result;
        }
    }
}
