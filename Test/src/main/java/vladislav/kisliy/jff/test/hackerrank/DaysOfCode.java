package vladislav.kisliy.jff.test.hackerrank;

import java.security.MessageDigest;
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

        char[] chars = Integer.toBinaryString(757).toCharArray();
        int max = 0;
        int counter = 0;
        for (char oneChar : chars) {
            if (oneChar == '1') {
                counter++;
            } else {
                if (max < counter) {
                    max = counter;
                }
                counter = 0;
            }
        }

        if (max < counter) {
            max = counter;
        }
        System.out.println("max =" + max);
//        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
//
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            String input = sc.next();
//            //Complete the code
//            StringBuilder hexString = new StringBuilder();
//            messageDigest.update(input.getBytes());
//            byte[] digiest = messageDigest.digest();
//
//            for (int i = 0; i < digiest.length; i++) {
//                String hex = Integer.toHexString(0xFF & digiest[i]);
//                if (hex.length() == 1) {
//                    hexString.append('0');
//                }
//                hexString.append(hex);
//            }
//
//            System.out.println(hexString.toString());
//        }

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update("HelloWorld".getBytes());
        byte[] digiest = messageDigest.digest();

        StringBuilder hexString = new StringBuilder();

        for (int i = 0; i < digiest.length; i++) {
            String hex = Integer.toHexString(0xFF & digiest[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        System.out.println(hexString.toString());

        int n = 5;
        for (int i = 1; i < 11; i++) {
            System.out.println(n + " x " + i + " = " + i * n);
        }

//        Scanner s = new Scanner(System.in);
//        int t = s.nextInt();
//        for (int i = 0; i < t; i++) {
//            char[] chars = s.next().toCharArray();
//            StringBuilder oddBuilder = new StringBuilder();
//            StringBuilder evenBuilder = new StringBuilder();
//            for (int j = 0; j < chars.length; j++) {
//                if (j % 2 == 0) {
//                    evenBuilder.append(chars[j]);
//                } else {
//                    oddBuilder.append(chars[j]);
//                }
//            }
//            System.out.println(evenBuilder.toString() + " " + oddBuilder.toString());
//        }

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        for (int i = n - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }

        scanner.close();
    }
}
