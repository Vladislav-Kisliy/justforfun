package vladislav.kisliy.jff.test.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 30.09.19.
 */
public class RegExpSolution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int result = 4 & 2;
        System.out.println("8 & 5 =" + result);
        System.out.println(Integer.toString(2, 2));
        System.out.println(Integer.toString(5, 2));
        System.out.println(Integer.toString(5 >> 1, 2));

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        List<String> names = new ArrayList<>();

        result = 8 & 2;
        System.out.println(Integer.toString(2, 2));

        System.out.println("8 & 5 =" + result);

        for (int NItr = 0; NItr < N; NItr++) {
            String[] firstNameEmailID = scanner.nextLine().split(" ");

            String firstName = firstNameEmailID[0];

            String emailID = firstNameEmailID[1];
            if (emailID.endsWith("@gmail.com")) {
                names.add(firstName);
            }
        }
        scanner.close();

        System.out.println(names);
        Collections.sort(names);
        for (String firstName : names) {
            System.out.println(firstName);
        }
    }
}
