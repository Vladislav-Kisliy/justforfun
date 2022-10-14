package vladislav.kisliy.jff.test.leetcode.easy;

public class RopeColorful {
    
    public int minCost(String colors, int[] neededTime) {
        if (colors == null || colors.length() == 0) {
            return 0;
        }
        char prev = colors.charAt(0);
        int result = 0;
        for (int i = 1; i < neededTime.length; i++) {
            if (colors.charAt(i) == prev) {
                result += Math.min(neededTime[i - 1], neededTime[i]);
                neededTime[i] = Math.max(neededTime[i - 1], neededTime[i]);
            } else {
                prev = colors.charAt(i);
            }
        }
        return result;
    }
}
