package edu.project2.Generators;

import edu.project2.Interfaces.Generator;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static edu.project2.Utility.Cell;

public class Kruskal implements Generator {
    @Override
    public Cell[][] generate(int width, int height, int seed) {
        Random random = new Random(seed);

        Cell[][] grid = new Cell[height][width];
        int[][] weight = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = Cell.WALL;
                weight[i][j] = random.nextInt( 10);
                System.out.print(weight[i][j] + " ");
            }
            System.out.println(1);
        }



        return grid;
    }
}
