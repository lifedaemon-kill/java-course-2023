package edu.project2;

import edu.project2.Generators.Kruskal;
import edu.project2.Interfaces.Generator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.project2.Utility.Cell;

public class GeneratorsTest {
    @Test
    @DisplayName("Визуализация сгенерированного фрейма")
    void test1() {
        //Arrange
        Labyrinth maze = new Labyrinth();
        int width = 6;
        int height = 10;
        //Act
        Cell[][] grid = Generator.getFrame(height, width);
        maze.setGrid(grid);
        //Assert
        maze.print();
    }

    @Test
    @DisplayName("Визуализация сгенерированных весов")
    void test2() {
        //Arrange
        int width = 20;
        int height = 10;

        // Act
        int[][] grid = Generator.getWeights(height, width, 0);

        //Assert
        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    @Test
    @DisplayName("Визуализация Краскала")
    void test3() {
        //Arrange
        int w = 5;
        int h = 5;
        //Act
        Generator generator = new Kruskal();

        Cell[][] grid = generator.generate(h, w, 0);

        //Assert
        Labyrinth.printGrid(grid);
    }

}
