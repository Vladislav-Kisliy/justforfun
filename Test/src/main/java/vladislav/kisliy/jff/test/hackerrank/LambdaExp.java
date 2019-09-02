package vladislav.kisliy.jff.test.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 31.08.19.
 */
interface PerformOperation {
    boolean check(int a);
}

class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    public PerformOperation isOdd() {
        return a -> ((a % 2) != 0);
    }

    public PerformOperation isPrime() {
        return a -> {
            int dividors = (int) Math.sqrt(a);
            int counter = 0;
            for (int i = 2; i <= dividors; i++) {
                if (a % i == 0) counter++;
            }
            return (counter == 0);
        };
    }

    public PerformOperation isPalindrome() {
        return a -> {
            char[] chars = String.valueOf(a).toCharArray();
            for (int i = 0; i < chars.length / 2; i += 2) {
                if (chars[i] != chars[chars.length - 1 - i]) {
                    return false;
                }

            }
            return true;
        };
    }
}

public class LambdaExp {

    private final MyMath ob = new MyMath();

    public boolean isPalindrome(int num) {
        PerformOperation op = ob.isPalindrome();
        boolean ret = ob.checker(op, num);

        return ret;
    }

    public boolean isPrime(int num) {
        PerformOperation op = ob.isPrime();
        boolean ret = ob.checker(op, num);

        return ret;
    }

    public boolean isOdd(int num) {
        PerformOperation op = ob.isOdd();
        boolean ret = ob.checker(op, num);

        return ret;
    }

    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }


}
