package vladislav.kisliy.jff.test.leetcode.medium;

public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        int firstNumber = Integer.MAX_VALUE;
        int secondNumber = Integer.MAX_VALUE;
        boolean result = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= firstNumber) {
                firstNumber = nums[i];
            } else if (nums[i] <= secondNumber) {
                secondNumber = nums[i];
            } else {
                result = true;
                break;
            }
        }
        return result;
    }
}
