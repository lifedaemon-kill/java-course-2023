package edu.project2.Generators;

import edu.project2.Interfaces.Generator;
import static edu.project2.Utility.Cell;

public class Kruskal implements Generator {
    @Override
    public Cell[][] generate(int height, int width, int seed) {
        Cell[][] grid = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = Cell.PASSAGE;
            }
        }
        for (int i = 0; i < height; i++) {
            grid[i][0] = Cell.WALL;
            grid[i][width - 1] = Cell.WALL;
        }
        for (int i = 0; i < width; i++) {
            grid[0][i] = Cell.WALL;
            grid[height - 1][i] = Cell.WALL;
        }
        return grid;
    }
}
