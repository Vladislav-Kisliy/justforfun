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
package vladislav.kisliy.jff.test.yandex.filesorter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import vladislav.kisliy.jff.test.file.ArrayWriter;
import vladislav.kisliy.jff.test.file.ByteUtils;
import vladislav.kisliy.jff.test.file.IntegerFileProcessor;
import vladislav.kisliy.jff.test.file.IntegerWriter;
import vladislav.kisliy.jff.test.yandex.MergeSort;
import vladislav.kisliy.jff.test.yandex.Sorter;

/**
 * Sorts and removes duplicates integers in restricted memory environment.
 * Only for learning.
 * @author Vladislav Kislyi <vladislav.kisliy@gmail.com>
 */
public class FileSorter {

    private static final Logger LOG = Logger.getLogger(FileSorter.class.getName());

    public final static int DEFAULT_ARRAY_SIZE = 1000000;
    public final static float DEFAULT_CLEAR_FACTOR = 0.85f;
    private final int maxArraySize;
    private final String fileInput;
    private final String fileOutput;
    private final Sorter sorter = new MergeSort();

    public FileSorter(int maxArraySize, String fileInput, String fileOutput) {
        this.maxArraySize = maxArraySize;
        this.fileInput = fileInput;
        this.fileOutput = fileOutput;
    }

    public FileSorter(String fileInput, String fileOutput) {
        this(DEFAULT_ARRAY_SIZE, fileInput, fileOutput);
    }

    public final void sort() {
        File fileIn = new File(fileInput);
        List<File> splitFiles = sortAndSplit(ByteUtils.bytesToInt(fileIn.length()));
//        List<File> splitFiles = new ArrayList<>();
//        splitFiles.add(new File("/tmp/sorter3039597417742046722.tmp"));
//        splitFiles.add(new File("/tmp/sorter5856772753534757716.tmp"));
//        splitFiles.add(new File("/tmp/sorter305616671080967439.tmp"));
//        splitFiles.add(new File("/tmp/sorter551540609136979728.tmp"));
        mergeSortedFiles(splitFiles);
    }

    private List<File> sortAndSplit(int amountElements) {
        List<File> result = new ArrayList<>();
        
        ArrayWriter writer = null;
        IntegerFileProcessor fileProcessor = new IntegerFileProcessor(fileInput);
        for (int i = 0; i < amountElements / maxArraySize; i++) {
            LOG.log(Level.INFO, "i ={0} [{1}-{2}]", new Object[]{i, i * maxArraySize, (i + 1) * maxArraySize});
            Integer[] array = fileProcessor.fillArray(i * maxArraySize, (i + 1) * maxArraySize);
            Arrays.sort(array);
//            sorter.sort(array);
            try {
                File createTempFile = File.createTempFile("sorter-", null, new File("/tmp"));
                writer = new IntegerWriter(createTempFile.getAbsolutePath());
                writer.write(array, false);
                result.add(createTempFile);
            } catch (IOException ex) {
                LOG.log(Level.SEVERE, "sortAndSplit", ex);
                throw new RuntimeException(ex);
            }
        }
        return result;
    }

    public void mergeSortedFiles(List<File> files) {
        final int elementsInArray = DEFAULT_ARRAY_SIZE / files.size();
        ArrayWriter writer = new IntegerWriter(fileOutput);
        int i = 0;
        boolean appendMode = false;
        Set<Integer> set = new TreeSet<>();
        while (i < files.size()) {
            for (File file : files) {
                LOG.log(Level.INFO, "Read from {0}", file.getAbsolutePath());
                IntegerFileProcessor fileProcessor = 
                        new IntegerFileProcessor(file.getAbsolutePath());
                Integer[] array = fileProcessor
                        .fillArray(i * elementsInArray, (i + 1) * elementsInArray);
                set.addAll(transformArrayToSet(array));
            }
            writer.dropToFile(set, appendMode, DEFAULT_CLEAR_FACTOR);
            i++;
            appendMode = true;
        }
        LOG.log(Level.INFO, "Last piece {0} items", set.size());
        writer.dropToFile(set, true, 1.0f);
    }

    private Set<Integer> transformArrayToSet(Integer[] array) {
        Set<Integer> result = new TreeSet<>();
        result.addAll(Arrays.asList(array));
        return result;
    }
}
