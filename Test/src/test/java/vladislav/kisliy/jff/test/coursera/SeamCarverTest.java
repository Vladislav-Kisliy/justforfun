package vladislav.kisliy.jff.test.coursera;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.princeton.cs.algs4.Picture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Vladislav Kisliy <vladislav.kisliy@gmail.com>
 */
public class SeamCarverTest {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of picture method, of class SeamCarver.
     */
    @Test
    public void testPicture() {
        String fileName = "/home/vlad/work/projects/school/algs/tasks/seam-carve/seam/6x5.png";
        Picture picture = new Picture(fileName);
        SeamCarver instance = new SeamCarver(picture);
        assertEquals(picture, instance.picture());
    }

    /**
     * Test of width method, of class SeamCarver.
     */
    @Test
    public void testWidthHeight() {
        String fileName = "/home/vlad/work/projects/school/algs/tasks/seam-carve/seam/6x5.png";
        Picture picture = new Picture(fileName);
        SeamCarver instance = new SeamCarver(picture);
        assertEquals(6, instance.width());
        assertEquals(5, instance.height());
    }

    /**
     * Test of findVerticalSeam method, of class SeamCarver.
     */
    @Test
    public void testFindVerticalSeam() {
        String fileName = "/home/vlad/work/projects/school/algs/tasks/seam-carve/seam/6x5.png";
        Picture picture = new Picture(fileName);
        SeamCarver1 instance = new SeamCarver1(picture);
        int[] expResult = new int[]{5,4,3,2,3};
        int[] result = instance.findVerticalSeam();
        assertArrayEquals(expResult, result);

        fileName = "/home/vlad/work/projects/school/algs/tasks/seam-carve/seam/1x8.png";
        picture = new Picture(fileName);
        instance = new SeamCarver1(picture);
        expResult = new int[8];
        result = instance.findVerticalSeam();
        assertArrayEquals(expResult, result);

        fileName = "/home/vlad/work/projects/school/algs/tasks/seam-carve/seam/7x10.png";
        picture = new Picture(fileName);
        instance = new SeamCarver1(picture);

        expResult = new int[]{4,3,4,3,4,3,3,2,2,3};
        result = instance.findVerticalSeam();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of findHorizontalSeam method, of class SeamCarver.
     */
    @Test
    public void testFindHorizontalSeam() {
        String fileName = "/home/vlad/work/projects/school/algs/tasks/seam-carve/seam/6x5.png";
        Picture picture = new Picture(fileName);
        SeamCarver instance = new SeamCarver(picture);
        int[] expResult = new int[]{3, 2, 1, 2, 1, 2};
        int[] result = instance.findHorizontalSeam();
        assertArrayEquals(expResult, result);

        fileName = "/home/vlad/work/projects/school/algs/tasks/seam-carve/seam/1x8.png";
        picture = new Picture(fileName);
        instance = new SeamCarver(picture);
        expResult = new int[]{7};
        result = instance.findHorizontalSeam();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of energy method, of class SeamCarver.
     */
    @Test
    public void testEnergy() {
        String fileName = "/home/vlad/work/projects/school/algs/tasks/seam-carve/seam/6x5.png";
        Picture picture = new Picture(fileName);
        SeamCarver instance = new SeamCarver(picture);
        assertEquals(1000d, instance.energy(0, 0), 0.0);
        assertEquals(237.347845, instance.energy(1, 1), 3.0);
        assertEquals(228.10, instance.energy(2, 2), 2.0);
        double energy = instance.energy(4, 1);
        assertEquals(107.89, energy, 2.0);

        fileName = "/home/vlad/work/projects/school/algs/tasks/seam-carve/seam/1x8.png";
        picture = new Picture(fileName);
        instance = new SeamCarver(picture);
        assertEquals(1000d, instance.energy(0, 0), 0.0);
        assertEquals(1000d, instance.energy(0, 1), 3.0);
        assertEquals(1000d, instance.energy(0, 7), 2.0);
    }

    /**
     * Test of removeVerticalSeam method, of class SeamCarver.
     */
    @Test
    public void testRemoveVerticalSeam() {
        String fileName = "/home/vlad/work/projects/school/algs/tasks/seam-carve/seam/6x5.png";
        Picture picture = new Picture(fileName);
        SeamCarver instance = new SeamCarver(picture);

        int[] seam = new int[]{1, 2, 1, 2, 3};
        instance.removeVerticalSeam(seam);

        assertEquals(5, instance.width());
        assertEquals(5, instance.height());

        fileName = "/home/vlad/work/projects/school/algs/tasks/seam-carve/seam/5x6.png";
        picture = new Picture(fileName);
        instance = new SeamCarver(picture);

        seam = new int[]{1, 2, 2, 3, 2, 1};
        instance.removeVerticalSeam(seam);

        assertEquals(4, instance.width());
        assertEquals(6, instance.height());
//        int[][] red = instance.getRed();
//        for (int i = 0; i < red.length; i++) {
//            for (int j = 0; j < red[i].length; j++) {
//                System.out.println("[" + i + "][" + j + "] =" + red[i][j]);
//
//            }
//
//        }
//        System.out.println("Array =" + Arrays.toString(instance.getRed()));
//        assertArrayEquals(new int[][]{}, instance.getRed());

        Picture testPic = instance.picture();
        assertEquals(4, testPic.width());
        assertEquals(6, testPic.height());
    }

//    @Test
//    public void testGetVerticalSeam() {
//        String fileName = "/home/vlad/work/projects/school/algs/tasks/seam-carve/seam/6x5.png";
//        Picture picture = new Picture(fileName);
//        SeamCarver instance = new SeamCarver(picture);
//
//        System.out.println("--------------");
//        assertEquals(4, instance.getMinEnergyPosition(1, 2, 3, 4));
//        System.out.println("--------------");
//        SeamCarver.Seam vertSeam = instance.getVertSeam(3, 0, null);
//        assertEquals(2414.973495, vertSeam.cost, 2.0);
//        assertArrayEquals(new int[]{3, 4, 3, 2, 1}, vertSeam.seam);
//        int[] seam = new int[]{1, 2, 1, 2, 3};
//        instance.removeVerticalSeam(seam);
//
//        assertEquals(5, instance.width());
//        assertEquals(5, instance.height());
//
//        fileName = "/home/vlad/work/projects/school/algs/tasks/seam-carve/seam/5x6.png";
//        picture = new Picture(fileName);
//        instance = new SeamCarver(picture);
//
//        assertEquals(2, instance.getMinEnergyPosition(2, 2, 3, 4));
//
//        seam = new int[]{1, 2, 2, 3, 2, 1};
//        instance.removeVerticalSeam(seam);
//
//        assertEquals(4, instance.width());
//        assertEquals(6, instance.height());
////        int[][] red = instance.getRed();
////        for (int i = 0; i < red.length; i++) {
////            for (int j = 0; j < red[i].length; j++) {
////                System.out.println("[" + i + "][" + j + "] =" + red[i][j]);
////
////            }
////
////        }
////        System.out.println("Array =" + Arrays.toString(instance.getRed()));
////        assertArrayEquals(new int[][]{}, instance.getRed());
//
//        Picture testPic = instance.picture();
//        assertEquals(4, testPic.width());
//        assertEquals(6, testPic.height());
//    }
    /**
     * Test of removeHorizontalSeam method, of class SeamCarver.
     */
    @Test
    public void testRemoveHorizontalSeam() {
        String fileName = "/home/vlad/work/projects/school/algs/tasks/seam-carve/seam/6x5.png";
        Picture picture = new Picture(fileName);
        SeamCarver instance = new SeamCarver(picture);

        int[] seam = new int[]{1, 2, 1, 1, 2, 3};
        instance.removeHorizontalSeam(seam);

        assertEquals(6, instance.width());
        assertEquals(4, instance.height());

        Picture testPic = instance.picture();
        assertEquals(6, testPic.width());
        assertEquals(4, testPic.height());
    }

}
