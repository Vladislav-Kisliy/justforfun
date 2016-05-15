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
public class HumanReadableTime {

    public static String makeReadable(int seconds) {
        StringBuilder strBuf = new StringBuilder();
        int hours, min, sec;
        hours = seconds / 3600;
        min = (seconds - (hours * 3600)) / 60;
        sec = (seconds - ((hours * 3600) + min * 60));
        formatTime(hours, strBuf);
        strBuf.append(hours).append(":");
        formatTime(min, strBuf);
        strBuf.append(min).append(":");
        formatTime(sec, strBuf);
        strBuf.append(sec);
        return strBuf.toString();
    }

    private static void formatTime(int time, StringBuilder strBuf) {
        if (time < 10) {
            strBuf.append("0");
        }
    }

//    public static String makeReadable(int seconds) {
//        return String.format("%02d:%02d:%02d", seconds / 3600, (seconds / 60) % 60, seconds % 60);
//    }
}
