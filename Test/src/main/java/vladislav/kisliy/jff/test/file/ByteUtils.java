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
package vladislav.kisliy.jff.test.file;

/**
 *
 * @author Vladislav Kislyi <vladislav.kisliy@gmail.com>
 */
public class ByteUtils {
    
    public static final int BYTE_MULTIPLIER = 4;
    
    /**
     * Calculates amount integer elements in bytes.
     * @param bytes
     * @return 
     */
    public static int bytesToInt(long bytes) {
        return (int) (bytes / BYTE_MULTIPLIER);
    }
    
    /**
     * Calculates amount bytes in integer elements.
     * @param bytes
     * @return 
     */
    public static long intToBytes(int ints) {
        return ints * BYTE_MULTIPLIER;
    }
    
}
