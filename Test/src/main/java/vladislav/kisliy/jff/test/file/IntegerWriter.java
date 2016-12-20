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

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vladislav Kislyi <vladislav.kisliy@gmail.com>
 */
public class IntegerWriter implements ArrayWriter<Integer> {

    private static final Logger LOG = Logger.getLogger(IntegerWriter.class.getName());

    public enum MODE {
        DataOutput, ObjectOutput, FileChannel
    };

    private final String fileName;
    private final MODE mode;

    public IntegerWriter(String fileName, MODE mode) {
        if (fileName == null) {
            throw new IllegalArgumentException();
        }
        this.fileName = fileName;
        this.mode = mode;
    }

    public IntegerWriter(String fileName) {
        this(fileName, MODE.FileChannel);
    }

    @Override
    public final void write(Integer[] arrayToWrite, boolean append) {
        switch (mode) {
            case DataOutput:
                writeWithDataOoutput(arrayToWrite, append);
                break;
            case FileChannel:
            default:
                writeWithFileChannel(arrayToWrite, append);
                break;
            case ObjectOutput:
                writeWithObjectOutput(arrayToWrite, append);
                break;
        }
    }

    @Override
    public void dropToFile(Collection<Integer> collection, boolean append,
            float clearFactor) {
        if (clearFactor < 0.0f || clearFactor > 1.0f) {
            throw new IllegalArgumentException();
        }
        ByteBuffer buffer = ByteBuffer.allocateDirect(
                ByteUtils.BYTE_MULTIPLIER * collection.size());
        int itemsToProcess = (int) (collection.size() * clearFactor);
        Collection processedItems = new ArrayList(itemsToProcess);
        int i = 0;
        for (Integer item : collection) {
            if (i < itemsToProcess) {
                buffer.putInt(item);
                processedItems.add(item);
            }
            i++;
        }
        collection.removeAll(processedItems);
        System.out.println("will drop to file =" + itemsToProcess
                + ", original collection size =" + collection.size());

        buffer.flip();
        try (FileOutputStream out = new FileOutputStream(fileName, append);
                FileChannel fileChannel = out.getChannel();) {
            LOG.log(Level.INFO, "write {0} int's", collection.size());
            while (buffer.hasRemaining()) {
                fileChannel.write(buffer);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            buffer.rewind();
            buffer.clear();
        }
    }

    private void writeWithDataOoutput(Integer[] arrayToWrite, boolean append) {
        try (DataOutputStream out = new DataOutputStream(
                new FileOutputStream(fileName, append))) {
            for (int anInt : arrayToWrite) {
                out.write(anInt);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeWithObjectOutput(Integer[] arrayToWrite, boolean append) {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(fileName, append));) {
            out.writeObject(arrayToWrite);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeWithFileChannel(final Integer[] arrayToWrite,
            final boolean append) {
        ByteBuffer buffer = ByteBuffer.allocateDirect(
                ByteUtils.BYTE_MULTIPLIER * arrayToWrite.length);
        for (int i : arrayToWrite) {
            buffer.putInt(i);
        }
        buffer.flip();
        try (FileOutputStream out = new FileOutputStream(fileName, append);
                FileChannel fileChannel = out.getChannel();) {
            LOG.log(Level.INFO, "write {0} int's", arrayToWrite.length);
            while (buffer.hasRemaining()) {
                fileChannel.write(buffer);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            buffer.rewind();
            buffer.clear();
        }
    }
}
