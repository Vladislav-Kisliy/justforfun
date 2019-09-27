package vladislav.kisliy.jff.test.hackerrank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 27.09.19.
 */
public class PrimeSolution {

    public static boolean isPrime(int number) {
        if (number == 1) return false;
        int dividors = (int) Math.sqrt(Math.abs(number));
        int counter = 0;
        for (int i = 2; i <= dividors; i++) {
            if (number % i == 0) counter++;
        }
        return (counter == 0);

    }

    public static void main(String[] args) throws FileNotFoundException {
        InputStream in = new FileInputStream("/home/vlad/work/projects/gits/justforfun/Test/src/main/resources/primetestcase5.txt");
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        Scanner sc = new Scanner(br);
        Node head = null;
        int N = sc.nextInt();

        while (N-- > 0) {
            int ele = sc.nextInt();
            System.out.println(isPrime(ele) ? "Prime" : "Not prime");
        }
    }
}
