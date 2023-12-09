package edu.project2;

import edu.project2.Generators.Kruskal;
import edu.project2.Interfaces.Generator;
import edu.project2.Interfaces.Solver;
import edu.project2.Solvers.RightHand;
import java.util.Arrays;
import static edu.project2.Utility.Cell;
import static edu.project2.Utility.DEFAULT_MAZE_SIZE;
import static edu.project2.Utility.ERROR_STRING;
import static edu.project2.Utility.GRID_IS_EMPTY_ERROR;
import static edu.project2.Utility.GeneratorType;
import static edu.project2.Utility.LOGGER;
import static edu.project2.Utility.NO_SUCH_TYPE_ERROR;
import static edu.project2.Utility.PASSAGE_STRING;
import static edu.project2.Utility.SolverType;
import static edu.project2.Utility.WALL_STRING;
import static edu.project2.Utility.WAY_STRING;

public final class Labyrinth {

    private int height = DEFAULT_MAZE_SIZE;
    private int width = DEFAULT_MAZE_SIZE;

    private int seed = 0;
    private Cell[][] grid = null;
    private Generator generator = new Kruskal();
    private Solver solver = new RightHand();

    Labyrinth() {
    }

    public void setWidthHeightSeed(int height, int width, int seed) {
        if ((width < 1) || (height < 1)) {
            LOGGER.error("Incorrect parameters");
            return;
        }
        this.height = height;
        this.width = width;
        this.seed = seed;
    }

    public void setGrid(Cell[][] grid) {
        this.grid = grid;
    }

    public void setGenerator(GeneratorType type) {
        if (type == GeneratorType.Kruskal) {
            this.generator = new Kruskal();
        } else {
            LOGGER.error(NO_SUCH_TYPE_ERROR);
        }
    }

    public void setSolver(SolverType type) {
        if (type == SolverType.RightHand) {
            this.solver = new RightHand();
        } else {
            LOGGER.error(NO_SUCH_TYPE_ERROR);
        }
    }

    public void generateLabyrinth() {
        this.grid = generator.generate(this.height, this.width, this.seed);
    }

    public static void printGrid(Cell[][] grid) {
        StringBuilder array = new StringBuilder();

        for (Cell[] cells : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                switch (cells[j]) {
                    case WAY -> array.append(WAY_STRING);
                    case WALL -> array.append(WALL_STRING);
                    case PASSAGE -> array.append(PASSAGE_STRING);
                    case null, default -> array.append(ERROR_STRING);
                }
            }
            array.append("\n");
        }
        LOGGER.info("\n" + array);
    }

    public void print() {
        if (grid == null) {
            LOGGER.error(GRID_IS_EMPTY_ERROR);
            return;
        }
        printGrid(this.grid);
    }

    public void printWithSolving(int[] start, int[] end) {
        if (grid == null) {
            LOGGER.error(GRID_IS_EMPTY_ERROR);
            return;
        }
        Cell[][] solvedGrid;
        try {
            solvedGrid = solver.solve(grid, start, end);
            printGrid(solvedGrid);
        } catch (Exception e) {
            LOGGER.warn("That s☠lver couldn't solve this maze! So sad");
        }
    }

    public void printWithSolving() {
        printWithSolving(new int[] {1, 1}, new int[] {grid.length - 1, grid[0].length - 1});
    }

    public void help() {
        LOGGER.info("\nCurrent state:"
                    + "\n\nParameters:"
                    + "\n\tWidth: " + this.width
                    + "\n\tHeight: " + this.height
                    + "\n\tRand seed: " + this.seed
                    + "\n\nTypes implementations:"
                    + "\n\tGenerator: " + this.generator.getClass().getName()
                    + "\n\tSolver: " + this.solver.getClass().getName()
                    + "\n\nGenerators types: " + Arrays.toString(GeneratorType.values())
                    + "\nSolvers types: " + Arrays.toString(SolverType.values())
                    + "\n\nGrid:\n"
                    + Arrays.deepToString(this.grid)

        );
    }
}
