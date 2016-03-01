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
public class BouncingBall {

    public static int bouncingBall(double h, double bounce, double window) {
        int result = -1;
        if ((bounce < 1 && bounce > 0) && h > window
                && window > 0 && h > 0) {
            result = 1;
            h = h * bounce;
            while (h > window) {
                result += 2;
                h = h * bounce;
            }
        }
        return result;
    }
}
