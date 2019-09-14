package vladislav.kisliy.jff.test.hackerrank;

import java.util.Scanner;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 13.09.19.
 */
public class Array2D {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };

//        for (int i = 0; i < 6; i++) {
//            String[] arrRowItems = scanner.nextLine().split(" ");
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//            for (int j = 0; j < 6; j++) {
//                int arrItem = Integer.parseInt(arrRowItems[j]);
//                arr[i][j] = arrItem;
//            }
//        }
//
//        scanner.close();


    }

//    public static int[][] extrackHourGlass(int[][] arr, int x, int y) {
//        int[][] result = new int[3][3];
//        for (int i = 0; i < result.length; i++) {
//            for (int j = 0; j < result.length; j++) {
//                result[i][j] = arr[i + x][j + y];
//            }
//        }
//
//
//        return result;
//    }

    public static int getMaxHourGlass(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 0; j < arr[i].length - 2; j++) {
                int sumHourGlass = sumHourGlass(arr, i, j);
                if (sumHourGlass > max) max = sumHourGlass;
            }
        }

        return max;
    }

    public static int sumHourGlass(int[][] arr, int x, int y) {
        int result = 0;

        result += arr[x][y];
        result += arr[x][y + 1];
        result += arr[x][y + 2];
        result += arr[x + 1][y + 1];
        result += arr[x + 2][y];
        result += arr[x + 2][y + 1];
        result += arr[x + 2][y + 2];

        return result;
    }

}
