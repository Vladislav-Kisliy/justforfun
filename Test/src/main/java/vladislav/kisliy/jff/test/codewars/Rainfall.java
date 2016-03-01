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
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Rainfall {

    public static double mean(String town, String strng) {
        if (town == null || strng == null) {
            return 0d;
        }
        double[] townTemp = getTownTemp(town, strng);
        if (townTemp.length == 0) {
            return -1d;
        }
        return Arrays.stream(townTemp).average().getAsDouble();
    }

    public static double variance(String town, String strng) {
        if (town == null || strng == null) {
            return 0d;
        }
        double[] townTemp = getTownTemp(town, strng);
        if (townTemp.length == 0) {
            return -1d;
        }
        double average = Arrays.stream(townTemp).average().getAsDouble();
        double variance = Arrays.stream(townTemp)
                .map(p -> (p - average) * (p - average))
                .sum() / townTemp.length;
        return variance;
    }

    private static double[] getTownTemp(String town, String strng) {
        String[] lines = strng.split("\n");
        String resultLine = null;
        for (String line : lines) {
            if (line.startsWith(String.format("%s:", town))) {
                resultLine = line;
                break;
            }
        }
        // find doubles
        List<Double> temps = new ArrayList<>();
        if (resultLine != null) {
            resultLine = resultLine.replace(',', ' ');
            Scanner scanner = new Scanner(resultLine);
            while (scanner.hasNext()) {
                if (scanner.hasNextDouble()) {
                    temps.add(scanner.nextDouble());
                } else {
                    scanner.next();
                }
            }
        }
        // Convert list to array
        double[] resultArray = new double[temps.size()];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = temps.get(i);
        }
        return resultArray;
    }
}
