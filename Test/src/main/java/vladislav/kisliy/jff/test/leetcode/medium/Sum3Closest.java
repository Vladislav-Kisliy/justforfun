package vladislav.kisliy.jff.test.leetcode.medium;

import java.util.Arrays;

public class Sum3Closest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int previousDiff = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int tail = nums.length - 1;
            while (j < tail) {
                int sum = nums[i] + nums[j] + nums[tail];
                int diff = Math.abs(sum - target);

                if (diff == 0) return sum;

                if (previousDiff > diff) {
                    previousDiff = diff;
                    result = sum;
                }
                if (sum <= target) {
                    j++;
                } else {
                    tail--;
                }
            }
        }

        return result;
    }
}
