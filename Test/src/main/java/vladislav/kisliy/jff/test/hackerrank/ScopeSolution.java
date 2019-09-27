package vladislav.kisliy.jff.test.hackerrank;

import java.util.Scanner;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 16.09.19.
 */

class Difference {

    private int[] elements;
    public int maximumDifference;


    public Difference(int[] a) {
        this.elements = a;
    }

    public void computeDifference() {
        if (elements.length > 1) {
            java.util.Arrays.sort(elements);
            maximumDifference = elements[elements.length - 1] - elements[0];
        }
    }
}

public class ScopeSolution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}
