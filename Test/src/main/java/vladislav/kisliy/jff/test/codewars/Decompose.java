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

import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 *
 * @author vlad
 */
public class Decompose {

    public String decompose(long n) {
        Set<Long> resultCollector = new TreeSet<>();

        if (n > 1) {
            System.out.println("    n =" + n + ", n-1 =" + (n - 1));
            long i = n - 1;
            while (i * (i + 1) * (2 * i + 1) / 6 >= n * n) {
                resultCollector.add(i);
                if (dfs(n*n, i, resultCollector)) {
                    break;
                }
                
            }
        } else {
            resultCollector.add(n);
        }
//        resultCollector.stream().
        return resultCollector.stream().map(Object::toString).collect(Collectors.joining(" "));
    }
    
//def decompose(n):
//    global suc
//    
//    suc = False
//    a = []
//    i = n - 1
//    while i * (i + 1) * (2 * i + 1) / 6 >= n * n:
//        a.append(i)
//        dfs(n * n, i, a)
//        if suc:
//            break
//        a.pop()
//        i -= 1
//    return a[::-1] if len(a) > 1 else None

    
        private static boolean dfs(long s, long n, Set<Long> a) {
        boolean result = false;
        if (s == 0 && a.size()>2) {
            a.remove(n);
            result = true;
        } else {
            s -=n*n;
            long i = n -1;
            while (i * (i + 1) * (2 * i + 1) / 6 >= s) {
                if (i*i > s) {
                    i--;
                } else {
                    a.add(i);
                    if (!dfs(s, i, a)) {
                        a.remove(i);
                        i--;
                        s += n * n;
                    }
                }
            }
        }
        return result;
    }
//        
//    public String decompose(long n) {
//        Set<Long> resultCollector = new TreeSet<>();
//
//        if (n > 1) {
//            System.out.println("    n =" + n + ", n-1 =" + (n - 1));
//            long balance = n * n - ((n - 1) * (n - 1));
//            resultCollector.add(n - 1);
//            while (balance > 0) {
//                long sqrt = (long) Math.pow(balance, 0.5);
//                System.out.println("balance =" + balance + ", sqrt =" + sqrt);
//                balance = balance - (sqrt * sqrt);
//                resultCollector.add(sqrt);
//            }
//        } else {
//            resultCollector.add(n);
//        }
////        resultCollector.stream().
//        return resultCollector.stream().map(Object::toString).collect(Collectors.joining(" "));
//    }
}
