package edu.project2;

import java.io.IOException;
import static edu.project2.Utility.GeneratorType;
import static edu.project2.Utility.LOGGER;
import static edu.project2.Utility.SolverType;
import static edu.project2.Utility.input;

public class Main {
    private Main() {
    }

    private static final String MENU = """

        Введите параметр:
        \t0 или exit для выхода
        \t1 Генерация лабиринта
        \t2 Вывод текущего лабиринта
        \t3 Вывод решения лабиринта
        \t4 Изменить width height seed
        \t5 Изменить тип генератора
        \t6 Изменить тип солвера
        \thelp Текущие и возможные значения""";

    public static void main(String[] args) {
        int width;
        int heigth;
        int seed;
        Labyrinth maze = new Labyrinth();
        maze.help();
        GeneratorType generatorType;
        SolverType solverType;
        String choice;
        while (true) {
            LOGGER.info(MENU);
            choice = input.next();

            switch (choice) {
                case "exit", "0":
                    return;
                case "help":
                    maze.help();
                    break;
                case "1":
                    maze.generateLabyrinth();
                    break;
                case "2":
                    try {
                        maze.print();
                    } catch (Exception e) {
                        LOGGER.error(e.getMessage(), e);
                    }
                    break;
                case "3":
                    try {
                        maze.printWithSolving();
                    } catch (Exception e) {
                        LOGGER.error(e.getMessage(), e);
                    }
                    break;
                case "4":
                    LOGGER.info("Введите ширину, высоту, семя генерации");
                    width = input.nextInt();
                    heigth = input.nextInt();
                    seed = input.nextInt();
                    try {
                        maze.setWidthHeightSeed(width, heigth, seed);
                    } catch (IOException e) {
                        LOGGER.error(e.getMessage(), e);
                    }
                    break;
                case "5":
                    try {
                        generatorType = GeneratorType.valueOf(input.next());
                        maze.setGenerator(generatorType);

                    } catch (IOException e) {
                        LOGGER.error(e.getMessage(), e);
                    }
                    break;
                case "6":
                    try {
                        solverType = SolverType.valueOf(input.next());
                        maze.setSolver(solverType);
                    } catch (IOException e) {
                        LOGGER.error(e.getMessage(), e);
                    }
                    break;
                default:
                    LOGGER.warn("Такой команды нет, попробуйте снова");
            }
        }
    }

}
