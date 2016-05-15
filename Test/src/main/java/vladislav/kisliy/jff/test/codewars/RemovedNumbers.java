/*
 * Copyright (C) 2016 vlad
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package vladislav.kisliy.jff.test.codewars;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RemovedNumbers {

    public static List<long[]> removNb(long n) {
        long sum = (n * n + n) / 2;
        List<long[]> list = new LinkedList<>();
        long halfN = n / 2;
        long sqrtN = (long) Math.sqrt(n);
        for (long i = halfN; i <= n - sqrtN; i++) {
            long sumMinusI = (sum - i);
            if ((sumMinusI % (i + 1)) == 0) {
                double j = (sumMinusI / (i + 1));
                list.add(new long[]{i, (long) j});
            }
        }
        return list;
    }
    
    
//    public static List<long[]> removNb(long n) {
//        final long start = System.currentTimeMillis();
//        long sum = (n * n + n) / 2;
//        System.out.println(" n=" + n + ", full Sum =" + sum);
//        List<long[]> list = new LinkedList<>();
//        long halfN = n / 2;
//        long sqrtN = (long) Math.sqrt(n);
//        System.out.println("halfN =" + halfN + ", sqrtN=" + sqrtN);
//        for (long i = halfN; i <= n - sqrtN; i++) {
//            long sumMinusI = (sum - i);
//            if ((sumMinusI % (i + 1)) == 0) {
//                double j = (sumMinusI / (i + 1));
//                list.add(new long[]{i, (long) j});
////                list.add(new long[]{j, i});
//                System.out.println("sum -i =" + sumMinusI + ", div =" + (sumMinusI / (i + 1)));
//                System.out.println("i =" + i + ", j=" + j);
////                break;
//            }
//        }
//        System.out.format("%.3f\n", (System.currentTimeMillis() - start) / 1000.0);
//        System.out.println("result =" + list);
//        for (long[] ls : list) {
//            System.out.println("for n =" + n + ", array =" + Arrays.toString(ls));
//        }
//        return list;
//    }
    
//    public static List<long[]> removNb(long n) {
//    
//    final long sum = n * (n + 1) / 2;
//    final List<long[]> result = new ArrayList();
//        
//    for (long a = 3; a <= n; a++) {
//      final double b = (sum - a) / (a + 1.0);
//      
//      if (b % 1 == 0 && b <= n && b != a) {
//        result.add(new long[] {a, (long) b});
//      }
//    }
//    
//    return result;
//  }
    
//    public static List<long[]> removNb(long n) {
//        final long start = System.currentTimeMillis();
//
//        long sum = (n * n + n) / 2;
//        System.out.println(" n=" + n + ", full Sum =" + sum);
//        List<long[]> list = new LinkedList<>();
//        for (int i = 1; i < n; i++) {
//            for (int j = i + 1; j <= n; j++) {
//                if (sum == i + j + i * j) {
//                    list.add(new long[]{i, j});
//                    list.add(new long[]{j, i});
//                    break;
//                }
//
//            }
//        }
//        for (long[] ls : list) {
//            System.out.println("for n =" + n + ", array =" + Arrays.toString(ls));
//        }
//        System.out.format("%.3f\n", (System.currentTimeMillis() - start) / 1000.0);
//        return list;
//    }

//    public static List<long[]> removNb(long n) {
//        long fullSum = (n + 1) * n / 2;
//        System.out.println(" n=" + n + ", full Sum =" + fullSum);
//        List<long[]> result = new ArrayList<>();
//        long sqrtN = (long) Math.sqrt(n);
//        long halfN = n/2;
//        for (long j = halfN; j <= halfN+sqrtN; j++) {
//            for (long i = n-(sqrtN/2); i > halfN+sqrtN; i--) {
//                System.out.println("i ="+i+", j="+j);
//                long subSum = fullSum - i - j;
//                if (i * j == subSum) {
//                    result.add(new long[]{j, i});
//                    result.add(new long[]{i, j});
////                    System.out.println("i =" + i + ", j=" + j + ", arr=" + result);
//                    break;
//                }
//            }
////            if (!result.isEmpty()) {
////                break;
////            }
//        }
//        System.out.println("result =" + result);
//        System.out.println("result =" + result.size());
//        return result;
//    }
    private static List<Long> factorization(long x) {
        List<Long> result = new ArrayList<>();
        for (long i = 1; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                result.add(i);
                if (x / i != i) {
                    result.add(x / i);
                }
            }
        }
        return result;
    }
}
