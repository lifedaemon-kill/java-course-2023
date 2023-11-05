package edu.project2.Generators;

import edu.project2.Classes.Edge;
import edu.project2.Classes.UnionFind;
import edu.project2.Interfaces.Generator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import static edu.project2.Utility.Cell;

public class Kruskal implements Generator {
    @Override
    public Cell[][] generate(int halfHeight, int halfWidth, long seed) {
        int height = halfHeight << 1;
        int width = halfWidth << 1;

        Random random = new Random(seed);
        Cell[][] grid = Generator.getFrame(height, width); //Квадрат заполненный стенами
        final int[][] WEIGHT = Generator.getWeights(height, width, seed); //Массив весов

        //Создание рёбер
        List<Edge> edges = new ArrayList<>();

        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    // Добавляем ребро сверху
                    edges.add(new Edge(i, j, i - 1, j, WEIGHT[i - 1][j]));
                    // Добавляем ребро слева
                    edges.add(new Edge(i, j, i, j - 1, WEIGHT[i][j - 1]));
                }
            }
        }

        //Построение минимального остового дерева
        Collections.shuffle(edges);
        UnionFind unionFind = new UnionFind(height * width);

        for (Edge edge : edges) {
            int root1 = unionFind.find(edge.row1 * width + edge.col1);
            int root2 = unionFind.find(edge.row2 * width + edge.col2);

            if (root1 != root2) {
                unionFind.union(root1, root2);
                if (edge.row1 == edge.row2) {
                    // Удаляем стену по горизонтали
                    grid[edge.row1][Math.min(edge.col1, edge.col2)] = Cell.PASSAGE;
                } else {
                    // Удаляем стену по вертикали
                    grid[Math.min(edge.row1, edge.row2)][edge.col1] = Cell.PASSAGE;
                }
            }
        }

        return grid;
    }

}
