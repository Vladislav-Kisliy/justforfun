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

import java.util.function.Function;
import java.util.function.ToDoubleFunction;

/**
 *
 * @author vlad
 */
public class FunctionalProgramming {

//    testCorrectFunctionType(FunctionalProgrammingTest)
//Incorrect function type
    public static Function<Student, Boolean> f = (Student student) -> {
        if (student == null) {
            throw new IllegalArgumentException();
        }
        Boolean result = false;
        if ("John Smith".equals(student.getFullName())
                && ("js123".equals(student.studentNumber))) {
            result = true;
        }
        return result;
    };

    public static ToDoubleFunction<Triangle> triangleArea = (Triangle t) -> {
        if (t == null) {
            throw new IllegalArgumentException();
        }
        Double result = t.base * t.height * 0.5;
        t.setArea(result);
        return result;
    };

//    public interface Area {
//
//        public Double applyAsDouble(Triangle t);
//    }
//
//    public static Area f = (Triangle t) -> {
//        if (t == null) {
//            throw new IllegalArgumentException();
//        }
//        Double result = t.base * t.height * 0.5;
//        t.setArea(result);
//        return result;
//    };
    public static void main(String[] args) {
//        () -> System.out.println("Zero parameter lambda");
//        f = (Double base, Double height) -> 0.5 * base * height;
        System.out.println("");

    }
//    public static Double f =  ;

}
