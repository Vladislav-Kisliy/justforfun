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

import java.math.BigDecimal;
import java.util.Arrays;

/**
 *
 * @author vlad
 */
public class NewAverage {
    
    public static long newAvg(double[] a, double navg) {
        double sum = Arrays.stream(a).sum();
        double result = navg * (a.length + 1) - sum;
        if (result > 0) {
            return Math.round(Math.ceil(result));
        } else {
            throw new IllegalArgumentException();
        }
    }

    // My version
//    public static long newAvg(double[] arr, double navg) {
//        if (navg < 0.0d) {
//            throw new IllegalArgumentException();
//        }
//        double sum = 0d;
//        for (double d : arr) {
//            sum += d;
//        }
//        if ((sum / arr.length) > navg) {
//            throw new IllegalArgumentException();
//        }
//        double result = (arr.length + 1) * navg - sum;
//        BigDecimal bd = new BigDecimal(Double.toString(result));
////        bd = bd.setScale(5, BigDecimal.ROUND_CEILING);
//        bd = bd.setScale(5, BigDecimal.ROUND_HALF_EVEN);
//        return bd.longValue();
//    }
}
