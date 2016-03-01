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

/**
 *
 * @author vlad
 */
public class BinaryCalculator {

    public static String calculate(final String n1, final String n2, final String o) {
    final int a = Integer.parseInt(n1, 2);
    final int b = Integer.parseInt(n2, 2);
    
    switch(o) {
      case "add": return Integer.toBinaryString(a + b);
      case "subtract": return Integer.toBinaryString(a - b);
      case "multiply": return Integer.toBinaryString(a * b);
      default: return "";
    }
  }

//    public static String calculate(final String n1, final String n2, final String o) {
//        if ((n1 == null) || (n2 == null) || (o == null)) {
//            return null;
//        }
//        long result = 0;
//        Long num1 = Long.parseLong(n1, 2);
//        Long num2 = Long.parseLong(n2, 2);
//
//        switch (o) {
//            case "add":
//                result = num1 + num2;
//                break;
//            case "subtract":
//                result = num1 - num2;
//                break;
//            case "multiply":
//                result = num1 * num2;
//                break;
//        }
//        if (result >= 0) {
//            return Long.toBinaryString(result);
//        } else {
//            return "-" + Long.toBinaryString(-result);
//        }
//    }

    public static void main(String[] args) {
        int parseInt = Integer.parseInt("1001", 2);
        System.out.println("parse Int=" + parseInt);
    }
}
