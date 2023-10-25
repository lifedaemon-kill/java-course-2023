package edu.project2;

import java.io.IOException;
import static edu.project2.Utility.GeneratorType;
import static edu.project2.Utility.LOGGER;
import static edu.project2.Utility.SolverType;
import static edu.project2.Utility.input;

public class Main {
    private Main() {
    }

    private static final String MENU = "\nВведите параметр:"
                                       + "\n\t0 или exit для выхода"
                                       + "\n\t1 Генерация лабиринта"
                                       + "\n\t2 Вывод текущего лабиринта"
                                       + "\n\t3 Вывод решения лабиринта"
                                       + "\n\t4 Изменить width height seed"
                                       + "\n\t5 Изменить тип генератора"
                                       + "\n\t6 Изменить тип солвера"
                                       + "\n\thelp Текущие и возможные значения";


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
                    maze.print();
                    break;
                case "3":
                    maze.printWithSolving();
                    break;
                case "4":
                    LOGGER.info("Введите ширину, высоту, семя генерации");
                    width = input.nextInt();
                    heigth = input.nextInt();
                    seed = input.nextInt();
                    try {
                        maze.setWidthHeightSeed(width, heigth, seed);
                    } catch (IOException e) {
                        LOGGER.error(e.getMessage());
                    }
                    break;
                case "5":
                    try {
                        generatorType = GeneratorType.valueOf(input.next());
                        maze.setGenerator(generatorType);

                    } catch (IOException e) {
                        LOGGER.error(e.getMessage());
                    }
                    break;
                case "6":
                    try {
                        solverType = SolverType.valueOf(input.next());
                        maze.setSolver(solverType);
                    } catch (IOException e) {
                        LOGGER.error(e.getMessage());
                    }
                    break;
                default:
                    LOGGER.warn("Такой команды нет, попробуйте снова");
            }
        }
    }

}
