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
            long balance = n * n - ((n - 1) * (n - 1));
            resultCollector.add(n - 1);
            while (balance > 0) {
                long sqrt = (long) Math.pow(balance, 0.5);
                System.out.println("balance =" + balance + ", sqrt =" + sqrt);
                balance = balance - (sqrt * sqrt);
                resultCollector.add(sqrt);
            }
        } else {
            resultCollector.add(n);
        }
//        resultCollector.stream().
        return resultCollector.stream().map(Object::toString).collect(Collectors.joining(" "));
    }
    
//    public long dfs
    
    
    
    
//    public String decompose(long n) {
//        List<Long> list = new List<>();
//        DecomposeHelper(n * n, n - 1, list);
//        list.Reverse();
//        return list.Any() ? String.Join(" ", list) : null;
//    }
//
//    private static boolean DecomposeHelper(long n, long value, List<Long> list) {
//        if (n == 0) {
//            return true;
//        }
//        if (n == 1 && !list.contains(1l)) {
//            list.add(1l);
//            return true;
//        }
//        if (new []{2L, 3L}.contains(n)) {
//            return false;
//        }
//        for (var i = value; i > 0; i--) {
//            if (list.Contains(i)) {
//                return false;
//            }
//            list.Add(i);
//            var nextN = n - (i * i);
//            var works = DecomposeHelper(nextN, (long) Math.Floor(Math.Sqrt(nextN)), list);
//            if (works) {
//                return true;
//            }
//            list.Remove(i);
//        }
//        return false;
//    }

}
