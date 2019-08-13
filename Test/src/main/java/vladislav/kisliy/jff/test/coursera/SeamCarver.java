package vladislav.kisliy.jff.test.coursera;

import edu.princeton.cs.algs4.Picture;
import edu.princeton.cs.algs4.Topological;

import java.awt.*;

/**
 *
 * @author Vladislav Kisliy <vladislav.kisliy@gmail.com>
 */
public class SeamCarver {

    private static final double BORDER_ENERGY = 1000;
    private static final double MAX_ENERGY = Double.POSITIVE_INFINITY;
    private Picture picture;
    private boolean isChanged = false;
    private int height, width;
    private double[][] energyArr;
    private double[][] distTo;

    public SeamCarver(Picture picture) {
        if (picture == null) {
            throw new IllegalArgumentException();
        }
        this.picture = picture;
        width = picture.width();
        height = picture.height();
        energyArr = new double[height][width];
        refreshEnergy();
    }

    public Picture picture() {
        return picture;
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }

    public int[] findVerticalSeam() {
        if (isChanged) {
            refreshEnergy();
        }
        Seam minSeam = new Seam(new int[]{});
        minSeam.cost = MAX_ENERGY;
        for (int x = 0; x < width; x++) {
            Seam testSeam = getVertSeam(x, 0, null);
            if (minSeam.cost > testSeam.cost) {
                minSeam = testSeam;
            }
        }
        return minSeam.seam;
    }

    public int[] findHorizontalSeam() {
        if (isChanged) {
            refreshEnergy();
        }
        Seam minSeam = new Seam(new int[]{});
        minSeam.cost = MAX_ENERGY;
        for (int y = 0; y < height; y++) {
            Seam testSeam = getHorizSeam(0, y, null);
            if (minSeam.cost > testSeam.cost) {
                minSeam = testSeam;
            }
        }
        return new int[height];
    }

    public double energy(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            throw new IllegalArgumentException();
        }
        if (x == 0 || y == 0 || x == width - 1 || y == height - 1) {
            return BORDER_ENERGY;
        }
//        if (energyArr[y][x] != 0) {
//            return energyArr[y][x];
//        }
        return Math.sqrt(deltaSquare(picture.get(x + 1, y), picture.get(x - 1, y))
                + deltaSquare(picture.get(x, y + 1), picture.get(x, y - 1)));
    }

    public void removeVerticalSeam(int[] seam) {
        checkPosition(width, seam, height);
        isChanged = true;
        Picture newPicture = new Picture(width - 1, height);
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < seam[row]; col++) {
                newPicture.set(col, row, picture.get(col, row));
            }
            for (int col = seam[row] + 1; col < width; col++) {
                newPicture.set(col - 1, row, picture.get(col, row));
            }
        }
        picture = newPicture;
        width--;
    }

    public void removeHorizontalSeam(int[] seam) {
        checkPosition(height, seam, width);
        isChanged = true;
        Picture newPicture = new Picture(width, height - 1);
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < seam[col]; row++) {
                newPicture.set(col, row, picture.get(col, row));
            }
            for (int row = seam[col] + 1; row < height; row++) {
                newPicture.set(col, row - 1, picture.get(col, row));
            }
        }
        picture = newPicture;
        height--;
    }

    public static void main(String[] args) {
        System.out.println("start =" + Math.sqrt(5));
        System.out.println("finish =" + Math.pow(5, 2));
    }

    private double deltaSquare(Color a, Color b) {
        return square(a.getRed() - b.getRed())
                + square(a.getGreen() - b.getGreen())
                + square(a.getBlue() - b.getBlue());
    }

    private double square(double d) {
        return Math.pow(d, 2);
    }

    private void checkPosition(int dimension, int[] seam, int expectedLength) {
        if (dimension <= 1 || seam == null) {
            throw new IllegalArgumentException();
        }
        if (seam.length != expectedLength) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < seam.length - 1; i++) {
            if (Math.abs(seam[i] - seam[i + 1]) > 1) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void refreshEnergy() {
        energyArr = new double[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                energyArr[y][x] = energy(x, y);
//                System.out.printf("%.2f ", energyArr[y][x]);
            }
//            System.out.println("");
        }
        isChanged = false;
    }

    private Seam getVertSeam(int x, int y, Seam seam) {
        Seam result;
        if (seam == null) {
            result = new Seam(new int[height]);
        } else {
            result = seam;
        }
        result.seam[y] = x;
        result.cost = result.cost + energy(x, y);
        if (y == (height - 1)) {
            return result;
        }
        if (x == 0) {
            getVertSeam(getMinEnergyPositionByX(y + 1, x, x + 1), y + 1, result);
        } else if (x == (width - 1)) {
            getVertSeam(getMinEnergyPositionByX(y + 1, x, x - 1), y + 1, result);
        } else {
            getVertSeam(getMinEnergyPositionByX(y + 1, x - 1, x, x + 1), y + 1, result);
        }

        return result;
    }

    private int getMinEnergyPositionByX(int y, int... x) {
        int min = x[0];
        if (width == 1) {
            return min;
        }
//        System.out.println("energy =" + energy(min, y));
        for (int i = 1; i < x.length; i++) {
//            System.out.println("energy =" + energy(x[i], y));
            if (energy(min, y) > energy(x[i], y)) {
                min = x[i];
            }
        }
//        System.out.println("energy(min, y)" + energy(min, y));
        return min;
    }

    private Seam getHorizSeam(int x, int y, Seam seam) {
        Seam result;
        if (seam == null) {
            result = new Seam(new int[width]);
        } else {
            result = seam;
        }
        result.seam[x] = y;
        result.cost = result.cost + energy(x, y);
        if (x == (width - 1)) {
            return result;
        }
        if (y == 0) {
            getHorizSeam(x + 1, getMinEnergyPositionByY(x, y, y + 1), result);
        } else if (y == (height - 1)) {
            getHorizSeam(x + 1, getMinEnergyPositionByY(x, y, y - 1), result);
        } else {
            getHorizSeam(x + 1, getMinEnergyPositionByY(x, y - 1, y, y + 1), result);
        }

        return result;
    }

    private int getMinEnergyPositionByY(int x, int... y) {
        int min = y[0];
        if (height == 1) {
            return min;
        }
//        System.out.println("energy =" + energy(min, y));
        for (int i = 1; i < y.length; i++) {
//            System.out.println("energy =" + energy(x[i], y));
            if (energy(x, min) > energy(x, y[i])) {
                min = y[i];
            }
        }
//        System.out.println("energy(min, y)" + energy(min, y));
        return min;
    }

    private class Seam {

        private final int[] seam;
        private double cost = 0.0d;

        public Seam(int[] seam) {
            this.seam = seam;
        }
    }

}
