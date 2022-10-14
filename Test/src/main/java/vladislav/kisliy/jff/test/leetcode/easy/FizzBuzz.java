package vladislav.kisliy.jff.test.leetcode.easy;

import java.util.Arrays;
import java.util.List;

public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        String[] result = new String[n];
        boolean divisableBy5;
        boolean divisableBy3;
        String line;
        for (int i = 1; i <= n; i++) {
            divisableBy5 = (i % 5) == 0;
            divisableBy3 = (i % 3) == 0;
            if (divisableBy3) {
                if (divisableBy5) {
                    line = "FizzBuzz";
                } else {
                    line = "Fizz";
                }
            } else if (divisableBy5) {
                line = "Buzz";
            } else {
                line = String.valueOf(i);
            }
            result[i - 1] = line;
        }
        return Arrays.asList(result);
    }
}
