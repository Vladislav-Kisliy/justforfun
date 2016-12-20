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
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import vladislav.kisliy.jff.test.file.IntegerFileProcessor;

/**
 *
 * @author Vladislav Kislyi <vladislav.kisliy@gmail.com>
 */
public class FileSorterTest {

    private static final String FILENAME = "/home/vlad/work/projects/school/int_array.bin";
    private static final String FILENAME_OUTPUT = "/tmp/sort_result.bin";
    private static final String FILENAME_SORTED = "/home/vlad/work/projects/school/int_array_sorted.bin";

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of sort method, of class FileSorter.
     */
    @Test
    public void testSort() {
        FileSorter instance = new FileSorter(FILENAME, FILENAME_OUTPUT);
        instance.sort();
        System.out.println("--- instance =" + instance);
//        IntegerFileProcessor fileProcessor = new IntegerFileProcessor(FILENAME_OUTPUT);
//        assertTrue(fileProcessor.isSorted());



//        IntegerFileProcessor fileProcessor = new IntegerFileProcessor("/tmp/sorter3039597417742046722.tmp");
//        assertTrue(fileProcessor.isSorted());
//        fileProcessor = new IntegerFileProcessor("/tmp/sorter5856772753534757716.tmp");
//        assertTrue(fileProcessor.isSorted());
//        fileProcessor = new IntegerFileProcessor("/tmp/sorter305616671080967439.tmp");
//        assertTrue(fileProcessor.isSorted());
//        fileProcessor = new IntegerFileProcessor("/tmp/sorter551540609136979728.tmp");
//        assertTrue(fileProcessor.isSorted());

    }
    

    /**
     * Test of mergeSortedFiles method, of class FileSorter.
     */
    @Test
    public void testMergeSortedFiles() {
        List<File> splitFiles = new ArrayList<>();
        splitFiles.add(new File("/tmp/sorter3039597417742046722.tmp"));
        splitFiles.add(new File("/tmp/sorter5856772753534757716.tmp"));
        splitFiles.add(new File("/tmp/sorter305616671080967439.tmp"));
        splitFiles.add(new File("/tmp/sorter551540609136979728.tmp"));
        FileSorter instance = new FileSorter(FILENAME, FILENAME_OUTPUT);
        instance.mergeSortedFiles(splitFiles);

        IntegerFileProcessor fileProcessor = new IntegerFileProcessor(FILENAME_OUTPUT);
        assertTrue(fileProcessor.isSorted());
    }
}
