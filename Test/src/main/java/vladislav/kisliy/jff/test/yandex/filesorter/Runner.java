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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.concurrent.ThreadLocalRandom;
import vladislav.kisliy.jff.test.file.ArrayWriter;
import vladislav.kisliy.jff.test.file.IntegerFileProcessor;
import vladislav.kisliy.jff.test.file.IntegerWriter;
import vladislav.kisliy.jff.test.file.FileProcessor;
import vladislav.kisliy.jff.test.yandex.AbstractSorter;

/**
 *
 * @author Vladislav Kislyi <vladislav.kisliy@gmail.com>
 */
public class Runner {

    private static final String FILENAME = "/home/vlad/work/projects/school/int_array.bin";
    private static final String FILENAME_SORTED = "/home/vlad/work/projects/school/int_array_sorted.bin";
    private static final int ARRAY_SIZE = 1000000;
    private static final Integer[] INT_ARRAY = new Integer[ARRAY_SIZE];

//[0] =-1940555382
//[1] =-580986085
//[2] =-1185124619
//[3] =786967555
//[4] =516383094
//[5] =-1048790535
//[6] =1183928797
//[7] =-419477397
//[8] =-840568530
//[9] =-1599058773
    public static void main(String[] args) throws FileNotFoundException, IOException {
//        generateUnsortedFile();
//        RandomAccessFile input =new RandomAccessFile(FILENAME_SORTED, "r");
////        long length = new File(FILENAME_SORTED).length();
//        MappedByteBuffer in = input
//                .getChannel().map(FileChannel.MapMode.READ_ONLY, 0, input.length());
//        
//        for (int i = 0; i < input.length(); i+=4) {
//            System.out.println(in.getInt());
//        }
//        int i = 0;
//        while (i < input.length()) {
//            System.out.println(in.getInt());
//            i+=4;
//        }
//        generateSortedFile();
//
//        checkFile();
    }

    private static void checkFile() {
        FileProcessor<Integer> fileChecker = new IntegerFileProcessor(FILENAME_SORTED);
        System.out.println("isSorted =" + fileChecker.isSorted());
        System.out.println("array =" + Arrays.toString(fileChecker.fillArray(2, 10)));
    }

    private static void generateSortedFile() {
        ArrayWriter<Integer> arrayWriter = new IntegerWriter(FILENAME_SORTED + "_new");
        Integer[] sortedArray = new Integer[5500];
        for (int i = 0; i < sortedArray.length; i++) {
            sortedArray[i] = i;

        }
        arrayWriter.write(sortedArray, false);
    }

    private static void generateUnsortedFile() {
        ArrayWriter<Integer> arrayWriter = new IntegerWriter(FILENAME + "_new");
//                IntegerWriter.MODE.DataOutput);

        initArray();
        arrayWriter.write(INT_ARRAY, false);
        initArray();
        arrayWriter.write(INT_ARRAY, true);
        initArray();
        arrayWriter.write(INT_ARRAY, true);
        initArray();
        arrayWriter.write(INT_ARRAY, true);
    }

    private static void initArray() {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            INT_ARRAY[i] = ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
            if (i < 10) {
                System.out.println("[" + i + "] =" + INT_ARRAY[i]);
            }
        }
    }
}
