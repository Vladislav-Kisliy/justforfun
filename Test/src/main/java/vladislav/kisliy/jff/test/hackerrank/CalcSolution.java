package vladislav.kisliy.jff.test.hackerrank;

import java.util.Scanner;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 19.09.19.
 */
class Calculator {
    public int power(int n, int p) throws NegativeNuberException {
        if (n < 0 || p < 0) throw new NegativeNuberException();
        return (int) Math.pow(n, p);
    }
}

class NegativeNuberException extends Exception {
    public NegativeNuberException() {
        super("n and p should be non-negative");
    }
}

public class CalcSolution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {

            int n = in.nextInt();
            int p = in.nextInt();
            Calculator myCalculator = new Calculator();
            try {
                int ans = myCalculator.power(n, p);
                System.out.println(ans);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        in.close();
    }

}
