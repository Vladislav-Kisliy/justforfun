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

import java.util.NavigableSet;
import java.util.TreeSet;

/**
 *
 * @author vlad
 */
public class Kata {

    public static boolean validPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\(\\d{3}\\) \\d{3}-\\d{4}");
        // TODO: Return whether phoneNumber is in the proper form
        //validate phone numbers of format "1234567890"
//        if (phoneNumber.matches("\\d{10}")) return true;
//        //validating phone number with -, . or spaces
//        else if(phoneNumber.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) return true;
//        //validating phone number with extension length from 3 to 5
//        else if(phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) return true;
//        //validating phone number where area code is in braces ()
//        else if(phoneNumber.matches("\\(\\d{3}\\) \\d{3}-\\d{4}")) return true;
//        //return false if nothing matches the input
//        else return false;
    }

    public static String HighAndLow(String numbers) {
        NavigableSet<Integer> set = new TreeSet<>();
        for (String element :  numbers.split(" ")) {
            set.add(Integer.valueOf(element));
        }
        return set.last() + " " + set.first();
    }

}
