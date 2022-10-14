package vladislav.kisliy.jff.test.leetcode.easy;

public class StepsReduce2Zero {

    public int numberOfSteps(int num) {
        int counter = 0;
        int accumulator = num;
        while (accumulator != 0) {
            if (isEvenBit(accumulator)) {
                accumulator = accumulator / 2;
            } else {
                accumulator--;
            }
            counter++;
        }
        return counter;
    }

    public static boolean isEvenBit(int i) {
        return (i & 1) == 0;
    }
}
