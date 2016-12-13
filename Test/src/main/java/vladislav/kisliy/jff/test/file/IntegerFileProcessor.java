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

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 *
 * @author Vladislav Kislyi <vladislav.kisliy@gmail.com>
 */
public class IntegerFileProcessor implements FileProcessor<Integer> {

    public static final int BYTE_MULTIPLIER = 4;
    public static final int MAX_BUFFER_SIZE = 1024;

    private final String fileName;

    public IntegerFileProcessor(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public boolean isSorted() {
        boolean result = true;
        try (RandomAccessFile randomFile = new RandomAccessFile(fileName, "r");
                FileChannel fileChannel = randomFile.getChannel();) {

            MappedByteBuffer buffer = fileChannel
                    .map(FileChannel.MapMode.READ_ONLY, 0, randomFile.length());
            int beforeValue = buffer.getInt();
            for (int i = BYTE_MULTIPLIER; i < randomFile.length(); i += BYTE_MULTIPLIER) {
                int newValue = buffer.getInt();
                if (i < BYTE_MULTIPLIER * 10) {
                    System.out.println("[" + i / BYTE_MULTIPLIER + "] =" + newValue);
                }
                if (beforeValue > newValue) {
                    result = false;
                    System.out.println("before =" + beforeValue + ", new =" + newValue);
                    break;
                }
                beforeValue = newValue;
            }
            buffer.clear();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public Integer[] fillArray(int start, int end) {
        Integer[] result = null;
        try (RandomAccessFile randomFile = new RandomAccessFile(fileName, "r");
                FileChannel fileChannel = randomFile.getChannel();) {
            int length = end - start;
            MappedByteBuffer buffer = fileChannel
                    .map(FileChannel.MapMode.READ_ONLY, start * BYTE_MULTIPLIER, length * BYTE_MULTIPLIER);
            result = new Integer[length];
            for (int i = 0; i < length; i++) {
                result[i] = buffer.getInt();
            }
            buffer.clear();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
