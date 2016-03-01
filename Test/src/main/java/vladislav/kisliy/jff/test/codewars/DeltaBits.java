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
public class DeltaBits {
    
//Write a function convertBits to determine the number of bits required to convert positive integer A to positive integer B.
//
//For example, you can change 31 to 14 by flipping the 4th and 0th bit:
//
// 31  0 0 0 1 1 1 1 1
// 14  0 0 0 0 1 1 1 0
//---  ---------------
//bit  7 6 5 4 3 2 1 0
//
//Thus 31 and 14 should return 2.


    public static int convertBits(int a, int b) {
//        System.out.println("a ="+Integer.toBinaryString(a));
//        System.out.println("b ="+Integer.toBinaryString(b));
//        System.out.println("r ="+Integer.toBinaryString(a ^ b));
//        System.out.println("c ="+Integer.bitCount(a ^ b));
        return Integer.bitCount(a ^ b);
    }

}
