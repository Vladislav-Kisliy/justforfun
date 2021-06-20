package vladislav.kisliy.jff.test.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 05.09.19.
 */
public class DaysOfCode {

    // Complete the solve function below.
    public static void solve(double meal_cost, int tip_percent, int tax_percent) {
        double tip = meal_cost * tip_percent / 100;
        double tax = meal_cost * tax_percent / 100;
        double totalCost = meal_cost + tip + tax;
        System.out.println(Math.round(totalCost));

    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(in);

        int actualDay = sc.nextInt();
        int actualMonth = sc.nextInt();
        int actualYear = sc.nextInt();

        int expectedDay = sc.nextInt();
        int expectedMonth = sc.nextInt();
        int expectedYear = sc.nextInt();
        sc.close();

        int fine = 0;
        if (expectedYear <= actualYear && expectedMonth <= actualMonth &&
                expectedDay <= actualDay) {
            if (expectedYear < actualYear) {
                fine = 10000;
            } else if (expectedMonth < actualMonth) {
                fine = 500 * (actualMonth - expectedMonth);
            } else if (expectedDay < actualDay) {
                fine = 15 * (actualDay - expectedDay);
            }
        } else {

        }

        System.out.println(fine);

    }

    private static void swap(int i, int i1) {

    }
}
