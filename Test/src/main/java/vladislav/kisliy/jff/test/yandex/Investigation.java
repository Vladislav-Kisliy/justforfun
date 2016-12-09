/*
 * Copyright (C) 2016 Vladislav Kislyi <vladislav.kisliy@gmail.com>
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
package vladislav.kisliy.jff.test.yandex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Vladislav Kislyi <vladislav.kisliy@gmail.com>
 */
public class Investigation {
    
    public static void main(String s[]) throws Exception {
        System.out.println(" 0 hex="+Integer.toHexString(0)+", bin ="+Integer.toBinaryString(0));
        System.out.println("-0 hex="+Integer.toHexString(-0)+", bin ="+Integer.toBinaryString(-0));
        System.out.println(" 1 hex="+Integer.toHexString(1)+", bin ="+Integer.toBinaryString(1));
        System.out.println("-1 hex="+Integer.toHexString(-1)+", bin ="+Integer.toBinaryString(-1));
        System.out.println(" 2 hex="+Integer.toHexString(2)+", bin ="+Integer.toBinaryString(2));
        System.out.println("-2 hex="+Integer.toHexString(-2)+", bin ="+Integer.toBinaryString(-2));
        System.out.println("10 hex="+Integer.toHexString(10)+", bin ="+Integer.toBinaryString(10));
        System.out.println("-10hex="+Integer.toHexString(-10)+", bin ="+Integer.toBinaryString(-10));
        System.out.println("11 hex="+Integer.toHexString(11)+", bin ="+Integer.toBinaryString(11));
        System.out.println("-11hex="+Integer.toHexString(-11)+", bin ="+Integer.toBinaryString(-11));
        System.out.println(" 65535 hex="+Integer.toHexString(65535)+", bin ="+Integer.toBinaryString(65535));
        System.out.println("-65535 hex="+Integer.toHexString(-65535)+", bin ="+Integer.toBinaryString(-65535));
        
        System.out.println("max hex="+Integer.toHexString(Integer.MAX_VALUE)+", bin ="+Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println("min hex="+Integer.toHexString(Integer.MIN_VALUE)+", bin ="+Integer.toBinaryString(Integer.MIN_VALUE));
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
    }
    
}
