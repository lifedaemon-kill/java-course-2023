package edu.project2.Solvers;

import edu.project2.Interfaces.Solver;
import edu.project2.Utility.Cell;

public class RightHand implements Solver {
    @Override
    public Cell[][] solve(Cell[][] grid, int[] start, int[] end) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == Cell.PASSAGE) {
                    grid[i][j] = null;
                }
            }
        }
        return grid;
    }
}
