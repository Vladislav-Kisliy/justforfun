package vladislav.kisliy.jff.test.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import static java.lang.System.in;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 27.09.19.
 */
class Prime {

    public static boolean isPrime(int number) {
        if (number == 1) return false;
        int dividors = (int) Math.sqrt(Math.abs(number));
        int counter = 0;
        for (int i = 2; i <= dividors; i++) {
            if (number % i == 0) counter++;
        }
        return (counter == 0);

    }

    public static void checkPrime(int... input) {
        for (int element : input) {
            if (isPrime(element)) {
                System.out.print(element + " ");
            }
        }
        System.out.println();
    }
}

public class PrimeCheckerSolution {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            int n3 = Integer.parseInt(br.readLine());
            int n4 = Integer.parseInt(br.readLine());
            int n5 = Integer.parseInt(br.readLine());
            Prime ob = new Prime();
            ob.checkPrime(n1);
            ob.checkPrime(n1, n2);
            ob.checkPrime(n1, n2, n3);
            ob.checkPrime(n1, n2, n3, n4, n5);
            Method[] methods = Prime.class.getDeclaredMethods();
            Set<String> set = new HashSet<>();
            boolean overload = false;
            for (int i = 0; i < methods.length; i++) {
                if (set.contains(methods[i].getName())) {
                    overload = true;
                    break;
                }
                set.add(methods[i].getName());

            }
            if (overload) {
                throw new Exception("Overloading not allowed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}


