package vladislav.kisliy.jff.test.leetcode.easy;

public class RichestCustomerWealth {

    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for (int i = 0; i < accounts.length; i++) {
            int[] currentPos = accounts[i];
            int counter = 0;
            for (int j = 0; j < currentPos.length; j++) {
                counter += currentPos[j];
            }
            if (counter > maxWealth) {
                maxWealth = counter;
            }
        }

        return maxWealth;
    }
}
