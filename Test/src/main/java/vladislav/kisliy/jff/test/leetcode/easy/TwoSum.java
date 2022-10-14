package vladislav.kisliy.jff.test.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static final int[] EMPTY_ARRAY = new int[0];

    public int[] twoSum(int[] nums, int target) {
        if (nums == null && nums.length < 1) {
            return EMPTY_ARRAY;
        }

        int[] result = EMPTY_ARRAY;
        Map<Integer, Integer> valueIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            Integer diff = target - number;
            if (valueIndex.containsKey(diff)) {
                result = new int[]{valueIndex.get(diff), i};
                break;
            } else {
                valueIndex.put(number, i);
            }
        }

        return result;
    }
}
