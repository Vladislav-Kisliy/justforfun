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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vladislav Kislyi <vladislav.kisliy@gmail.com>
 */
public class IntegerFileProcessor implements FileProcessor<Integer> {

    private static final Logger LOG = Logger.getLogger(IntegerFileProcessor.class.getName());
    /**
     * Multiplier for change bytes to integer
     */
    public static final int BYTE_MULTIPLIER = 4;

    private final String fileName;

    /**
     * Initializes filename. Throws IllegalArgumentException for null filename.
     *
     * @param fileName
     */
    public IntegerFileProcessor(String fileName) {
        if (fileName == null) {
            throw new IllegalArgumentException();
        }
        this.fileName = fileName;
    }

    @Override
    public boolean isSorted() {
        boolean result = true;
        try (RandomAccessFile randomFile = new RandomAccessFile(fileName, "r");
                FileChannel fileChannel = randomFile.getChannel()) {
            MappedByteBuffer buffer = fileChannel
                    .map(FileChannel.MapMode.READ_ONLY, 0, randomFile.length());
            int beforeValue = buffer.getInt();
            for (int i = 1; i < randomFile.length() / BYTE_MULTIPLIER; i++) {
                int newValue = buffer.getInt();
                if (i < 10) {
                    LOG.log(Level.INFO, "[{0}] ={1}", new Object[]{i, newValue});
                }
                if (beforeValue > newValue) {
                    result = false;
                    LOG.log(Level.INFO, "before ={0}, new ={1}", new Object[]{beforeValue, newValue});
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
        if (start < end) {
            try (RandomAccessFile randomFile = new RandomAccessFile(fileName, "r");
                    FileChannel fileChannel = randomFile.getChannel();) {

                int arraySize = end - start;
                long fileSize = randomFile.length();
                long bufferSize = arraySize * BYTE_MULTIPLIER;
                long bufferStartPositition = start * BYTE_MULTIPLIER;

                if (fileSize < bufferSize + bufferStartPositition) {
                    bufferSize = fileSize - bufferStartPositition;
                    arraySize = (int) (bufferSize / BYTE_MULTIPLIER);
                }

                MappedByteBuffer buffer = fileChannel.map(
                        FileChannel.MapMode.READ_ONLY, bufferStartPositition, bufferSize);
                result = new Integer[arraySize];
                for (int i = 0; i < arraySize; i++) {
                    result[i] = buffer.getInt();
                }
                buffer.clear();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return result;
    }
}
