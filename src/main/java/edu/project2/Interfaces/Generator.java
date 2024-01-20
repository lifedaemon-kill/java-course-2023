package edu.project2.Interfaces;

import edu.project2.Utility.Cell;
import java.util.Random;
import static edu.project2.Utility.MAX_WEIGHT;

public interface Generator {
    Cell[][] generate(int height, int width, long seed);

    static Cell[][] getFrame(int height, int width) {
        Cell[][] grid = new Cell[height][width];
        /*
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                    grid[i][j] = Cell.WALL;
                } else {
                    grid[i][j] = Cell.PASSAGE;
                }
            }
        }
         */
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = Cell.WALL;
            }
        }

        return grid;
    }

    static int[][] getWeights(int height, int width, long seed, int minWeight, int maxWeight) {
        Random random = new Random(seed);
        int[][] weight = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                weight[i][j] = random.nextInt(minWeight, maxWeight);
            }
        }

        return weight;
    }

    static int[][] getWeights(int height, int width, long seed) {
        return Generator.getWeights(height, width, seed, 0, MAX_WEIGHT);
    }
}
