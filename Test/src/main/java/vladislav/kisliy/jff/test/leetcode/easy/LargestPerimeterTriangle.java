package vladislav.kisliy.jff.test.leetcode.easy;

import java.util.Arrays;

public class LargestPerimeterTriangle {

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;

        int result = 0;
        for (int i = length - 1; i > 1; i--) {
            int highestValue = nums[i];
            int sumLows = nums[i - 1] + nums[i - 2];
            if (highestValue < sumLows) {
                result = highestValue + sumLows;
                break;
            }
        }

        return result;
    }

}
