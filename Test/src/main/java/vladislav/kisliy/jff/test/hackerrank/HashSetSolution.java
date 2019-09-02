package vladislav.kisliy.jff.test.hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 31.08.19.
 */
public class HashSetSolution {


    public static void main(String[] argh) {
//        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String[] pair_left = new String[t];
        String[] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        Set<String> set = new HashSet<>();

        for (int i = 0; i < pair_left.length; i++) {
            set.add(pair_left[i] + " " + pair_right[i]);
            System.out.println(set.size());
        }
    }

}
