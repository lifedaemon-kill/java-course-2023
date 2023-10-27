package edu.project2.Interfaces;

import edu.project2.Utility.Cell;

public interface Solver {
    Cell[][] solve(Cell[][] grid, int[] start, int[] end);
}
