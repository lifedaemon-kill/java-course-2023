package edu.project2;

import edu.project2.Generators.Kruskal;
import edu.project2.Interfaces.Generator;
import edu.project2.Interfaces.Solver;
import edu.project2.Solvers.RightHand;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import static edu.project2.Utility.Cell;
import static edu.project2.Utility.DEATH_STRING;
import static edu.project2.Utility.DEFAULT_MAZE_SIZE;
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

    public void setWidthHeightSeed(int width, int height, int seed) throws IOException {
        if ((width < 1) || (height < 1)) {
            throw new IOException("Incorrect parameters");
        }
        this.height = height;
        this.width = width;
        this.seed = seed;
    }

    public void setGrid(Cell[][] grid) {
        this.grid = grid;
    }

    public void setGenerator(GeneratorType type) throws IOException {
        if (Objects.requireNonNull(type) == GeneratorType.Kruskal) {
            this.generator = new Kruskal();
        } else {
            throw new IOException(NO_SUCH_TYPE_ERROR);
        }
    }

    public void setSolver(SolverType type) throws IOException {
        if (Objects.requireNonNull(type) == SolverType.RightHand) {
            this.solver = new RightHand();
        } else {
            throw new IOException(NO_SUCH_TYPE_ERROR);
        }
    }

    public void generateLabyrinth() {
        this.grid = generator.generate(this.width, this.height, this.seed);
    }

    private void printGrid(Cell[][] grid) {
        StringBuilder array = new StringBuilder();

        for (Cell[] cells : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                switch (cells[j]) {
                    case WAY -> array.append(WAY_STRING);
                    case WALL -> array.append(WALL_STRING);
                    case PASSAGE -> array.append(PASSAGE_STRING);
                    default -> array.append(DEATH_STRING);
                }
            }
            array.append("\n");
        }
        LOGGER.info("\n" + array);
    }

    public void print() throws Exception {
        if (grid == null) {
            throw new Exception(GRID_IS_EMPTY_ERROR);
        }
        printGrid(this.grid);
    }

    public void printWithSolving() throws Exception {
        if (grid == null) {
            throw new Exception(GRID_IS_EMPTY_ERROR);
        }
        Cell[][] solvedGrid;
        try {
            solvedGrid = solver.solve(grid);
        } catch (Exception e) {
            throw new Exception("Дaнный солвер не нашел решения эт☠го лабиринта!", e);
        }

        printGrid(solvedGrid);
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
